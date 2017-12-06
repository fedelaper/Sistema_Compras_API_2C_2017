package com.uade.grupo9.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.uade.grupo9.model.FormasDePago;
import com.uade.grupo9.model.Garantia;
import com.uade.grupo9.model.ItemProducto;
import com.uade.grupo9.model.ItemServicio;
import com.uade.grupo9.model.Producto;
import com.uade.grupo9.model.PublicacionProducto;
import com.uade.grupo9.model.PublicacionServicio;
import com.uade.grupo9.model.Servicio;
import com.uade.grupo9.persistencia.PublicacionProductoDAO;
import com.uade.grupo9.persistencia.PublicacionServicioDAO;

public class PublicacionController {

	private List<Producto> productos;
	private List<Servicio> servicios;
	private PublicacionServicioDAO publicacionServicioDAO;
	private PublicacionProductoDAO publicacionProductoDAO;
	private int diasVigenciaPublicacion = 7;
	
	public PublicacionController(){
		this.productos = new ArrayList<Producto>();
		this.servicios = new ArrayList<Servicio>();
		publicacionServicioDAO = new PublicacionServicioDAO();
		publicacionProductoDAO = new PublicacionProductoDAO();
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
	
	public void altaPublicacionServicio(String detalle, String nombre, String tipoContratacion, String nombreUsuario, float precio, boolean formaPagoEfectivo, boolean formaPagoTarjetaCredito, boolean formaPagoTransferenciaBancaria){
		ItemServicio itemServicio = new ItemServicio(detalle, nombre, tipoContratacion);
		Servicio servicio = new Servicio(itemServicio);
		publicacionServicioDAO.saveServicio(servicio);
		
		PublicacionServicio pServicio = new PublicacionServicio(precio, servicio);
		pServicio.setFecha(new Date());
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, diasVigenciaPublicacion); 
		pServicio.setFechaVencimiento(c.getTime());
		pServicio.setFormasDePago(cargarFormasDePago(formaPagoEfectivo,formaPagoTarjetaCredito,formaPagoTransferenciaBancaria));
		
		publicacionServicioDAO.savePublicacion(pServicio, nombreUsuario, servicio.getItemServicio().getNombre());
		
	}
	
	public void altaPublicacionProducto(String detalle, String nombre, String tipoGarantia, int tiempoGarantia, String nombreUsuario, float precio, boolean formaPagoEfectivo, boolean formaPagoTarjetaCredito, boolean formaPagoTransferenciaBancaria){
		ItemProducto itemProducto = new ItemProducto(precio, detalle, nombre);
		Garantia garantia = new Garantia();
		garantia.setCantidadDeDias(tiempoGarantia);
		garantia.setTipo(tipoGarantia);
		Producto producto = new Producto(itemProducto, garantia);
		publicacionProductoDAO.saveProducto(producto);
		
		PublicacionProducto pProducto = new PublicacionProducto(producto); 
		pProducto.setFecha(new Date());
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, diasVigenciaPublicacion); 
		pProducto.setFechaVencimiento(c.getTime());
		pProducto.setFormasDePago(cargarFormasDePago(formaPagoEfectivo,formaPagoTarjetaCredito,formaPagoTransferenciaBancaria));
		
		publicacionProductoDAO.savePublicacion(pProducto, nombreUsuario, producto.getItemProducto().getNombre());
		
	}
	
	private List<FormasDePago> cargarFormasDePago(boolean formaPagoEfectivo, boolean formaPagoTarjetaCredito, boolean formaPagoTransferenciaBancaria){

		List<FormasDePago> formasDePago = new ArrayList<FormasDePago>();
		if(formaPagoEfectivo){
			formasDePago.add(FormasDePago.Efectivo);
		}
		if(formaPagoTarjetaCredito){
			formasDePago.add(FormasDePago.Efectivo);
		}
		if(formaPagoTransferenciaBancaria)
			formasDePago.add(FormasDePago.TransferenciaBancaria);
		return formasDePago;
	}
}
