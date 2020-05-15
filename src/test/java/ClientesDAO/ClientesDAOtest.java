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
        ClientesDAO instance = new ClientesDAO();
        Connection Result1 = null;
        Connection result2 = instance.getConexion();
        assertNotEquals(Result1, result2);
    }
     
    @Test
    //LISTA
    public void Listar() {
        System.out.println("listaClientes");
        Integer desde = null;
        Integer hasta = null;
        ClientesDAO instance = new ClientesDAO();
        ArrayList<POJO> Result1 = null;
        ArrayList<POJO> Result2 = instance.lista(desde, hasta);
        assertEquals(Result1, Result2);
    }
    @Test
    //LECTURA
    public void Read() {
        System.out.println("LECTURA");
        Integer id = null;
        ClientesDAO instance = new ClientesDAO();
        POJO Result1 = new POJO(1,"GHSG","Alejandro Alvarez","Lola","4","Obere Str. 57","Berlín","NULL","12209","Alemania","653426783","030-0076545");
        POJO Result2 = instance.read(id);
        assertEquals(Result1, Result2);
    }
    @Test
    //INSERTAR
    public void Insert() {
        System.out.println("INSERTAR");
        POJO clientes = null;
        ClientesDAO instance = new ClientesDAO();
        Boolean Result1 = null;
        Boolean Result2 = instance.insert(clientes);
        assertEquals(Result1, Result2);
      
    }
    @Test
    //MODIFICAR
    public void Update() {
        System.out.println("MODIFICAR");
        Integer id  = null;
        POJO clientes = null;
        ClientesDAO instance = new ClientesDAO();
        Boolean Result1 = null;
         Boolean Result2 = instance.update(clientes);
        assertEquals(Result1, Result2);
       
    }
    //BORRADO DE RESGISTROS
    @Test
    public void Delete() {
        System.out.println("BORRADO DE REGISTROS");
        Integer id = null;
        ClientesDAO instance = new ClientesDAO();
        Boolean Result1 = null;
        Boolean Result2 = instance.delete(id);
        assertEquals(Result1, Result2);

    }

    @Test
    //MAXIMO
    public void Maximo() {
        System.out.println("MAXIMO");
        ClientesDAO instance = new ClientesDAO();
        Integer Result1 = null;
        Integer Result2 = instance.maximo();
        assertEquals(Result1, Result2);
      
    }
    
}
