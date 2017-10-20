package com.uade.grupo9.model;

public class Banco extends EntidadFinanciera {
	private String nombre;
	
	public Banco(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public void iniciarTransaccion(Usuario originante, Usuario destinatario, Double monto) {
		// TODO Auto-generated method stub
		
	}

}
