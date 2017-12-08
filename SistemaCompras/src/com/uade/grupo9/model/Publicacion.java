package com.uade.grupo9.model;

import java.util.Date;
import java.util.List;

public abstract class Publicacion <T>{

	private float precio;
    private Date fecha;
    private Date fechaVencimiento;
    private List<FormasDePago> formasDePago;
	public void recibirOferta(float monto, Usuario ofertante){
		
	}
	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date date) {
		this.fecha = date;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public abstract T getPublicacion();

	public abstract void setPublicacion(T operacion);

	public List<FormasDePago> getFormasDePago() {
		return formasDePago;
	}

	public void setFormasDePago(List<FormasDePago> formasDePago) {
		this.formasDePago = formasDePago;
	}

}
