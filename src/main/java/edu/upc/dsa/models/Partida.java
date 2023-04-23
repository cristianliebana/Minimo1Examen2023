package edu.upc.dsa.models;

public class Partida {
    private Equipo equipo;
    private boolean finalizada;

    private int N;

    private int P;

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public int getP() {
        return P;
    }

    public void setP(int p) {
        P = p;
    }

    private boolean estado;


    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Partida(Equipo equipo) {
        this.equipo = equipo;
        this.finalizada = false;
    }
    public Partida(){} //Para hacer la magia

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public void finalizar() {
        this.finalizada = true;
    }

}

