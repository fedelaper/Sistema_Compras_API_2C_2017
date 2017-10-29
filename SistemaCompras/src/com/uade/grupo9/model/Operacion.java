package com.uade.grupo9.model;

import java.util.Base64;
import java.util.Date;

public abstract class Operacion extends Entidad{

	private String titulo;
	private String descripcion;
	private Base64 imagen;
	private float comision;
	private Date fechaDesde;
	private Date fechaHasta;
	private Venta formaDePago;
	
	public abstract void recibirOferta(float monto, Usuario ofertante);
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Base64 getImagen() {
		return imagen;
	}
	public void setImagen(Base64 imagen) {
		this.imagen = imagen;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public Venta getFormaDePago() {
		return formaDePago;
	}
	public void setFormaDePago(Venta formaDePago) {
		this.formaDePago = formaDePago;
	}
}
