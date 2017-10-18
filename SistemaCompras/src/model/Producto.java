package model;

public class Producto {

	private ItemProducto itemProducto;
	private GtiaExtendida gtiaExtendida;
	
	public ItemProducto getItemProducto() {
		return itemProducto;
	}
	public void setItemProducto(ItemProducto itemProducto) {
		this.itemProducto = itemProducto;
	}
	public GtiaExtendida getGtiaExtendida() {
		return gtiaExtendida;
	}
	public void setGtiaExtendida(GtiaExtendida gtiaExtendida) {
		this.gtiaExtendida = gtiaExtendida;
	}
	public Producto(ItemProducto itemProducto, GtiaExtendida gtiaExtendida) {
		super();
		this.itemProducto = itemProducto;
		this.gtiaExtendida = gtiaExtendida;
	}
	
	@Override
    public boolean equals(Object o){
		//Sobreescribo metodo equals para cuando se evalúe dentro del método contains de una lista, tome el criterio que quiero.
        if(o instanceof Producto){
            Producto toCompare = (Producto) o;
            return itemProducto.getDetalle().equals(toCompare.itemProducto.getDetalle());
        }
        return false;
    }
	
}
