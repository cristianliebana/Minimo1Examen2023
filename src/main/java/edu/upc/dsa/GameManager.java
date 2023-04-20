package edu.upc.dsa;

import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Partidas;
import edu.upc.dsa.models.Usuarios;

import java.util.List;

public interface GameManager {

    Juego createJuego (String idJuego, int equipos, int personas); //Crea el juego

    Usuarios addUsuario(String idUsuario, String nombre, String apellido1, String apellido2); //Añade al usuario

    void addObject(String idObjeto, String descripcion, double precio); //Añade el objeto

    Objeto realizarCompra(String idUsuario, String idObjeto); //Metodo para realizar una compra

    Juego iniciarJuego(String idjuego, String idUsuario); //Inicia el Juego

    String getEstadoActual(String idUsuario); //Consulta el estado del juego

    Juego restarVidas(String idjuego, int restavidas); //Actualización del valor de vida de un usuario

    List<Juego> getVidasUsauario(String idUsuario); //Consulta de la vida de un usuario

    List<Juego> getVidaEquipo(String nombreEquipo); //Consulta de la suma de la vida de todos los usuarios de un equipo

    Usuarios finalizarPartida(String idUsuario);//Finaliza la partida


    public Juego getJuego(String idJuego);
    Usuarios getUsuario(String idUsuario);

    Partidas getPartidasdeUsuario(String idUsuario);

    Objeto getObjetoporNombre(String name);



}
