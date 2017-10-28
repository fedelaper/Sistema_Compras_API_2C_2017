package com.uade.grupo9.model;

public abstract class Publicacion <T> extends Operacion {

	private float precio;

	public void recibirOferta(float monto, Usuario ofertante){
		
	}
	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public abstract T getOperacion();

	public abstract void setOperacion(T operacion);

}
