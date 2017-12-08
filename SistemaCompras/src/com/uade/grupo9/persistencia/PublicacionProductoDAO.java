package com.uade.grupo9.persistencia;

import com.uade.grupo9.model.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by pablo on 22/10/17.
 */
public class PublicacionProductoDAO extends AbstractDao<PublicacionProducto> {
    private static String TABLA = "dbo.Producto";
    private static String QUERY_COMUN = "select * from " + TABLA + " s inner join dbo.Publicaciones p on " +
            "s.Nombre = p.NombreProductoServicio and p.Tipo = 'Producto' ";
    private static String QUERY_INSERT_PRODUCTO = "INSERT INTO " + TABLA + "([tiempoGarantia],[detalle],[Nombre],[tipoGarantia])VALUES(?,?,?,?)";
    private static String QUERY_INSERT_PUBLICACION = "INSERT INTO [dbo].[Publicaciones] ([nombreUsuario] ,[nombreProductoServicio],[tipo],[fechaPublicacion],[fechaHastaVigenciaPublicacion],[precio],[efectivo],[tarjeta],[transferencia]) VALUES(?,?,?,?,?,?,?,?,?)";
    public PublicacionProductoDAO() {
        super(TABLA);
    }

    @Override
    protected ResultSet getAll(String tabla) {
        PreparedStatement statement = getStatement(QUERY_COMUN);
        return correrQuery(statement);
    }

    @Override
    protected Map<String, Object> getComoMapa(PublicacionProducto entidad) {
        return null;
    }

    @Override
    protected PublicacionProducto getFromResultSet(ResultSet resultSet) {
        try {
            ItemProducto itemProducto = new ItemProducto(resultSet.getFloat("precio"),
                    resultSet.getString("descripcion"), resultSet.getString("nombre"));
            Garantia gtiaExtendida = new Garantia();
            gtiaExtendida.setCantidadDeDias(resultSet.getInt("cantMesesGtia"));
            gtiaExtendida.setFechaDeCompra(resultSet.getDate("fechaGarantia"));
            Producto producto = new Producto(itemProducto, gtiaExtendida);
            PublicacionProducto publicacion = new PublicacionProducto(producto);
            return publicacion;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PublicacionProducto getById(Integer id) {
        PreparedStatement statement = getStatement(QUERY_COMUN + " where o.idOperacion = ?");
        return getById(statement, id);
    }
    
    public void saveProducto(Producto producto){
    	PreparedStatement statement = getStatement(QUERY_INSERT_PRODUCTO);
    	try {
			statement.setString(1, Integer.toString(producto.getGarantia().getCantidadDeDias()));
			statement.setString(2, producto.getItemProducto().getDetalle());
			statement.setString(3, producto.getItemProducto().getNombre());
			statement.setString(4, producto.getGarantia().getTipo());
			correrQuery(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void savePublicacion(PublicacionProducto pServicio, String nomUsuario, String nombreProducto){
    	PreparedStatement statement = getStatement(QUERY_INSERT_PUBLICACION);
    	try {
			statement.setString(1, nomUsuario);
			statement.setString(2, nombreProducto);
			statement.setString(3, "Producto");
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
