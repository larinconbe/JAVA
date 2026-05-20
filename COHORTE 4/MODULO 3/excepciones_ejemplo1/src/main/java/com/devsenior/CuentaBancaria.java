package com.devsenior;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldo) {
        this.saldo = saldo;
    }

    public void Retirar(double monto) throws SaldoInsuficienteExcept {
        if (monto > saldo){
            throw new SaldoInsuficienteExcept("Saldo insuficiente para retirar" + monto);
        }
        saldo -= monto;
        System.out.println("Retiro exitoso, saldo actual:" + saldo);
    }
}
