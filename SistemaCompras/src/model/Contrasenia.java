package model;

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
	
	//ver si la clave esta vencida
	public boolean estaVencida(){
		long diff = (new Date().getTime() - fechaCreacion.getTime()) / (1000 * 60 * 60 * 24);
		return diff > 180;
	}
		
	//validacion de formato de clave
	private boolean validar(String clave){
		return clave.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{8,20}$");
	}
	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) throws Exception {
		if(validar(clave))
		{
			this.clave = clave;
		}else{
			throw new Exception("Clave inválida");
		}
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	
}
