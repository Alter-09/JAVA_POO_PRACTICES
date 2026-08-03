package com.mycompany.clase3cajero;

import java.util.Scanner;

public class Clase3Cajero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CuentaBancaria cuenta = new CuentaBancaria("Juan Pérez", 50000, "1234");

        int intentos = 0;
        boolean bloqueada = false;

        while (intentos < 3) {
            System.out.print("Ingrese su PIN: ");
            String pinIngresado = sc.nextLine();

            if (cuenta.validarPin(pinIngresado)) {
                break;
            } else {
                intentos++;
                if (intentos < 3) {
                    System.out.println("PIN incorrecto. Le quedan " + (3 - intentos) + " intentos.");
                }
            }
        }

        if (intentos >= 3) {
            System.out.println("Cuenta bloqueada. Demasiados intentos fallidos.");
            bloqueada = true;
        }

        if (!bloqueada) {
            int opcion;
            do {
                System.out.println("\n--- BIENVENIDO " + cuenta.getTitular() + " ---");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Retirar dinero");
                System.out.println("3. Depositar dinero");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1 ->
                        System.out.println("Saldo actual: $" + cuenta.consultarSaldo());
                    case 2 -> {
                        System.out.print("Ingrese monto a retirar: ");
                        double retiro = sc.nextDouble();
                        if (cuenta.retirar(retiro)) {
                            System.out.println("Retiro exitoso.");
                        } else {
                            System.out.println("Saldo insuficiente o monto invalido.");
                        }
                    }
                    case 3 -> {
                        System.out.print("Ingrese monto a depositar: ");
                        double deposito = sc.nextDouble();
                        if (deposito > 0) {
                            cuenta.depositar(deposito);
                            System.out.println("Deposito exitoso.");
                        } else {
                            System.out.println("Monto invalido.");
                        }
                    }
                    case 4 ->
                        System.out.println("Gracias por usar el cajero.");
                    default ->
                        System.out.println("Opcion no valida.");
                }
            } while (opcion != 4);
        }

        sc.close();
    }
}
