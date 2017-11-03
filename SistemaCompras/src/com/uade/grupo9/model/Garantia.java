package com.uade.grupo9.model;

import java.util.Date;

public class Garantia {

	private Date fechaDeCompra;
	private int cantidadDeDias;
	private String tipo; //Anual, mensual o extendida TODO: PASAR A ENUM O REFACTOR DE LA LOGICA
	
	public Date getFechaDeCompra() {
		return fechaDeCompra;
	}
	public void setFechaDeCompra(Date fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}
	public int getCantidadDeDias() {
		return cantidadDeDias;
	}
	public void setCantidadDeDias(int cantidadDeDias) {
		this.cantidadDeDias = cantidadDeDias;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
