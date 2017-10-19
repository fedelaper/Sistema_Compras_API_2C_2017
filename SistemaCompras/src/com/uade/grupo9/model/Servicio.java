package com.uade.grupo9.model;

public class Servicio {

	private ItemServicio itemServicio;
	private Comision comision;
	
	public ItemServicio getItemServicio() {
		return itemServicio;
	}
	public void setItemServicio(ItemServicio itemServicio) {
		this.itemServicio = itemServicio;
	}
	public Comision getComision() {
		return comision;
	}
	public void setComision(Comision comision) {
		this.comision = comision;
	}
	public Servicio(ItemServicio itemServicio, Comision comision) {
		super();
		this.itemServicio = itemServicio;
		this.comision = comision;
	}
	
	@Override
    public boolean equals(Object o){
		//Sobreescribo metodo equals para cuando se eval�e dentro del m�todo contains de una lista, tome el criterio que quiero.
        if(o instanceof Servicio){
        	Servicio toCompare = (Servicio) o;
            return itemServicio.getDetalle().equals(toCompare.itemServicio.getDetalle());
        }
        return false;
    }
	

	
}
