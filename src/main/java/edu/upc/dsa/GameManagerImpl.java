package edu.upc.dsa;

import edu.upc.dsa.util.*;
import edu.upc.dsa.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.IntStream;


public class GameManagerImpl implements GameManager{

    //Singleton
    public static GameManagerImpl getInstance(){
        if(manager==null){
            manager= new GameManagerImpl();
        }
        return manager;
    }
    private static GameManagerImpl manager;

    private Map<Integer, Usuario> usuarios;
    private Map<Integer, Producto> productos;
    private Map<Integer, Equipo> equipos;

    private List<Partida> partidas;

    private List<Equipo> listaEquipos;

    private List<Usuario> listaUsuarios;

    private List<Producto> listaProductos;


    private EstadoJuego estado;

    GameManagerImpl() {
        usuarios = new HashMap<>();
        productos = new HashMap<>();
        equipos = new HashMap<>();
        partidas = new ArrayList<>();
        listaProductos = new ArrayList<>();
        listaEquipos = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
        estado = EstadoJuego.NO_INICIADO;
    }

    static final Logger logger = Logger.getLogger(GameManagerImpl.class.getName());
    public enum EstadoJuego {
        NO_INICIADO, INICIADO_EN_PREPARACION,INICIADO_EN_FUNCIONAMIENTO, FINALIZADO;
    }

    @Override
    public void crearJuego(int numeroEquipos, int numeroPersonas) {

        if (estado != EstadoJuego.NO_INICIADO) {
            logger.info("El juego ya está en marcha");
            return;
        }
        IntStream.rangeClosed(1, numeroEquipos).forEach(i -> {   //Bucle random que he encontrado por internet pero que es funcional <3
            Equipo equipo = new Equipo("Equipo " + i);
            IntStream.rangeClosed(1, numeroPersonas).forEach(j -> {
                Usuario persona = new Usuario("Jugador " + j);
                equipo.agregarJugador(persona);
            });
            listaEquipos.add(equipo);
        });
        estado = EstadoJuego.INICIADO_EN_PREPARACION;
        logger.info("El juego se ha creado correctamente");

    }


    @Override
    public void añadirUsuario(String id, String nombre, String apellido1, String apellido2) {

        this.listaUsuarios.add(new Usuario(id, nombre, apellido1, apellido2));
        logger.info("El usuario se ha registrado correctamente");
    }

    @Override
    public void añadirProducto(String id, String descripcion, double precio) {

        this.listaProductos.add(new Producto(id, descripcion, precio));
        logger.info("El producto se ha añadido correctamente");

    }

    @Override
    public Producto realizarCompra(String idProducto, String idUsuario) {

        Usuario usuario= getUsuario(idUsuario);
        if(usuario==null){
            logger.info ("El usuario con id "+ idUsuario+ " no existe");
        }
        else{
            Producto producto = getProducto(idProducto);
            if(usuario.getDsaCoins()<producto.getPrecio()){
                logger.info("Eres muy pobre no puedes comprarlo");
            }
            else{
                usuario.getListaObjetosComprados().add(producto);
                double saldo =usuario.getDsaCoins() - producto.getPrecio();
                usuario.setDsaCoins(saldo);
                logger.info("Objeto "+idProducto+" comprado");
                logger.info(idUsuario+",tu saldo restante es de "+saldo+" dsaCoins");
                return producto;

            }
        }
        return null;
    }

    @Override
    public void iniciarPartida(String idUsuario) {

        if (estado == EstadoJuego.NO_INICIADO) {
            logger.info("El juego no ha sido creado todavía");
            return;
        }
        Usuario usuario= getUsuario(idUsuario);
        if (usuario==null) {
            logger.info("El usuario " + idUsuario + " no existe");
            return;
        }
        if (usuario.getPartida() != null) {
            logger.info("El usuario " + idUsuario + " ya tiene una partida activa");
            return;
        }

        Equipo equipo = obtenerEquipoDisponible();
        equipo.agregarJugador(usuario);
        usuario.setEquipo(equipo);
        usuario.setPartida(new Partida(equipo));
        logger.info("El usuario " + idUsuario + " ha sido asignado al equipo " + equipo.getId());

        if (todosEquiposCompletos()) {
            estado = EstadoJuego.INICIADO_EN_FUNCIONAMIENTO;
            logger.info("¡La partida ha comenzado!");
        }
    }


    @Override
    public String consultarEstado() {
        String estadoActual = null;
        switch (estado) {
            case NO_INICIADO:
                estadoActual = "El juego no ha sido iniciado";
                break;
            case INICIADO_EN_PREPARACION:
                estadoActual = "El juego ha sido iniciado y está en preparación";
                break;
            case INICIADO_EN_FUNCIONAMIENTO:
                estadoActual = "El juego ha sido iniciado y está en funcionamiento";
                break;
            case FINALIZADO:
                estadoActual = "El juego ha finalizado";
                break;
        }
        logger.info(estadoActual);
        return estadoActual;
    }

    @Override
    public void actualizarVida(String idUsuario, int vida) {


        if (estado != EstadoJuego.INICIADO_EN_FUNCIONAMIENTO) {
            logger.info("No hay una partida en activo");
        }

        Usuario usuario = getUsuario(idUsuario);
        if (usuario == null) {
            logger.info("El usuario no existe");
        }

        int nuevaVida = usuario.getVida() - vida;
        if (nuevaVida <= 0) {
            nuevaVida = 0;
            logger.info(idUsuario + "has muerto");
        }
        usuario.setVida(nuevaVida);

        logger.info(idUsuario + " te queda " + nuevaVida);
    }
    @Override
    public int consultarVida(String idUsuario) {
        Usuario usuario= getUsuario(idUsuario);
        if (usuario==null) {
            logger.info("El usuario " + idUsuario + " no existe");
            return -1;
        }
        if (usuario.getPartida() == null) {
            logger.info("El usuario " + idUsuario + " no está en una partida");
            return -2;
        }
        logger.info("La vida del usuario"+idUsuario+" es " + usuario.getVida());
        return usuario.getVida();
    }


    @Override
    public int consultarVidaEquipo(String idEquipo) {
        Equipo equipo = obtenerEquipo(idEquipo);
        int totalVida = 0;
        for (Usuario jugador : equipo.getJugadores()) {
            totalVida += jugador.getVida();
        }
        return totalVida;
    }

    @Override
    public void finalizarJuego() {

        if (estado != EstadoJuego.INICIADO_EN_FUNCIONAMIENTO) {
            logger.info("La partida no está en funcionamiento");
            return;
        }
        estado = EstadoJuego.FINALIZADO;
        logger.info("La partida ha terminado");
    }
    private Equipo obtenerEquipoDisponible() {
        for (Equipo equipo : listaEquipos) {
            if (!equipo.estaCompleto()) {
                return equipo;
            }
        }
        return null;
    }
    public Equipo obtenerEquipo(String idEquipo) {
        for (Equipo equipo : listaEquipos) {
            if (equipo.getId() == idEquipo) {
                return equipo;
            }
        }
        return null;
    }

    private boolean todosEquiposCompletos() {
        for (Equipo equipo : listaEquipos) {
            if (!equipo.estaCompleto()) {
                return false;
            }
        }
        return true;
    }
    public Usuario getUsuario(String idUsuario) {
        for (Usuario u: this.listaUsuarios) {
            if(u.getId().equals(idUsuario)) {
                return u;
            }
        }
        return null;
    }

    public Producto getProducto(String idProducto) {
        for (Producto o: this.listaProductos) {
            if(o.getId().equals(idProducto)) {
                return o;
            }
        }
        return null;
    }

}
