package com.uade.grupo9.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre;
	private String apellido;
	private String dni;
	private String domicilio;
	private String mail;
	private String nombreUsuario;
	private CtaCorriente ctaCorriente;
	private Reputacion reputacionCompra;
	private Reputacion reputacionVenta;
	private List<Operacion> operaciones;
	private Contrasenia contrasenia;
	
	
	public Usuario(String nombre, String apellido, String dni, String domicilio, String mail, String nombreUsuario, CtaCorriente ctaCorriente, Reputacion reputacionCompra, Reputacion reputacionVenta, Contrasenia contrasenia, List<Operacion> operaciones)
	{
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(dni);
		this.setDomicilio(domicilio);
		this.setMail(mail);
		this.setNombreUsuario(nombreUsuario);
		this.setCtaCorriente(ctaCorriente.equals(null) ? new CtaCorriente() : ctaCorriente);
		this.setReputacionCompra(reputacionCompra.equals(null) ? new Reputacion() : reputacionCompra);
		this.setReputacionVenta(reputacionVenta.equals(null) ? new Reputacion () : reputacionVenta);
		this.setContrasenia(contrasenia.equals(null) ? new Contrasenia() : contrasenia);
		this.setOperaciones(operaciones.equals(null) ? new ArrayList<Operacion>() : operaciones);
	}
	
	public boolean sosElUsuario(Usuario usuario){
		//Validamos DNI, NOMBRE Y APELLIDO
		return (this.getDni().equals(usuario.getDni())) && this.getNombre().toLowerCase().equals(usuario.getNombre().toLowerCase()) && this.getApellido().toLowerCase().equals(usuario.getApellido().toLowerCase());
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

	public CtaCorriente getCtaCorriente() {
		return ctaCorriente;
	}

	public void setCtaCorriente(CtaCorriente ctaCorriente) {
		this.ctaCorriente = ctaCorriente;
	}

	public Usuario(String nombre, String apellido, String dni, String domicilio, String mail, String nombreUsuario,
			CtaCorriente ctaCorriente, Reputacion reputacionCompra, Reputacion reputacionVenta,
			List<Operacion> operaciones, Contrasenia contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
		this.mail = mail;
		this.nombreUsuario = nombreUsuario;
		this.ctaCorriente = ctaCorriente;
		this.reputacionCompra = reputacionCompra;
		this.reputacionVenta = reputacionVenta;
		this.operaciones = operaciones;
		this.contrasenia = contrasenia;
	}
	
	@Override
	public boolean equals(Object o){
		//Sobreescribo metodo equals para cuando se eval�e dentro del m�todo contains de una lista, tome el criterio que quiero.
        if(o instanceof Usuario){
        	Usuario toCompare = (Usuario) o;
        	return sosElUsuario(toCompare);
        }
        return false;
	}
		
}
