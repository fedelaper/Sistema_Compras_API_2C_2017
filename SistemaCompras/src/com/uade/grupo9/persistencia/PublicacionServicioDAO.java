package com.uade.grupo9.persistencia;

import com.uade.grupo9.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by pablo on 22/10/17.
 */
public class PublicacionServicioDAO extends AbstractDao<PublicacionServicio> {
    private static String TABLA = "dbo.Servicio";
    private static String QUERY_COMUN = "select * from " + TABLA + " s inner join dbo.Operacion o on " +
            "s.idOperacion = o.idOperacion ";

    public PublicacionServicioDAO() {
        super(TABLA);
    }

    @Override
    protected ResultSet getAll(String tabla) {
        PreparedStatement statement = getStatement(QUERY_COMUN);
        return correrQuery(statement);
    }

    @Override
    protected PublicacionServicio getFromResultSet(ResultSet resultSet) {
        try {
            ItemServicio itemServicio = new ItemServicio(resultSet.getString("descripcion"),
                    resultSet.getFloat("precio"));
            Boolean contratacionAbono = resultSet.getBoolean("contratacionAbono");
            Comision comision = new Comision(getContratacion(contratacionAbono));
            Servicio servicio = new Servicio(itemServicio, comision);
            PublicacionServicio publicacion = new PublicacionServicio(resultSet.getFloat("precio"), servicio);
            return publicacion;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PublicacionServicio getById(Integer id) {
        PreparedStatement statement = getStatement(QUERY_COMUN + " where o.idOperacion = ?");
        return getById(statement, id);
    }

    private Contratacion getContratacion(Boolean contratacionAbono){
        if(contratacionAbono){
            return new PorAbono();
        }else{
            return new UnicaVez();
        }
    }
}
