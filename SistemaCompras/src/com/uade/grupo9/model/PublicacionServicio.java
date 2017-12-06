package com.uade.grupo9.model;


/**
 * Created by pablo on 22/10/17.
 */
public class PublicacionServicio extends Publicacion<Servicio> {
    private Servicio servicio;

    public PublicacionServicio(float precio, Servicio servicio) {
        super();
        this.setPrecio(precio);
        this.servicio = servicio;
    }

    @Override
    public Servicio getPublicacion() {
        return servicio;
    }

    @Override
    public void setPublicacion(Servicio operacion) {
        servicio = operacion;
    }

}
