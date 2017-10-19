package com.uade.grupo9.model;

public class Comision {

	private Contratacion contratacion;
	
	public float calcularComision(){
		return 0;
	}

	public Contratacion getContratacion() {
		return contratacion;
	}

	public void setContratacion(Contratacion contratacion) {
		this.contratacion = contratacion;
	}

	public Comision(Contratacion contratacion) {
		super();
		this.contratacion = contratacion;
	}
	
}
