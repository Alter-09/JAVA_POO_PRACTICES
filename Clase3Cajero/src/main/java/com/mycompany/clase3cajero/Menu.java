/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase3cajero;
import java.util.Scanner;
/**
 *
 * @author ALT
 */
public class Menu {
    // ATRIBUTO + METODO PARA ACTIVAR SCANNER
    private final Scanner sc;
    private final Cajero cajero; // Se debe crear bajo el mismo tipo de calse para poder acceder desde el switch
  
    public Menu (Cajero cajero){
        this.cajero = cajero;
        sc = new Scanner(System.in);
    }
    
    public void mostrarMenu() {
        while(true) { 
            System.out.println("\n====MENU CAJERO====");
            System.out.println("1.CONSULTAR SALDO");
            System.out.println("2.DEPOSITAR DINERO");
            System.out.println("3.RETIRAR DINERO");
            System.out.println("4.MOSTRAR ESTADÍSTICAS");
            System.out.println("5.SALIR");
        
            int opcion = sc.nextInt();
            
                   switch (opcion) {
                case 1 -> System.out.println("saldo actual"+ cajero.getSaldo());
                case 2 -> { 
                    double deposito;
                    do{
                        System.out.println("ingrese el monto a depositar:");
                        deposito = sc.nextDouble();
                        if(deposito<=0){
                            System.out.println("el monto debe ser mayor que cero");
                        }
                        
                    } while(deposito<=0);
                         
                    cajero.depositar(deposito);
                    System.out.println("deposito realizado con exito");
                }
                case 3 -> {
                    double retiro;
                    
                    do{
                        System.out.println("ingrese el monto a retirar:");
                        retiro = sc.nextDouble();
                        if(retiro<=0){
                            System.out.println("el monto debe ser mayor que cero");
                        }
                        
                    } while(retiro<=0);
                         
                    if(cajero.getSaldo() >= retiro){
                        cajero.retirar(retiro);
                        System.out.println("retiro realizado con exito");
                        
                    }else {
                        System.out.println("saldo insuficiente");
                    }
                }
                default -> throw new AssertionError();
            }
        }
    }

}
