package edu.upc.dsa.services;
import edu.upc.dsa.GameManager;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Equipo;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.Producto;
import edu.upc.dsa.models.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/dsaApp", description = "Endpoint to Game Service")
@Path("/users")
public class GameService {

    private GameManager manager;

    public GameService() {
        this.manager = GameManagerImpl.getInstance();
    }

    @POST
    @ApiOperation(value = "Crea un juego nuevo", notes = "Si no existe pues lo crea")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Creada con exito", response= Partida.class),
            @ApiResponse(code = 409, message = "Ya existe un juego")

    })
    @Path("/createJuego")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createJuego(Partida partida) {

        if (partida.getN()==0 || partida.getP()==0)
            return Response.status(409).entity(partida).build();
        this.manager.crearJuego(partida.getN(), partida.getP());;
        return Response.status(201).entity(partida).build();
    }
    @POST
    @ApiOperation(value = "Añadir un usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Usuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(Usuario user) {

        if (user.getNombre()==null || user.getApellido1()==null )
            return Response.status(500).entity(user).build();
        this.manager.añadirUsuario(user.getId(),user.getNombre(), user.getApellido1(), user.getApellido2());
        return Response.status(201).entity(user).build();
    }
    @POST
    @ApiOperation(value = "Añadir un objeto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Producto.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/addObject")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newObjeto(Producto objeto) {

        if (objeto.getId()==null || objeto.getDescipcion()==null || objeto.getPrecio()== 0.0)
            return Response.status(500).entity(objeto).build();
        this.manager.añadirProducto(objeto.getId(), objeto.getDescipcion(), objeto.getPrecio());
        return Response.status(201).entity(objeto).build();
    }
    @POST
    @ApiOperation(value = "realizar compra", notes = "no")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/comprarObjeto/{idProducto}/{idUsuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response compraObjeto(@PathParam("idProducto")  String idProducto, @PathParam("idUsuario")  String idUsuario)  {
        Producto objeto = this.manager.getProducto(idProducto);
        Usuario user = this.manager.getUsuario(idUsuario);
        if (user == null || objeto == null)  return Response.status(500).build();
        this.manager.realizarCompra(objeto.getId(), user.getId());
        return Response.status(201).build();
    }
    @PUT
    @ApiOperation(value = "Empieza una partida", notes = "Inicio de una partida de un juego por parte de un usuario. Si el usuario no existe, se crea.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully started", response= Partida.class),
            @ApiResponse(code = 500, message = "El jugador ya está en la partida")
    })
    @Path("/player/iniciarPartida")
    public Response iniciarPartida(Usuario user) {

        if (user.getId()==null || user.getApellido1()==null )
            return Response.status(500).entity(user).build();
        this.manager.iniciarPartida(user.getId());
        return Response.status(201).entity(user).build();
    }

    @GET
    @ApiOperation(value = "Devuelve el estado", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
    })
    @Path("/getEstado")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEstado() {

        String estado= this.manager.consultarEstado();
        return Response.status(201).entity(estado).build()  ;

    }
    @PUT
    @ApiOperation(value = "Actualizar vida", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),

    })
    @Path("/actualizarVidas/{idUsuario}/{vida}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarVidas(@PathParam("idUsuario")  String idUsuario, @PathParam("vida") int vida) {
        Usuario user = this.manager.getUsuario(idUsuario);
        this.manager.actualizarVida(user.getId(), user.getVida());
        return Response.status(201).build();
    }
    @GET
    @ApiOperation(value = "Devuelve la vida", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
    })
    @Path("/getVida")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVida(String idUsuario) {
        Usuario user = this.manager.getUsuario(idUsuario);
        int vida = this.manager.consultarVida(idUsuario);
        return Response.status(201).entity(vida).build()  ;

    }
    @GET
    @ApiOperation(value = "Devuelve la vida del equipo", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
    })
    @Path("/getVidaEquipo")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVidaEquipo(String idEquipo) {
        Equipo equipo = this.manager.obtenerEquipo(idEquipo);
        int vidaEquipo = this.manager.consultarVidaEquipo(idEquipo);
        return Response.status(201).entity(vidaEquipo).build()  ;

    }
    @POST
    @ApiOperation(value = "Finaliza la partida", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),

    })
    @Path("/finalizarPartida")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response finalizarPartida(Producto objeto) {

        this.manager.finalizarJuego();
        return Response.status(201).build();
    }


    }

