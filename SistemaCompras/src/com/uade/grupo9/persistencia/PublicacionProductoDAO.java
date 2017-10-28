package com.uade.grupo9.persistencia;

import com.uade.grupo9.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by pablo on 22/10/17.
 */
public class PublicacionProductoDAO extends AbstractDao<PublicacionProducto> {
    private static String TABLA = "dbo.Producto";
    private static String QUERY_COMUN = "select * from " + TABLA + " s inner join dbo.Operacion o on " +
            "s.idOperacion = o.idOperacion ";

    public PublicacionProductoDAO() {
        super(TABLA);
    }

    @Override
    protected ResultSet getAll(String tabla) {
        PreparedStatement statement = getStatement(QUERY_COMUN);
        return correrQuery(statement);
    }

    @Override
    protected PublicacionProducto getFromResultSet(ResultSet resultSet) {
        try {
            ItemProducto itemProducto = new ItemProducto(resultSet.getFloat("precio"),
                    resultSet.getString("descripcion"));
            GtiaExtendida gtiaExtendida = new GtiaExtendida();
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

}
