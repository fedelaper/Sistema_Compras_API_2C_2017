package com.uade.grupo9.model;

/**
 * Created by pablo on 22/10/17.
 */
public class PublicacionProducto extends Publicacion<Producto> {
    private Producto producto;

    public PublicacionProducto(Producto producto) {
        super();
        this.producto = producto;
    }

    @Override
    public Producto getOperacion() {
        return producto;
    }

    @Override
    public void setOperacion(Producto operacion) {
        producto = operacion;
    }
}
