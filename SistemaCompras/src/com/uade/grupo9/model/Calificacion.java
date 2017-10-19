package com.uade.grupo9.model;

import java.util.Date;

public class Calificacion {

	private Usuario usuarioCalificador;
	private Operacion operacionCalificada;
	private String observaciones;
	private Date fecha;
	
	//El valor de la calificaci�n puede ser de 1 a 10
	private int valor; 
	
	public Usuario getUsuarioCalificador() {
		return usuarioCalificador;
	}
	public void setUsuarioCalificador(Usuario usuarioCalificador) {
		this.usuarioCalificador = usuarioCalificador;
	}
	public Operacion getOperacionCalificada() {
		return operacionCalificada;
	}
	public void setOperacionCalificada(Operacion operacionCalificada) {
		this.operacionCalificada = operacionCalificada;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Calificacion(Usuario usuarioCalificador, Operacion operacionCalificada, String observaciones, Date fecha) {
		super();
		this.usuarioCalificador = usuarioCalificador;
		this.operacionCalificada = operacionCalificada;
		this.observaciones = observaciones;
		this.fecha = fecha;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
