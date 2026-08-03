/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase3cajero;

/**
 *
 * @author ALT
 */
public class Cajero {
    private double saldo; // Los atributos se quedarán unicamente en esta clase
    private int cantDepositos; // Esto con el fin de mejorar la seguridad
    private int cantRetiros; // y reducir el acceso
    private double totalDepositado;
    private double totalRetirado;

    // CONSTRUCTOR
    public Cajero(double pSaldo){ // No se sabe el deposito inicial
        saldo = pSaldo ; // this.atributo = parámetro
        cantDepositos = 0;
        cantRetiros = 0;
        totalDepositado = 0;
        totalRetirado = 0;
    }
    
    // METODOS GET
    // Se realiza 1 para cada parametro
    public double getSaldo() { 
        return saldo;
    }
    
    //Depositar dinero
    public void depositar(double pMonto) { // Al usar void, el metodo no retorna nada
        saldo += pMonto;
        cantDepositos++;
        totalDepositado += pMonto;
    }
    
    //Depositar dinero
    public void retirar(double pMonto) { // Al usar void, el metodo no retorna nada
        saldo -= pMonto;
        cantRetiros++;
        totalRetirado += pMonto;
    }

    public void Estadisticas() {
        System.out.println("-Cantidad depositos: "+cantDepositos);
        System.out.println("-Cantidad depositos: "+cantRetiros);
        System.out.println("-Cantidad depositos: "+totalDepositado);
        System.out.println("-Cantidad depositos: "+totalRetirado);
    }

}

 