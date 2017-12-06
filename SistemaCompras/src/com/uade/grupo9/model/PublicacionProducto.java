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
    public Producto getPublicacion() {
        return producto;
    }

    @Override
    public void setPublicacion(Producto operacion) {
        producto = operacion;
    }
}
