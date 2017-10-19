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
	public Transferencia(String cbuOrigen, String cbuDestino) {
		super();
		this.cbuOrigen = cbuOrigen;
		this.cbuDestino = cbuDestino;
	}
	
	
}
