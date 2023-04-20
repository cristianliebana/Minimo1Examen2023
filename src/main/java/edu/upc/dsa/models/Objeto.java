package edu.upc.dsa.models;

public class Objeto {

    public String getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    String idObjeto;
    String descipcion;
    double precio;

    public Objeto (String idObjeto, String descipcion, double precio) {

        this.idObjeto=idObjeto;
        this.descipcion=descipcion;
        this.precio=precio;

    }
}
