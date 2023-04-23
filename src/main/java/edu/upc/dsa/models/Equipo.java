package edu.upc.dsa.models;

import java.util.ArrayList;

public class Equipo {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String nombre;
    private ArrayList<Usuario> jugadores;

    private int numeroPersonas;



    public Equipo(String id) {
        this.id=id;
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
        this.numeroPersonas = numeroPersonas;
    }
    public Equipo(){} //Para hacer la magia

    public void agregarJugador(Usuario jugador) {
        jugadores.add(jugador);
    }

    public ArrayList<Usuario> getJugadores() {
        return jugadores;
    }

    public int getCantidadJugadores() {
        return jugadores.size();
    }

    public String getNombre() {
        return nombre;
    }
    public boolean estaCompleto() {
        return jugadores.size() == numeroPersonas;
    }
    public Usuario buscarJugadorPorId(String id) {
        for (Usuario jugador : jugadores) {
            if (jugador.getId().equals(id)) {
                return jugador;
            }
        }
        return null;
    }

}
