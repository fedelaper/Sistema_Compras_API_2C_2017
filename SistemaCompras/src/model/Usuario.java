package model;

import java.util.List;

public class Usuario {

	private String nombre;
	private String apellido;
	private String dni;
	private String domicilio;
	private String mail;
	private String nombreUsuario;
//	private CtaCorriente ctaCorriente;
	private Reputacion reputacionCompra;
	private Reputacion reputacionVenta;
	private List<Operacion> operaciones;
	private Contrasenia contrasenia;
	
	
	public boolean sosElUsuario(Usuario usuario){
		//ver esta validacion xq no es bueno haerla x dni
		return (this.getDni().equals(usuario.getDni()));
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public Reputacion getReputacionCompra() {
		return reputacionCompra;
	}
	public void setReputacionCompra(Reputacion reputacionCompra) {
		this.reputacionCompra = reputacionCompra;
	}
	public Reputacion getReputacionVenta() {
		return reputacionVenta;
	}
	public void setReputacionVenta(Reputacion reputacionVenta) {
		this.reputacionVenta = reputacionVenta;
	}
	public List<Operacion> getOperaciones() {
		return operaciones;
	}
	public void setOperaciones(List<Operacion> operaciones) {
		this.operaciones = operaciones;
	}
	public Contrasenia getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(Contrasenia contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
		
}
