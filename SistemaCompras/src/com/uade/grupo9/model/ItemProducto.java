package com.uade.grupo9.model;

public class ItemProducto {

	private float precio;
	private String detalle;
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public ItemProducto(float precio, String detalle) {
		super();
		this.precio = precio;
		this.detalle = detalle;
	}
	
	
}