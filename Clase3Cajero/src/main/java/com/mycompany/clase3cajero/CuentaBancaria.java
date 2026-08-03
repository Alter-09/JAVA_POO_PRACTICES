package com.mycompany.clase3cajero;

public class CuentaBancaria {
    private String titular;
    private double saldo;
    private String pin;

    public CuentaBancaria(String titular, double saldo, String pin) {
        this.titular = titular;
        this.saldo = saldo;
        this.pin = pin;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public boolean validarPin(String pinIngresado) {
        return this.pin.equals(pinIngresado);
    }

    public String getTitular() {
        return titular;
    }
}
