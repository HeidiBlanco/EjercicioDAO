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
        POJO cliente = new POJO();
        Scanner sc=new Scanner(System.in); 
       //VISUALIZAR CLIENTES
        boolean salir = false;    
        int sum = 0;
        
        listaClientes(cliente,clientes,0,10); 
        while (!salir) {
            //MENU
             System.out.println("---------------------------------------------------|");
           System.out.println("                *MENU*                             |");
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
                     sum+=10;//LOS 1O SIGUIENTES
                   if (sum >= clientes.maximo()){
                       sum=0;
                   }
                    listaClientes(cliente,clientes,sum,10);
                              
                    break;
                    case 2:
                      sum-=10;//LOS 10 ANTERIORES
                     if(sum<0){
                         sum=0;
                   }
                    listaClientes(cliente,clientes,sum,10);
                   
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
                        System.out.println("FIN");
                    break;
                    
                    default:
                        System.out.println("Solo números del 1 al 4");
                      }                               
              } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
       
        }
             System.out.println("\n");
    }
    
       
           public static void listaClientes(POJO cliente, ClientesDAO clientes,Integer desde,Integer hasta){
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------"); 
        				
        System.out.println(" ID |  CODIGO    |         EMPRESA                    |        CONTACTO          |   CODIGO POSTAL   |    CIUDAD    |     PAIS      |     TELEFONO     |          FAX       | "); 
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
        clientes.lista(desde,hasta).forEach((cliente2) -> {                                                                                          
            System.out.println(cliente2);
        });      
          System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------"); 
           
    }
        public static POJO confirmacion(){
        Scanner sc = new Scanner(System.in); 
        ClientesDAO clientes = new ClientesDAO();
        POJO cliente = null;
    
        System.out.println("Indique el id del cliente :  ");
        Integer id = sc.nextInt();
        cliente = clientes.read(id);
        if(cliente==null){
            System.out.println("El Cliente no se encuentra en la tabla");
        }else{
            System.out.println("Cliente " + id + " CONFIRMADO");  
        }    
        return cliente;
        
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
        cliente.setCp(sc.nextLine());
        
        System.out.print("Introducir el Pais del Cliente: ");
        cliente.setPais(sc.nextLine());
        
        System.out.print("Introducir el telefono del Cliente: ");
        cliente.setTelefono(sc.next());
        
        System.out.print("Introducir el Fax del Cliente: ");
        cliente.setFax(sc.nextLine());

        if(clientes.insert(cliente)){
            System.out.println("idCliente: "+clientes.maximo()+", Codigo: "+cliente.getCodigo()+", Nombre:"+cliente.getEmpresa()+" Datos Insertados");
        } else{
            System.out.println("Los Datos no se han insertado");
        }
        }
        public static void actualizarDatosCliente() throws IOException{
        Scanner sc = new Scanner(System.in);
         POJO cliente = confirmacion();
        ClientesDAO clientes = new ClientesDAO();
        
        System.out.println("Introduce el ID del cliente que desea modificar : ");
        Integer id = Integer.parseInt(sc.nextLine());
        
        cliente = clientes.read(id);
        System.out.println("_______________________________________________________________________________________________________________________________________________________________________________________");
         System.out.println("CLIENTE: "+cliente.toString());
           System.out.println("_______________________________________________________________________________________________________________________________________________________________________________________");
           System.out.println("\n");
           while(true){
               try{
                    Integer opcion = 0;
                  System.out.println("---------------------------------------|");
                  System.out.println("         ELIGUE MODIFICACION           |");   
                System.out.println("---------------------------------------|");
                  System.out.println("1.- \t\tCodigo                 |");
                  System.out.println("2.- \t\tEmpresa                |");
                  System.out.println("3.- \t\tContacto               |");
                  System.out.println("4.- \t\tCargo                  |");
                  System.out.println("5.- \t\tDirección              |");
                  System.out.println("6.- \t\tCiudad                 |");
                  System.out.println("7.- \t\tRegión                 |");
                  System.out.println("8.- \t\tCódigo Postal          |");
                  System.out.println("9.- \t\tPais                   |");
                  System.out.println("10.- \t\tTeléfono               |");
                  System.out.println("11.- \t\tFax                    |");
                  System.out.println("0.- \t\tSalir                  |");
                  System.out.println("---------------------------------------|");
                  
                    while(true){
                      try{
                           System.out.print("\nIntroducir MODIFICACION : ");
                          String opcion2 = sc.nextLine();
                          opcion = Integer.parseInt(opcion2);
                          
                      break;
                      }catch(InputMismatchException e){
                          System.out.println("Has introducido un caracter, introduce un numero");
                      }
                  }
               
                  switch (opcion) {
                    case 1:
                        System.out.printf("Introducir modificacion del Codigo : ");
                        cliente.setCodigo(sc.nextLine());
                        clientes.update(cliente);
                        break;
                    case 2:
                        System.out.printf("Introducir modificacion de Empresa : ");
                        cliente.setEmpresa(sc.nextLine());
                        clientes.update(cliente);
                    break;
                    case 3:
                        System.out.printf("Introducir modificacion de Contacto : ");
                        cliente.setContacto(sc.nextLine());
                        clientes.update(cliente);
                    break;
                    case 4:
                        System.out.printf("Introducir modificacion de Cargo : ");
                        cliente.setCargo_contacto(sc.nextLine());
                        clientes.update(cliente);
                    break;
                    case 5:
                        System.out.printf("Introducir modificacion de Direccion : ");
                        cliente.setDireccion(sc.nextLine());
                        clientes.update(cliente);
                    break;
                    case 6:
                         System.out.printf("Introducir modificacion de Ciudad : ");
                        cliente.setCiudad(sc.nextLine());
                        clientes.update(cliente);
                    break;
                    case 7:
                        System.out.printf("Introducir modificacion de Region : ");
                        cliente.setRegion(sc.nextLine());
                        clientes.update(cliente);
                    break;
                    case 8:
                        System.out.printf("Introducir modificacion de Codigo Postal : ");
                        cliente.setCp(sc.nextLine());
                        clientes.update(cliente);
                    break;
                    case 9:
                        System.out.printf("Introducir modificacion de Pais : ");
                        cliente.setPais(sc.nextLine());
                        clientes.update(cliente);
                    break;
                    case 10:
                        System.out.printf("Introducir modificacion de Telefono : ");
                        cliente.setTelefono(sc.nextLine());
                        clientes.update(cliente);
                    break;
                    case 11:
                        System.out.printf("Introducir modificacion de Fax : ");
                        cliente.setFax(sc.nextLine());
                        clientes.update(cliente);
                    break;
                    
                    case 0:
                      return;
                    default:
                        System.out.println("\nSolo debe introducir números entre 0 y 11\n");
                }
                }catch(NumberFormatException e){
                System.out.println("Introduce numeros:");
                
            }
             System.out.println("El cliente " + id + " ha sido modificado correctamente.");
         }
    }

   public static void borrarDatosCliente() throws IOException{
          Scanner sc = new Scanner(System.in);
           POJO cliente = confirmacion();
        ClientesDAO clientes = new ClientesDAO();
          Integer id = Integer.parseInt(sc.next());
         if(cliente==null){
             System.out.println("El Cliente seleccionado no se encuentra en la tabla");
         }else{
             clientes.delete (id);
             System.out.println("El cliente ha sido eliminado");
         }
    }
    }
                
