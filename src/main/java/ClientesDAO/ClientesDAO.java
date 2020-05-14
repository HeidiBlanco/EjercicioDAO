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
    public ArrayList<POJO> lista(Integer desde,Integer limite){
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
                    rs.getString("cp"),
                    rs.getString("pais"),
                    rs.getString("telefono"),
                    rs.getString("fax")
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
                    rs.getString("cp"),
                    rs.getString("pais"),
                    rs.getString("telefono"),
                    rs.getString("fax")
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
        PreparedStatement stmt = null;
        Boolean resultado = false;
        
        if (this.conexion == null || cliente == null){
            return null;
        }        
        try {
            String query = "INSERT INTO clientes(codigo,empresa,contacto,cargo_contacto,direccion,ciudad,region,cp,pais,telefono,fax) values(?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conexion.prepareStatement(query);             
            stmt.setString(1,cliente.getCodigo());
            stmt.setString(2,cliente.getEmpresa());
            stmt.setString(3,cliente.getContacto());
            stmt.setString(4,cliente.getCargo_contacto());
            stmt.setString(5,cliente.getDireccion());
            stmt.setString(6,cliente.getCiudad());
            stmt.setString(7,cliente.getRegion());
            stmt.setString(8,cliente.getCp());
            stmt.setString(9,cliente.getPais());
            stmt.setString(10,cliente.getTelefono());
            stmt.setString(11,cliente.getFax());            
            if (stmt.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println("Error en el insert: "+e.getMessage()+"\nQuery: "+stmt.toString());
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
     //MODIFICAR CLIENTES
     public Boolean update(POJO cliente){
        Boolean resultado = null;
        PreparedStatement stmt = null;
        
        if(this.conexion==null||cliente==null){
            return false;
        }
        
        try{
            String update = "UPDATE clientes SET codigo = ?, empresa = ?, contacto = ?, cargo_contacto = ?, direccion = ?, ciudad = ?, region = ?, cp = ?, pais = ?, telefono = ?, fax = ? WHERE id = ?";
            
            stmt = conexion.prepareStatement(update);
            stmt.setString(1, cliente.getCodigo());
            stmt.setString(2, cliente.getEmpresa());
            stmt.setString(3, cliente.getContacto());
            stmt.setString(4, cliente.getCargo_contacto());
            stmt.setString(5, cliente.getDireccion());
            stmt.setString(6, cliente.getCiudad());
            stmt.setString(7, cliente.getRegion());
            stmt.setString(8, cliente.getCp());
            stmt.setString(9, cliente.getPais());
            stmt.setString(10, cliente.getTelefono());
            stmt.setString(11, cliente.getFax());
            
            stmt.setInt(12, cliente.getId());
            
            if(stmt.executeUpdate()>0){
                resultado = true;
            }
            
        }catch(SQLException e){
            System.out.println("Sentencia incorrecta en UPDATE : "+e.getMessage());
        }finally{
            try{
                if(stmt!=null){
                    stmt.close();
                }
            }catch(SQLException e){
                System.out.println("Error al cerrar la conexion: "+e.getMessage());
            }
        }
        return resultado;
     }

    //BORRADO DE REGISTROS
    public Boolean delete(Integer id) {
        Boolean resultado = false;
        PreparedStatement stm = null;

        try {
            String sql = "DELETE FROM clientes WHERE id = ?";
            stm = conexion.prepareStatement(sql);
            stm.setInt(1,id);

            resultado = stm.execute();

            stm.close();

            System.out.println();

        } catch (SQLException e) {

            System.err.println("Error en el Delete: " + e.getMessage() + " " + stm.toString());
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