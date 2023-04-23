package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private double dsaCoins;

    int vida=100;

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    private Equipo equipo;
    private Partida partida;

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    private List<Producto> listaObjetosComprados=null;

    public List<Producto> getListaObjetosComprados() {
        return listaObjetosComprados;
    }

    public void setListaObjetosComprados(List<Producto> listaObjetosComprados) {
        this.listaObjetosComprados = listaObjetosComprados;
    }

    public Usuario(String id, String nombre, String apellido1, String apellido2) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dsaCoins = 25;
        this.listaObjetosComprados = new ArrayList<>();
    }
    public Usuario(){} //Para hacer la magia

    public Usuario(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
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


}

