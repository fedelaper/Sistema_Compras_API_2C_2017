package com.uade.grupo9.model;

public class ItemProducto {

	private String nombre;
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
	public ItemProducto(float precio, String detalle, String nombre) {
		super();
		this.precio = precio;
		this.detalle = detalle;
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
