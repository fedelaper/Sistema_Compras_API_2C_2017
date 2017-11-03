package com.uade.grupo9.model;

public class ItemServicio {

	private String detalle;
	private String nombre;
	private String tipoContratacion;
	
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public ItemServicio(String detalle, String nombre, String tipoContratacion) {
		super();
		this.detalle = detalle;
		this.nombre = nombre;
		this.tipoContratacion = tipoContratacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoContratacion() {
		return tipoContratacion;
	}
	public void setTipoContratacion(String tipoContratacion) {
		this.tipoContratacion = tipoContratacion;
	}
}
