package com.uade.grupo9.model;

import java.util.Date;

public class Contrasenia {

	private String clave;
	private Date fechaCreacion;

	public Contrasenia(String clave, Date fechaCreacion) {
		super();
		this.clave = clave;
		this.fechaCreacion = fechaCreacion;
	}

	public Contrasenia() {
		super();
	}
	
	public void cambiarClave(String viejaClave, String nuevaClave) throws Exception{
		if(viejaClave.equals(this.clave)){
			this.setClave(nuevaClave);
		}else{
			throw new Exception("Clave vieja ingresada no coincide con clave actual.");
		}
	}
	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) throws Exception {
		this.clave = clave;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	
}
