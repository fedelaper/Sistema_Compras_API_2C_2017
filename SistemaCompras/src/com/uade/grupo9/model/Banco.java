package com.uade.grupo9.model;

public class Banco extends EntidadFinanciera {
	private String nombre;
	
	public Banco(String nombre) {
		this.nombre = nombre;
	}
	
	public String nombre() {
		return nombre;
	}

}
