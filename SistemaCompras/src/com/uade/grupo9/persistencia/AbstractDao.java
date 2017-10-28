package com.uade.grupo9.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pablo on 22/10/17.
 */
public abstract class AbstractDao<T> {
    private String tabla;
    private ConexionManager conexionManager;

    protected AbstractDao(String tabla) {
        this.tabla = tabla;
        conexionManager = new ConexionManager();
    }

    public T getById(Integer id) {
        PreparedStatement statement = getStatement("select * from " + tabla + " where id" + tabla + " = ?");
        return getById(statement, id);
    }

    protected T getById(PreparedStatement statement, Integer id) {
        try {
            statement.setInt(1, id);
            return getFromResultSet(correrQuery(statement), Boolean.TRUE);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<T> getTodos() {
        ResultSet resultSet = getAll(tabla);
        List<T> lista = new ArrayList<>();
        try {
            while (resultSet.next()) {
                lista.add(getFromResultSet(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    protected abstract T getFromResultSet(ResultSet resultSet);

    protected T getFromResultSet(ResultSet resultSet, Boolean onlyOne){
        if(onlyOne){
            try {
                resultSet.next();
                return getFromResultSet(resultSet);
            }catch (SQLException e){
                e.printStackTrace();
                return null;
            }
        }else{
            return getFromResultSet(resultSet);
        }
    }

    protected ResultSet getAll(String tabla) {
        PreparedStatement statement = getStatement("select * from " + tabla);
        return correrQuery(statement);
    }

    protected ResultSet correrQuery(PreparedStatement statement) {
        try {
            ResultSet resultSet = statement.executeQuery();
            //conexionManager.getCon().close();

            return resultSet;
        } catch (SQLException e) {
            System.out.println("Error Query: " + e.getMessage());
            return null;
        }
    }

    protected PreparedStatement getStatement(String query) {
        try {
            return conexionManager.getCon().prepareStatement(query);
        } catch (SQLException e) {
            System.out.println("Error Query: " + e.getMessage());
            return null;
        }
    }
}
