/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientesDAO;

import Entidades.POJO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author heidi
 */
public class ClientesDAO {
  private Connection conexion = null;

    //ESTABLECER CONEXION
    public ClientesDAO() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/neptuno", "root", "");
        } catch (SQLException ex) {
            System.err.println("Error al conectar: " + ex.getMessage());
            //ex.printStackTrace(); //avisa dónde se encuentra el problema
        }
    }
    //COMPROBAR LA BASE DE DATOS
    public Connection getConexion() {
        return conexion;
    }
    //MOSTRAR LOS CLIENTES
    public ArrayList<POJO> listar(Integer desde,Integer limite){
        POJO cliente = null;
        PreparedStatement stmt = null;
        ArrayList<POJO> lista = new ArrayList<>();
        if (this.conexion == null){
            return null;
        }
        try {
            String query = "SELECT * from clientes LIMIT ?"+", ?";
            stmt = conexion.prepareStatement(query); 
            stmt.setInt(1,desde);
            stmt.setInt(2,limite);
            ResultSet rs = stmt.executeQuery();    
            while(rs.next()){
                cliente = new POJO(
                    rs.getInt("id"),
                    rs.getString("codigo"),
                    rs.getString("empresa"),
                    rs.getString("contacto"),
                    rs.getString("cargo_contacto"),
                    rs.getString("direccion"),
                    rs.getString("ciudad"),
                    rs.getString("region"),
                    rs.getInt("cp"),
                    rs.getString("pais"),
                    rs.getInt("telefono"),
                    rs.getInt("fax")
                );  
                lista.add(cliente);
            }        
        } catch (SQLException e) {
            System.out.println("Error en el Select: "+e.getMessage()+"\nQuery: "+stmt.toString());
        }        
        return lista;
    }  
    //LECTURA
  public POJO read (Integer idCliente){
        POJO cliente = null;  
        PreparedStatement stmt = null;
        if (this.conexion == null){
            return null;
        }
        try {
            String query = "SELECT * FROM clientes WHERE id = ?";
            stmt = conexion.prepareStatement(query); 
            stmt.setInt(1,idCliente);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cliente = new POJO(
                    rs.getInt("id"),
                    rs.getString("codigo"),
                    rs.getString("empresa"),
                    rs.getString("contacto"),
                    rs.getString("cargo_contacto"),
                    rs.getString("direccion"),
                    rs.getString("ciudad"),
                    rs.getString("region"),
                    rs.getInt("cp"),
                    rs.getString("pais"),
                    rs.getInt("telefono"),
                    rs.getInt("fax")
                );              
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error en el Select: "+e.getMessage()+"\nQuery: "+stmt.toString());
        }
        return cliente;
    }
    
    //INTRODUCIR REGISTROS
    public Boolean insert(POJO cliente){ 
      Boolean resultado = false;
      PreparedStatement stm = null;
      
        if (this.conexion == null || cliente == null) {
            return null;
        }
        String sql = "INSERT INTO CLIENTES VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
    try{
        stm = conexion.prepareStatement(sql);
              stm.setString(1, cliente.getCodigo());
              stm.setString(2, cliente.getEmpresa());
              stm.setString(3, cliente.getContacto());
              stm.setString(4, cliente.getCargo_contacto());
              stm.setString(5, cliente.getDireccion());
              stm.setString(6, cliente.getCiudad());
              stm.setString(7, cliente.getRegion());
              stm.setInt(8, cliente.getCp());
              stm.setString(9, cliente.getPais());
              stm.setInt(10, cliente.getTelefono());
              stm.setInt(11, cliente.getFax());
              stm.executeUpdate();

            if (stm.executeUpdate() > 0) {
                resultado = true;
            }
            
        }catch (SQLException e) {
           System.out.println("Error al insertar empleado: " + e.getMessage() + " " + stm.toString());
      }finally{
          try{
              if (stm != null){
              stm.close();
          } 
          }catch (SQLException e) {
             System.err.println("Error al insertar empleado: " + e.getMessage() + " " + stm.toString());
          }
          }
      return resultado;
  
 }
     //MODIFICACION DE REGISTROS
    public Boolean update(POJO cliente) {
        Boolean resultado = null;
        PreparedStatement stmt = null;

        if (this.conexion == null || cliente == null) {
            return false;
        }
        try {
            String query = "UPDATE empleados SET nombre = ?, apellido1 = ?, apellido2 = ?, extension = ?"
            + ", email = ?, codigooficina = ?, codigojefe = ?, puesto = ? WHERE codigoempleado = ?";
            
            stmt = conexion.prepareStatement(query);
            stmt.setString(1,cliente.getCodigo());
            stmt.setString(2,cliente.getEmpresa());
            stmt.setString(3,cliente.getContacto());
            stmt.setString(4,cliente.getCargo_contacto());
            stmt.setString(5,cliente.getDireccion());
            stmt.setString(6,cliente.getCiudad());
            stmt.setString(7,cliente.getRegion());
            stmt.setInt(8,cliente.getCp());
            stmt.setString(9,cliente.getPais());
            stmt.setInt(10,cliente.getTelefono());
            stmt.setInt(11,cliente.getFax());   
            if (stmt.executeUpdate() > 0) {
                resultado = true;
            }            
        } catch (SQLException e) {
            System.err.println("Error en el Update: " + e.getMessage()+ " SQL:" + stmt.toString());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            }
        }
        return resultado;
    }
    
    //BORRADO DE REGISTROS
    public Boolean delete(Integer idCliente) {
        Boolean resultado = false;
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM clientes WHERE id = ?";
            stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            resultado = stmt.execute();
            stmt.close();
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Error en el delete: " + e.getMessage() + " " + stmt.toString());
        }
        return resultado;
    }   
    //MAXIMO
        public Integer maximo() {
        POJO cliente = null;
        PreparedStatement stmt = null;
        Integer id = null;
        if (this.conexion == null) {
            return null;
        }
        try {
            String query = "SELECT MAX(id) as maximo FROM `clientes`";
            stmt = conexion.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                id = rs.getInt("Maximo"); 
            }
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Error en el Select: " + e.getMessage() + "\nQuery: " + stmt.toString());
        }
        return id;
    }
}
      //FILTRADO DE CLIENTES
       /*  public static void Filtrar{

        
}*/