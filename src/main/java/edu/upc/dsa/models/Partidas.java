package edu.upc.dsa.models;

public class Partidas {

    String idPartida;
    String idUsuario;

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    String idJuego;
    Integer points;
    int vida;

    public Partidas (String idJuego, String idUsuario) {

        this.idJuego=idJuego;
        this.idUsuario=idUsuario;

    }
}
