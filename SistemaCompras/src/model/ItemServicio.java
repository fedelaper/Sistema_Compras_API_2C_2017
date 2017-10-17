package model;

public class ItemServicio {

	private String detalle;
	private float precio;
	
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public ItemServicio(String detalle, float precio) {
		super();
		this.detalle = detalle;
		this.precio = precio;
	}
	
	
	
}
