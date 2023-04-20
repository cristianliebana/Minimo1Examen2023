package edu.upc.dsa.models;

import java.util.HashMap;

public class Juego {

    String Descripcion;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    int vida=100;

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    public int getNumerodeEquipos() {
        return numerodeEquipos;
    }

    public void setNumerodeEquipos(int numerodeEquipos) {
        this.numerodeEquipos = numerodeEquipos;
    }

    public int getNumerodePersonas() {
        return numerodePersonas;
    }

    public void setNumerodePersonas(int numerodePersonas) {
        this.numerodePersonas = numerodePersonas;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Juego(String idJuego, int numerodeEquipos, int numerodePersonas) {
        this.idJuego = idJuego;
        this.numerodeEquipos = numerodeEquipos;
        this.numerodePersonas = numerodePersonas;
    }

    String estado;

    String idJuego;

    int numerodeEquipos;

    int numerodePersonas;

    String nombreEquipo;

    HashMap<String,Partidas> partidasJugadas;

    public HashMap<String, Partidas> getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas() {
        this.partidasJugadas = new HashMap<>();
    }




}
