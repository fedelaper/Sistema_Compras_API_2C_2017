package model;

public abstract class Venta {

	private Usuario comprador;
	private Usuario vendedor;
	private float montoVenta;
	
	public Usuario getComprador() {
		return comprador;
	}
	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}
	public Usuario getVendedor() {
		return vendedor;
	}
	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}
	public float getMontoVenta() {
		return montoVenta;
	}
	public void setMontoVenta(float montoVenta) {
		this.montoVenta = montoVenta;
	}
	
}
