package com.uade.grupo9.model;

public class Producto {

	private ItemProducto itemProducto;
	private Garantia garantia;
	
	public ItemProducto getItemProducto() {
		return itemProducto;
	}
	public void setItemProducto(ItemProducto itemProducto) {
		this.itemProducto = itemProducto;
	}
	public Producto(ItemProducto itemProducto, Garantia garantia) {
		super();
		this.itemProducto = itemProducto;
		this.setGarantia(garantia);
	}
	
	@Override
    public boolean equals(Object o){
		//Sobreescribo metodo equals para cuando se eval�e dentro del m�todo contains de una lista, tome el criterio que quiero.
        if(o instanceof Producto){
            Producto toCompare = (Producto) o;
            return itemProducto.getNombre().equals(toCompare.itemProducto.getNombre());
        }
        return false;
    }
	public Garantia getGarantia() {
		return garantia;
	}
	public void setGarantia(Garantia garantia) {
		this.garantia = garantia;
	}
	
}
