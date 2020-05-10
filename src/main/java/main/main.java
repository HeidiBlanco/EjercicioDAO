/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import ClientesDAO.ClientesDAO;
import Entidades.POJO;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author heidi
 */
public class main {
     public static void main(String[] args) throws IOException {
        ClientesDAO clientes = new ClientesDAO();      
        POJO entidades = new POJO();
        Scanner sc=new Scanner(System.in); 
        int salida=1;
        boolean salir = false;
        int sum10=0;     
       
      
        while (!salir) {
            //MENU
             System.out.println("---------------------------------------------------|");
           System.out.println("                |EJERCICIO DAO|                    |");
            System.out.println("---------------------------------------------------|");
           System.out.println("1.- Visualizar los diez siguientes                 |");
           System.out.println("2.- Visualizar los diez anteriores                 |");
           System.out.println("3.- Introducir nuevo registro                      |");
           System.out.println("4.- Actualizar dato de cliente por IdCliente       |");
           System.out.println("5.- Borrar dato por IdCliente                      |");
           System.out.println("0.- Salir                                          |");
           System.out.println("---------------------------------------------------|");
              System.out.println("ELIGE UNA DE ESTAS OPCIONES");
             int opcion= Integer.parseInt(sc.next());
          
            try {
                switch (opcion) {
                    case 1:
                    sum10+=10;
                     if (sum10 > clientes.maximo()){//Los 10 primeros 
                    sum10=0;
                    listaClientes(entidades,clientes,sum10,10);
                            }   
                    break;
                    case 2:
                    sum10-=10;//Los 10 anteriores
                    if(sum10<0){
                    sum10=0;
                    listaClientes(entidades,clientes,sum10,10);
                            }        
                    break;
                    case 3:
                    introducirDatosCliente();
                    break;
                    
                    case 4:
                    actualizarDatosCliente();
                    break;
                    
                    case 5:
                    borrarDatosCliente(); 
                    break;
                    
                    case 0:
                        salir = true;
                        System.out.println("Fin");
                    break;
                    
                    default:
                        System.out.println("Solo números del 1 al 4");
                      }                           
                salida=0;    
            } catch(java.lang.NumberFormatException error) {
                System.out.println("ERROR,introduce un numero.");
                salida=1;
            }            
        } while(salida==1);                
     }    
           public static void listaClientes(POJO entidades, ClientesDAO clientes,Integer desde,Integer hasta){
        System.out.println("|----------------------------------------------------------------------------------------------------------------------|");
        				
        System.out.println("|   Id  |  Codigo |   Empresa  |   Contacto  |   Cargo   |  CódigoPostal  |  Ciudad  |   Pais   |  Telefono  |   Fax   | ");
        
        System.out.println("|----------------------------------------------------------------------------------------------------------------------|"); 
        clientes.lista(desde,hasta).forEach((cliente2) -> {    
            System.out.println(cliente2);
        });      
           
    }
   
 public static void introducirDatosCliente() throws IOException{ 
     Scanner sc= new Scanner(System.in);
        ClientesDAO clientes = new ClientesDAO();  
        POJO cliente = new POJO();
        
        System.out.print("Introducir Codigo del Cliente: ");
        cliente.setCodigo(sc.nextLine());

        System.out.print("Introducir el nombre del Cliente: ");
        cliente.setEmpresa(sc.nextLine());

        System.out.print("Introducir el contacto del Cliente: ");
        cliente.setContacto(sc.nextLine());

        System.out.print("Introducir el cargo del contacto del Cliente: ");
        cliente.setCargo_contacto(sc.nextLine());

        System.out.print("Introduccir la direccion del Cliente: ");
        cliente.setDireccion(sc.nextLine());

        System.out.print("Introducir la Ciudad del cliente: ");
        cliente.setCiudad(sc.nextLine());

        System.out.print("Introducir la region del Cliente: ");
        cliente.setRegion(sc.nextLine());

        System.out.print("Introducir el codigo postal del Cliente: ");
        cliente.setCp(sc.nextInt());
        
        System.out.print("Introducir el Pais del Cliente: ");
        cliente.setPais(sc.nextLine());
        
        System.out.print("Introducir el telefono del Cliente: ");
        cliente.setTelefono(sc.nextInt());
        
        System.out.print("Introducir el Fax del Cliente: ");
        cliente.setFax(sc.nextInt());

        if(clientes.insert(cliente)){
            System.out.println("idCliente: "+clientes.maximo()+", Codigo: "+cliente.getCodigo()+", Nombre:"+cliente.getEmpresa()+" Datos Insertados");
        } else{
            System.out.println("Los Datos no se han insertado");
        }
        }
        public static void actualizarDatosCliente() throws IOException{
        Scanner sc = new Scanner(System.in);
        POJO cliente = null;
        System.out.println("Introduce el ID del cliente que desea modificar : ");
        Integer id = Integer.parseInt(sc.nextLine());
       
        while (true) {
            try { 
                    System.out.println("\n MODIFICAR");
                    System.out.println("------------------------------------");
                    System.out.println("1.- Codigo");
                    System.out.println("2.- Empresa");
                    System.out.println("3.- Contacto");
                    System.out.println("4.- Cargo");
                    System.out.println("5.- Dirección ");
                    System.out.println("6.- Ciudad");
                    System.out.println("7.- Región");
                    System.out.println("8.- Código Postal");
                    System.out.println("9.- Pais");
                    System.out.println("10.- Teléfono");
                    System.out.println("11.- Fax");
                    System.out.println("------------------------------------");
                    
                    System.out.print("\nIntroduzca la modificación  : ");
                    Integer opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                     break;
                    case 2:
                              
                    break;
                    case 3:
                    
                    break;
                    
                    case 4:
                   
                    break;
                    
                    case 5:
                        
                    break;
                    case 6:
                   
                    break;
                    
                    case 7:
                        
                     break;   
                    case 8:
                    
                    break;
                    
                    case 9:
                    
                      break;  
                     case 10:
                   
                    break;
                    
                    case 11:
                    
                    break;
                    
                    case 0:
                       
                        System.out.println("Fin");
                    break;
                    
                     }
            } catch (NumberFormatException e) {
                System.err.println("\nError: " + e.getMessage() + "\n");
            }
        }
    }   
     public static void borrarDatosCliente() throws IOException{
            ClientesDAO clientes = new ClientesDAO(); 
             Scanner sc = new Scanner(System.in);
             
}
}     
