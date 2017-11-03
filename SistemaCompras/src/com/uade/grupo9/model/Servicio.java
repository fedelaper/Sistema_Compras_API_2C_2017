package com.uade.grupo9.model;

public class Servicio {

	private ItemServicio itemServicio;
	
	public ItemServicio getItemServicio() {
		return itemServicio;
	}
	public void setItemServicio(ItemServicio itemServicio) {
		this.itemServicio = itemServicio;
	}
	public Servicio(ItemServicio itemServicio) {
		super();
		this.itemServicio = itemServicio;
	}
	
	@Override
    public boolean equals(Object o){
		//Sobreescribo metodo equals para cuando se eval�e dentro del m�todo contains de una lista, tome el criterio que quiero.
        if(o instanceof Servicio){
        	Servicio toCompare = (Servicio) o;
            return itemServicio.getNombre().equals(toCompare.itemServicio.getNombre());
        }
        return false;
    }
	

	
}
