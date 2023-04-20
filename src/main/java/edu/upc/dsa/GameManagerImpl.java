package edu.upc.dsa;

import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Partidas;
import edu.upc.dsa.models.Usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class GameManagerImpl implements GameManager {

    //Singleton
    public static GameManagerImpl getInstance(){
        if(manager==null){
            manager= new GameManagerImpl();
        }
        return manager;
    }
    private static GameManagerImpl manager;
    static final Logger logger = Logger.getLogger(GameManagerImpl.class.getName());

    protected Map<String, Usuarios> usuarios;
    private List<Juego> listajuegos;
    private List<Usuarios> listausuarios;
    private List<Objeto> listaObjetos;



    GameManagerImpl(){
        this.usuarios= new HashMap<>(); //Clave=id, valor es el user como tal
        this.listajuegos = new ArrayList<>();
        this.listausuarios=new ArrayList<>();
        this.listaObjetos=new ArrayList<>();
    }
    @Override
    public Juego createJuego(String idJuego, int equipos, int personas) {

        Juego g = getJuego(idJuego);
        if(g==null){ //=null es que no lo hemos encontrado, asi que se puede crear
            g = new Juego(idJuego,equipos,personas);
            listajuegos.add(g);
            logger.info("Juego " + idJuego + "añadido con"+ equipos +" numero de equipos "+ personas + "numero de personas" );
            return g;
        }
        logger.info("Ya hay un juego con este id que funcione");
        return null;
    }

    @Override
    public Usuarios addUsuario(String idUsuario, String nombre, String apellido1, String apellido2) {

        Usuarios user =getUsuario(idUsuario);

        if(user != null) {

            logger.info("Usuario con este correo ya existente");

        }
        else{
            user= new Usuarios(idUsuario,nombre,apellido1,apellido2);
            this.listausuarios.add(user);
            logger.info("Usuario añadido correctamente");

        }
        return user;
    }


    @Override
    public void addObject(String idObjeto, String descripcion, double precio) {

        Objeto objeto = new Objeto(idObjeto, descripcion, precio);
        this.listaObjetos.add(objeto);
        logger.info("Nuevo objeto añadido: " + idObjeto);
    }

    @Override
    public Objeto realizarCompra(String idUsuario, String idObjeto) {

        Usuarios user= getUsuario(idUsuario);
        if(user==null){
            logger.info ("El usuario con id "+idUsuario+" no existe");
        }
        else{
            Objeto objeto= getObjetoporNombre(idObjeto);
            if(user.getDsaCoins()<objeto.getPrecio()){
                logger.info("Eres muy pobre no puedes comprarlo");
            }
            else{
                user.getListaObjetosComprados().add(objeto);
                double saldo =user.getDsaCoins() - objeto.getPrecio();
                user.setDsaCoins(saldo);
                logger.info("Objeto"+idObjeto+"comprado");
                logger.info(idUsuario+",tu saldo restante es de "+saldo+" dsaCoins");
                return objeto;

            }
        }
        return null;
    }

    @Override
    public Juego iniciarJuego(String idjuego, String idUsuario) {

        Juego g = getJuego(idjuego);
        Usuarios u = getUsuario(idUsuario);
        if(g==null || u==null){ //En este caso, o no existe el player o la partida
            logger.info("El jugador no existe");
            return null;
        }
        if(u.getJugando()==true){
            logger.info("El jugador ya está en una partida");
            return null;
        }

        logger.info("Añadiendo a un equipo al usuario "+ u.getIdUsuario());
        this.usuarios.get(idUsuario).añadiraEquipo(g);

        Partidas partidas = new Partidas(idUsuario,idjuego); //Trobat a internet lo de la date
        logger.info("Añadiendo a la partida al usuario "+ u.getIdUsuario());
        logger.info("INICIADO EN FUNCIONAMIENTO");
        this.usuarios.get(idUsuario).añadirPartida(partidas);
        return g;
    }

    @Override
    public String getEstadoActual(String idUsuario) {
        return null;
    }

    @Override
    public Juego restarVidas(String idjuego, int restavidas) {
        return null;
    }

    @Override
    public List<Juego> getVidasUsauario(String idUsuario) {

        return null;
    }

    @Override
    public List<Juego> getVidaEquipo(String nombreEquipo) {
        return null;
    }

    @Override
    public Usuarios finalizarPartida(String idUsuario) {
        Partidas m = getPartidasdeUsuario(idUsuario);
        if(m!=null){
            this.usuarios.get(idUsuario).setJugando(false);
            logger.info("El usuario " + idUsuario +" ha finalizado la partida");
            return this.usuarios.get(idUsuario);
        }
        return null;
    }

    public Juego getJuego(String idJuego){

        logger.info("Buscando juego con id " + idJuego);
        for(Juego g: this.listajuegos){
            if(g.getIdJuego().equals(idJuego)){ //Si el juego existe en mi lista de juegos
                logger.info("Juego encontrado! " + g.getDescripcion());
                return g;
            }
        }
        logger.info("Juego no encontrado");
        return null;
    }

    public Usuarios getUsuario(String idUsuario) {
        logger.info("Buscando usuario con " + idUsuario);
        if(this.usuarios.get(idUsuario)==null){
            logger.info("Jugador no encontrado");
            return null;
        }
        return this.usuarios.get(idUsuario);
    }
    public Objeto getObjetoporNombre(String name) {
        for (Objeto o: this.listaObjetos) {
            if(o.getIdObjeto().equals(name)) {
                return o;
            }
        }
        return null;
    }
    public Partidas getPartidasdeUsuario(String idUsuario) {
        Usuarios u = getUsuario(idUsuario);
        logger.info("Buscando la ultima partida hecha por el usuario "+idUsuario);
        if(u.getJugando()==true){
            Partidas m = u.getHistorial().get(u.getHistorial().size()-1);
            logger.info("");
            return m;
        }
        logger.info("No se puede encontrar la partida");
        return null;
    }
}

