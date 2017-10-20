package com.uade.grupo9.model;

public class Transferencia extends Venta{

	private String cbuOrigen;
	private String cbuDestino;
	
	public String getCbuOrigen() {
		return cbuOrigen;
	}
	public void setCbuOrigen(String cbuOrigen) {
		this.cbuOrigen = cbuOrigen;
	}
	public String getCbuDestino() {
		return cbuDestino;
	}
	public void setCbuDestino(String cbuDestino) {
		this.cbuDestino = cbuDestino;
	}
	public Transferencia(Usuario comprador, Usuario vendedor, float montoVenta, String cbuOrigen, String cbuDestino) {
		super(comprador, vendedor, montoVenta);
		this.cbuOrigen = cbuOrigen;
		this.cbuDestino = cbuDestino;
	}
	
	
	
}
