package com.uade.grupo9.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uade.grupo9.model.Contrasenia;
import com.uade.grupo9.model.Producto;
import com.uade.grupo9.model.Servicio;
import com.uade.grupo9.model.Usuario;

public class UsuariosController {

	private List<Usuario> usuarios;
	private List<Producto> productos;
	private List<Servicio> servicios;
	
	public UsuariosController(){
		this.usuarios = new ArrayList<Usuario>();
		this.productos = new ArrayList<Producto>();
		this.servicios = new ArrayList<Servicio>();
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public void altaUsuario(Usuario usuario) throws Exception{
		
		if(!this.usuarios.contains(usuario))
		{
			this.usuarios.add(usuario);
		}else
		{
			throw new Exception("Usuario ya existente.");
		}
		
	}
	
	public void bajaUsuario(Usuario usuario)
	{
		for(Usuario item : this.usuarios)
		{
			if(item.sosElUsuario(usuario)){
				this.usuarios.remove(item);
				break;
			}
		}
	}

	public void modificarUsuario(Usuario usuario)
	{
		for(Usuario item : this.usuarios)
		{
			if(item.sosElUsuario(usuario)){
				item.setDomicilio(usuario.getDomicilio());
				item.setMail(usuario.getMail());
				break;
			}
		}
	}
	
	public void aumentarSaldoCuentaCorrienteDeUsuario(Usuario usuario, float monto){
		float saldoModificado = usuario.getCtaCorriente().getSaldo() + monto;
		usuario.getCtaCorriente().setSaldo(saldoModificado);
	}
	
	public void disminuirSaldoCuentaCorrienteDeUsuario(Usuario usuario, float monto){
		float saldoModificado = usuario.getCtaCorriente().getSaldo() - monto;
		usuario.getCtaCorriente().setSaldo(saldoModificado);
	}
	
	public void altaProducto(Producto producto){
		if(!this.productos.contains(producto)){
			this.productos.add(producto);
		}
	}
	
	public void bajaProducto(Producto producto){
		if(this.productos.contains(producto)){
			this.productos.remove(producto);
		}
	}

	public void altaServicio(Servicio servicio){
		if(!this.servicios.contains(servicio)){
			this.servicios.add(servicio);
		}
	}
	
	public void bajaServicio(Servicio servicio){
		if(this.servicios.contains(servicio)){
			this.servicios.remove(servicio);
		}
	}
	
	public boolean validarFormatoContraseniaUsuario(String clave){
		return clave.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).{8,20}$");
	}
	
	/*
	 * True si no esta expirada. Caso contrario, false.
	 * */
	public boolean validarExpiracionContraseniaUsuario(Contrasenia contrasenia){
		long diff = (new Date().getTime() - contrasenia.getFechaCreacion().getTime()) / (1000 * 60 * 60 * 24);
		return diff < 180;
	}


}
