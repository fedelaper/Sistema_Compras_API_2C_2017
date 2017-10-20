package com.uade.grupo9.model;

public abstract class EntidadFinanciera {
	public abstract void iniciarTransaccion(Usuario originante, Usuario destinatario, Double monto);
	
}
