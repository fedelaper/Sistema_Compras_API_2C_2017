package com.uade.grupo9.persistencia;

import com.uade.grupo9.model.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by pablo on 22/10/17.
 */
public class PublicacionServicioDAO extends AbstractDao<PublicacionServicio> {
    private static String TABLA = "dbo.Servicios";
    private static String QUERY_COMUN = "select * from " + TABLA + " s inner join dbo.Operacion o on " +
            "s.idOperacion = o.idOperacion ";
    private static String QUERY_INSERT_SERVICIO = "INSERT INTO " + TABLA + " ([detalle],[nombre],[tipoContratacion]) VALUES(?,?,?)";
    private static String QUERY_INSERT_PUBLICACION = "INSERT INTO [dbo].[Publicaciones] ([nombreUsuario] ,[nombreProductoServicio],[tipo],[fechaPublicacion],[fechaHastaVigenciaPublicacion],[precio],[efectivo],[tarjeta],[transferencia]) VALUES(?,?,?,?,?,?,?,?,?)";
    
    
    public PublicacionServicioDAO() {
        super(TABLA);
    }

    @Override
    protected ResultSet getAll(String tabla) {
        PreparedStatement statement = getStatement(QUERY_COMUN);
        return correrQuery(statement);
    }

    @Override
    protected Map<String, Object> getComoMapa(PublicacionServicio entidad) {
        return null;
    }

    @Override
    protected PublicacionServicio getFromResultSet(ResultSet resultSet) {
        try {
            ItemServicio itemServicio = new ItemServicio(resultSet.getString("descripcion"),
                    resultSet.getString("nombre"),resultSet.getString("tipoContratacion"));
            Servicio servicio = new Servicio(itemServicio);
            
            //Carga de formas de pago de la publicación
            List<FormasDePago> formasDePago = new ArrayList<FormasDePago>();
            
            if(resultSet.getString("efectivo") == "1"){
            	formasDePago.add(FormasDePago.Efectivo);
            }
            
            if(resultSet.getString("tarjeta") == "1"){
            	formasDePago.add(FormasDePago.TarjetaCredito);
            }
            
            if(resultSet.getString("transferencia") == "1"){
            	formasDePago.add(FormasDePago.TransferenciaBancaria);
            }
            
            PublicacionServicio publicacion = new PublicacionServicio(resultSet.getFloat("precio"), servicio);
            publicacion.setFecha(resultSet.getDate("fecha"));
            publicacion.setFechaVencimiento(resultSet.getDate("fechaHastaVigenciaPublicacion"));
            publicacion.setFormasDePago(formasDePago);
            return publicacion;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public PublicacionServicio getById(Integer id) {
        PreparedStatement statement = getStatement(QUERY_COMUN + " where o.idOperacion = ?");
        return getById(statement, id);
    }
    
    public void saveServicio(Servicio servicio){
    	PreparedStatement statement = getStatement(QUERY_INSERT_SERVICIO);
    	try {
			statement.setString(1, servicio.getItemServicio().getDetalle());
			statement.setString(2, servicio.getItemServicio().getNombre());
			statement.setString(3, servicio.getItemServicio().getTipoContratacion());
			correrQuery(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void savePublicacion(PublicacionServicio pServicio, String nomUsuario, String nombreServicio){
    	PreparedStatement statement = getStatement(QUERY_INSERT_PUBLICACION);
    	try {
			statement.setString(1, nomUsuario);
			statement.setString(2, nombreServicio);
			statement.setString(3, "Servicio");
			
			statement.setDate(4, new java.sql.Date(pServicio.getFecha().getTime()));
			statement.setDate(5, new java.sql.Date(pServicio.getFechaVencimiento().getTime()));
			statement.setFloat(6, pServicio.getPrecio());
			statement.setString(7, pServicio.getFormasDePago().contains(FormasDePago.Efectivo) ? "1" : "0");
			statement.setString(8, pServicio.getFormasDePago().contains(FormasDePago.TarjetaCredito) ? "1" : "0");
			statement.setString(9, pServicio.getFormasDePago().contains(FormasDePago.TransferenciaBancaria) ? "1" : "0");
			correrQuery(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
