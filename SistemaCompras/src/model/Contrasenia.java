package model;

import java.util.Date;

public class Contrasenia {

	private String clave;
	private String nuevaClave;
	private Date fechaCreacion;

	public void cambiarClave(String viejaClave, String nuevaClave) throws Exception{
		if(this.clave.equals(viejaClave) && validar(nuevaClave)){
			this.clave = nuevaClave;
			return;
		}else{
			throw new Exception("Clave inválida.");
		}
	}
	
	//ver si la clave esta vencida
		public boolean estaVencida(){
			long diff = (new Date().getTime() - fechaCreacion.getTime()) / (1000 * 60 * 60 * 24);
			return diff > 180;
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

	public Contrasenia(String clave, String nuevaClave, Date fechaCreacion) {
		super();
		this.clave = clave;
		this.nuevaClave = nuevaClave;
		this.fechaCreacion = fechaCreacion;
	}

	public Contrasenia() {
		super();
	}
	
}
