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

/**
 *
 * @author heidi
 */
public class ClientesDAO {
   private Connection conexion = null;
    
    public ClientesDAO () {
        try {
            conexion =  DriverManager.getConnection("jdbc:mysql://localhost/neptuno", "root", "");
        } catch (SQLException ex) {
            System.err.println("Error al conectar: "+ ex.getMessage());
        }
    }
        //comprobar la conexion con la base de datos
    public Connection getConexion() {
        return conexion;
    }
    //CREACIÓN
   public Boolean insert(POJO cliente){ 
      Boolean resultado = false;
      PreparedStatement stm = null;
      
      if (this.conexion == null || cliente == null) {
            return false;
        }

    try{
        if(cliente != null){
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_neptuno", "root", "");
            String sql = "INSERT INTO CLIENTES VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
              stm = conexion.prepareStatement(sql);
              stm.setInt(1, cliente.getId());
              stm.setString(2, cliente.getCodigo());
              stm.setString(3, cliente.getEmpresa());
              stm.setString(4, cliente.getContacto());
              stm.setString(5, cliente.getCargo_contacto());
              stm.setString(6, cliente.getDireccion());
              stm.setString(7, cliente.getCiudad());
              stm.setString(8, cliente.getRegion());
              stm.setInt(9, cliente.getCp());
              stm.setString(10, cliente.getPais());
              stm.setInt(11, cliente.getTelefono());
              stm.setInt(12, cliente.getFax());
           

            if (stm.executeUpdate() > 0) {
                resultado = true;

            }

          }
      }catch (SQLException ex) {
           System.err.println("Error al insertar empleado: " + ex.getMessage() + " " + stm.toString());
      }finally{
          try{
              stm.close();
              conexion.close();
          } catch (SQLException ex) {
             System.err.println("Error al insertar empleado: " + ex.getMessage() + " " + stm.toString());
          }
      }
      return resultado;
  
 }
    
}
     //BORRADO DE RESGITROS
   /* public Boolean delete(POJO Clientes){
        Boolean resultado = false;
        PreparedStatement stm = null;
        String sql = "DELETE FROM clientes;
        try{
            stm = conexion.prepareStatement(sql);
            stm.setInt(3, Clientes.getCodigoEmpleado());
            resultado = stm.execute();
        }catch (SQLException ex){
                System.out.println("Error en el borrado de registros: "+ ex.getMessage());
        }
        return resultado;
    }
}*/
    
