package edu.upc.dsa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class GameManagerTest {
    GameManager manager = GameManagerImpl.getInstance();

    @Before
    public void setUp(){
        manager=new GameManagerImpl();
        manager.añadirUsuario("1","Cristian","Liébana","Simeon");
        manager.añadirUsuario("2","Nerea","Chico","Pineda");

        manager.añadirProducto("Espada","Para matar",5.35);
        manager.añadirProducto("Escudo","Para defenderte",4.75);

        manager.crearJuego(2,3);
        manager.iniciarPartida("1");

    }
    @Test
    public void crearJuegoTest(){

        manager.crearJuego(2,3);

    }
    @Test
    public void realizarCompraTest(){

        manager.realizarCompra("Espada","1");
        manager.realizarCompra("Escudo","2");

    }
    @Test
    public void añadirUsuarioTest(){

        manager.añadirUsuario("1","Cristian","Liébana","Simeon");
        manager.añadirUsuario("2","Nerea","Chico","Pineda");

    }
    @Test
    public void añadirProductoTest(){

        manager.añadirProducto("Espada","Para matar",5.35);
        manager.añadirProducto("Escudo","Para defenderte",4.75);

    }
    @Test
    public void consultarVidaTest(){

        manager.actualizarVida("1",10);
        manager.consultarVida("1");


    }
    @Test
    public void iniciarPartidaTest(){

        manager.iniciarPartida("1");
        manager.iniciarPartida("2");

    }
    @Test
    public void actualizarVidaTest(){

        manager.actualizarVida("1",10);
        manager.actualizarVida("2",10);

    }
    @Test
    public void consultarEstadoTest(){

        manager.consultarEstado();

    }
    @Test
    public void finalizarJuegoTest(){

        manager.finalizarJuego();

    }
}
