package edu.upc.dsa;

import edu.upc.dsa.models.Equipo;
import edu.upc.dsa.models.Producto;
import edu.upc.dsa.models.Usuario;

public interface GameManager {
    void crearJuego(int numeroEquipos, int numeroPersonas); //Creacion del juego basado en N equipos de P personas

    void añadirUsuario(String id, String nombre, String apellido1, String apellido2); // Añadir un usuario al sistema

    void añadirProducto(String id, String descripcion, double precio); // Añadir un producto (objecto) en la tienda

    Producto realizarCompra(String idProducto, String idUsuario); // Compra de un producto por parte de un usuario

    void iniciarPartida(String idUsuario); // Inicio de una partida por parte de un usuario

    String consultarEstado(); // Consulta el estado del juego

    void actualizarVida(String idUsuario, int vida); // Actualización del valor de vida de un usuario

    int consultarVida(String idUsuario);  // Consulta el valor de vida actual de un usuario

    int consultarVidaEquipo(String idEquipo); // Consulta el valor de vida de un equipo

    void finalizarJuego(); // Finalizar el juego

    //Metodos auxiliares
    public Usuario getUsuario(String idUsuario);
    public Producto getProducto(String idProducto);
    public Equipo obtenerEquipo(String idEquipo);



}
