package model;

import java.util.Date;

public class Calificacion {

	private Usuario UsuarioCalificador;
	private Operacion operacionCalificada;
	private String observaciones;
	private Date fecha;
	
	public Usuario getUsuarioCalificador() {
		return UsuarioCalificador;
	}
	public void setUsuarioCalificador(Usuario usuarioCalificador) {
		UsuarioCalificador = usuarioCalificador;
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
		UsuarioCalificador = usuarioCalificador;
		this.operacionCalificada = operacionCalificada;
		this.observaciones = observaciones;
		this.fecha = fecha;
	}
	
}
