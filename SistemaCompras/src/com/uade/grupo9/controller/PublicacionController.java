package com.uade.grupo9.controller;

import java.util.ArrayList;
import java.util.List;

import com.uade.grupo9.model.Producto;
import com.uade.grupo9.model.Servicio;

public class PublicacionController {

	private List<Producto> productos;
	private List<Servicio> servicios;
	
	public PublicacionController(){
		this.productos = new ArrayList<Producto>();
		this.servicios = new ArrayList<Servicio>();
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
}
