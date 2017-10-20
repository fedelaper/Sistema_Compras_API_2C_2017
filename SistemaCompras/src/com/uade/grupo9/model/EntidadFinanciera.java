package com.uade.grupo9.model;

public abstract class EntidadFinanciera extends Observable {
	public void iniciarTransaccion(Usuario originante, Usuario destinatario, float monto) {
		notificar();
	}
	
}
