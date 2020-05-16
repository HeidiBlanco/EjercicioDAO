/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientesDAO;

import Entidades.POJO;
import java.sql.Connection;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author heidi
 */
public class ClientesDAOtest {
      ClientesDAO clientes;
    public ClientesDAOtest() {
    	clientes= new ClientesDAO();
    }
     @After
    public void tearDown() {
    }
    @AfterClass
    public static void tearDownClass() {
    }
     @Before
    public void setUp() {
    }
    @BeforeClass
    public static void setUpClass() {
    }
   @Test
   //ESTABLECER CONEXION
    public void conexion() {
        System.out.println("CONEXION");
        Connection Result1 = null;
        Connection result2 = clientes.getConexion();
        assertNotEquals(Result1, result2);
    }
     
    @Test
    //LISTA
    public void Listar() {
        System.out.println("listaClientes");
        Integer desde = 0;
        Integer hasta = 10;
        ArrayList<POJO> Result2 = clientes.lista(desde, hasta);
        assertNotEquals(null, Result2);
    }
    @Test
    //LECTURA
    public void Read() {
        System.out.println("LECTURA");
        Integer id = 4;
        POJO Result1 = new POJO(4,"AROUT","Around the Horn", "Thomas Hardy","Representante de ventas","120 Hanover Sq","Londres","NULL","WA1 1DP" ,"Reino Unido","(71) 555-7788","(71) 555-6750");
        POJO Result2 = clientes.read(id);
        assertEquals(Result2.getId(),Result1.getId());
    }
    @Test
    //INSERTAR
    public void Insert() {
        System.out.println("INSERTAR");
        POJO cliente = new POJO(98,"UWIUWE","RAMIREZ","Heidi Blanco","Nose","Pericles","Madrid",null,"28011","España","45135951","8952033");
        Boolean Result1 = false;
        Boolean Result2 = clientes.insert(cliente);
        assertEquals(Result1, Result2);
      
    }
    @Test
    //MODIFICAR
    public void Update() {
        System.out.println("MODIFICAR");
       POJO cliente = null;
        Boolean Result1 = false;
        Boolean Result2 = clientes.update(cliente);
        assertEquals(Result1, Result2);
       
    }
    //BORRADO DE RESGISTROS
    @Test
    public void Delete() {
        System.out.println("BORRADO DE REGISTROS");
        Integer id = 1;
        Boolean Result1 = false;
        Boolean Result2;
        Result2 = clientes.delete(id);
        assertEquals(Result1, Result2);

    }

    @Test
    //MAXIMO
    public void Maximo() {
        System.out.println("MAXIMO");
        Integer Result1 = 95;
        Integer Result2 = clientes.maximo();
        assertEquals(Result1,Result2 );
      
    }
    
}
