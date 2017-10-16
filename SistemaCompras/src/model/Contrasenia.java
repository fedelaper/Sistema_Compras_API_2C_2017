package model;

import java.util.Date;

public class Contrasenia {

	private String clave;
	private String nuevaClave;
	private Date fechaCreacion;

	private void cambiarClave(String viejaClave, String nuevaClave){
		if(this.clave.equals(viejaClave) && validar(nuevaClave)){
			this.clave = nuevaClave;
			return;
		}
		return;
	}
	
	//TODO ver si la clave esta vencida
	public boolean estaVencida(){
		return false;
	}
	
	//TODO validacion de formato de clave
	private boolean validar(String clave){
		return true;
	}

	public String getNuevaClave() {
		return nuevaClave;
	}

	public void setNuevaClave(String nuevaClave) {
		this.nuevaClave = nuevaClave;
	}

	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
}
