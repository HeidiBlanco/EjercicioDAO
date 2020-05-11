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
                   if (sum >= clientes.maximo()){sum=0;
                   }
                    listaClientes(cliente,clientes,sum,10);
                              
                    break;
                    case 2:
                      sum-=10;//LOS 10 ANTERIORES
                            if(sum<0){sum=0;
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
                        System.out.println("Fin");
                    break;
                    
                    default:
                        System.out.println("Solo números del 1 al 4");
                      }                               
              } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }
    }
    
       
           public static void listaClientes(POJO cliente, ClientesDAO clientes,Integer desde,Integer hasta){
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------"); 
        				
        System.out.println(" ID |  CODIGO    |         EMPRESA                    |        CONTACTO          |   CODIGO POSTAL   |    CIUDAD    |     PAIS      |     TELEFONO     |          FAX  "); 
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");  
        clientes.lista(desde,hasta).forEach((cliente2) -> {                                                                                          
            System.out.println(cliente2);
        });      
          System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------"); 
           
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
                    
                    Integer opcion = Integer.parseInt(sc.nextLine());
                     ClientesDAO clientes = new ClientesDAO(); 
                if(opcion>0 && opcion<12){
                    System.out.print("Introduce la opcion que quieras modificar");
                }
                switch(opcion){
                    case 1:
                        cliente.setCodigo(sc.next());
                        clientes.update(cliente);
                        break;
                    case 2:
                        cliente.setEmpresa(sc.next());
                        clientes.update(cliente);
                        break;
                    case 3:
                        cliente.setContacto(sc.next());
                        clientes.update(cliente);
                        break;
                    case 4:
                        cliente.setCargo_contacto(sc.next());
                        clientes.update(cliente);
                        break;
                    case 5:
                        cliente.setDireccion(sc.next());
                        clientes.update(cliente);
                        break;
                    case 6:
                        cliente.setCiudad(sc.next());
                        clientes.update(cliente);
                        break;
                    case 7:
                        cliente.setRegion(sc.next());
                        clientes.update(cliente);
                        break;
                    case 8:
                        cliente.setCp(sc.next());
                        clientes.update(cliente);
                        break;
                    case 9:
                        cliente.setPais(sc.next());
                        clientes.update(cliente);
                        break;
                    case 10:
                        cliente.setTelefono(sc.next());
                        clientes.update(cliente);
                        break;
                    case 11:
                        cliente.setFax(sc.next());
                        clientes.update(cliente);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("SOLO NUMEROS DEL 1 AL 11:");
                        break;
                }
                
            }catch(NumberFormatException e){
                System.out.println("Introduce numeros:");
            }
        }
    }   
     public static void borrarDatosCliente() throws IOException{
          Scanner sc = new Scanner(System.in);
        ClientesDAO clientes = new ClientesDAO();     
      Integer id;
        Boolean salida = true;
        
        System.out.println("Introduce el id del cliente que deseas eliminar");
        do{
            try{
                id = sc.nextInt();
                if(clientes.delete(id)){
                    System.out.println("Cliente borrado");
                }else{
                    System.out.println("Error al borrar el cliente");
                }
                salida = false;
            }catch(NumberFormatException exc){
                System.out.println("Debes de introducir un numero");
            }
        }while(salida);
    }
    }
                
