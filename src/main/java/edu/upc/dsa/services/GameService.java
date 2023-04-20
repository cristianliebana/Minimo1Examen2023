package edu.upc.dsa.services;
import edu.upc.dsa.GameManager;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuarios;
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

    //Post un nuevo usuario
    @POST
    @ApiOperation(value = "Añadir un usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Usuarios.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(Usuarios user) {

        if (user.getNombre()==null || user.getApellido1()==null )
            return Response.status(500).entity(user).build();
        this.manager.addUsuario(user.getIdUsuario(),user.getNombre(), user.getApellido1(), user.getApellido2());
        return Response.status(201).entity(user).build();
    }
    //Post un nuevo objeto
    @POST
    @ApiOperation(value = "Añadir un objeto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Objeto.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/addObject")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newObjeto(Objeto objeto) {

        if (objeto.getIdObjeto()==null || objeto.getDescipcion()==null || objeto.getPrecio()== 0.0)
            return Response.status(500).entity(objeto).build();
        this.manager.addObject(objeto.getIdObjeto(), objeto.getDescipcion(), objeto.getPrecio());
        return Response.status(201).entity(objeto).build();
    }
    //Comprar un objeto
    @POST
    @ApiOperation(value = "realizar compra", notes = "no")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/comprarObjeto/{idUsuario}/{idObjeto}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response compraObjeto(@PathParam("idUsuario")  String idUsuario, @PathParam("idObjeto")  String idObjeto)  {
        Objeto objeto = this.manager.getObjetoporNombre(idObjeto);
        Usuarios user = this.manager.getUsuario(idUsuario);
        if (user == null || objeto == null)  return Response.status(500).build();
        this.manager.realizarCompra(user.getIdUsuario(), objeto.getIdObjeto());
        return Response.status(201).build();
    }

}
