package edu.upc.dsa.models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Usuarios {

    String idUsuario;
    String nombre;
    String apellido1;

    HashMap<String,Partidas> historial; //Historial de las partidas, clave sera el id de la partida, valor la partida


    HashMap<String,Juego> hashmapequipo;


    private List<Objeto> listaObjetosComprados=null;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public double getDsaCoins() {
        return dsaCoins;
    }

    public void setDsaCoins(double dsaCoins) {
        this.dsaCoins = dsaCoins;
    }

    String apellido2;
    double dsaCoins= 25;

    public Usuarios(){}

    public Boolean getJugando() {
        return jugando;
    }

    public void setJugando(Boolean jugando) {
        this.jugando = jugando;
    }

    Boolean jugando;

    Boolean currentlyPlaying;

    public HashMap<String, Partidas> getHistorial() {
        return historial;
    }

    public void setHistorial(HashMap<String, Partidas> historial) {
        this.historial = historial;
    }

    public Boolean getCurrentlyPlaying() {
        return currentlyPlaying;
    }

    public Usuarios (String idUsuario, String nombre, String apellido1, String apellido2) {

      this.idUsuario=idUsuario;
      this.nombre=nombre;
      this.apellido1=apellido1;
      this.apellido2=apellido2;
      this.listaObjetosComprados = new LinkedList<>();

    }

    public void setListaObjetosComprados(List<Objeto> listaObjetosComprados) {
        this.listaObjetosComprados = listaObjetosComprados;
    }
    public List<Objeto> getListaObjetosComprados() {
        return listaObjetosComprados;
    }

    public void añadirPartida(Partidas partidas) {
        this.historial.put(partidas.idUsuario, partidas);
        this.jugando=true;
    }

    public void añadiraEquipo(Juego juegos) {
        this.hashmapequipo.put(juegos.nombreEquipo, juegos);

    }

    HashMap<String, Partidas> partidasJugadas;
    public HashMap<String, Partidas> getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas() {
        this.partidasJugadas = new HashMap<>();
    }
}
