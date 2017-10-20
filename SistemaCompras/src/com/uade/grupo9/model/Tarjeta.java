package com.uade.grupo9.model;

public class Tarjeta extends Venta{

	private String numTarjeta;

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public Tarjeta(Usuario comprador, Usuario vendedor, float montoVenta, String numTarjeta) {
		super(comprador, vendedor, montoVenta);
		this.numTarjeta = numTarjeta;
	}
	
	
}
