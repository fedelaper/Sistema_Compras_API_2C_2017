package model;

public class Publicacion extends Operacion {

	private float precio;
	private Producto producto;
	private Servicio servicio;
	
	public void recibirOferta(float monto, Usuario ofertante){
		
	}
	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	
}