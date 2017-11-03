package com.uade.grupo9.model;

import java.util.Date;

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
    public Servicio getOperacion() {
        return servicio;
    }

    @Override
    public void setOperacion(Servicio operacion) {
        servicio = operacion;
    }

}
