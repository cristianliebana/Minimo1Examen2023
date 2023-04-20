package edu.upc.dsa;

import edu.upc.dsa.models.Juego;
import edu.upc.dsa.models.Partidas;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuarios;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class GameManagerTest {
    GameManager manager = GameManagerImpl.getInstance();

    @Before
    public void setUp(){
        manager=new GameManagerImpl();
        manager.addUsuario("1","Cristian","Liébana","Simeon");
        manager.addUsuario("2","Nerea","Chico","Pineda");
        manager.addObject("Espada","Para matar",5.35);
        manager.addObject("Escudo","Para defenderte",4.75);

    }
    @Test
    public void realizarCompraTest(){

        manager.realizarCompra("1","Espada");
        manager.realizarCompra("2","Escudo");

    }
}
