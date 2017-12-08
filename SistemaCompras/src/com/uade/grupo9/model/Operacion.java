package com.uade.grupo9.model;

import java.util.Base64;

public abstract class Operacion extends Entidad{

	private Base64 imagen;
	private float comision;
	private Venta formaDePago;
	
	public abstract void recibirOferta(float monto, Usuario ofertante);
	
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
	
	public Venta getFormaDePago() {
		return formaDePago;
	}
	public void setFormaDePago(Venta formaDePago) {
		this.formaDePago = formaDePago;
	}
}
