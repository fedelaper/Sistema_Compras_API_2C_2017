package com.uade.grupo9.model;

public enum FormasDePago {
    Efectivo ("Efectivo"),
    TarjetaCredito ("Tarjeta de Cr�dito"),
    TransferenciaBancaria ("Transferencia Bancaria");

    private final String name;       

    private FormasDePago(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
    }
