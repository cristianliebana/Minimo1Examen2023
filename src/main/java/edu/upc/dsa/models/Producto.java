package edu.upc.dsa.models;

public class Producto {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    String id;
    String descipcion;
    double precio;

    public Producto (String id, String descipcion, double precio) {

        this.id=id;
        this.descipcion=descipcion;
        this.precio=precio;

    }
    public Producto(){} //Para hacer la magia
}
