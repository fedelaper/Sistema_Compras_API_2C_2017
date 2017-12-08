package com.uade.grupo9.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    protected T getFromResultSet(ResultSet resultSet, Boolean onlyOne) {
        if (onlyOne) {
            try {
                resultSet.next();
                return getFromResultSet(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } else {
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
    

    protected abstract Map<String, Object> getComoMapa(T entidad);

    protected Integer insert(Map<String, Object> valores) throws SQLException {
        StringBuilder query = new StringBuilder("insert into " + tabla + " (");
        StringBuilder data = new StringBuilder("(");
        for (String key : valores.keySet()) {
            query.append(key + ", ");
            data.append("?,");
        }
        query.append(") values (").append(data).append(")");

        PreparedStatement statement = conexionManager.getCon().prepareStatement(query.toString(),
                Statement.RETURN_GENERATED_KEYS);

        int i = 1;
        for (Object object : valores.values()) {
            statement.setObject(i, object);
            i++;
        }

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("El insert fallo.");
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Fallo el insert, no se obtuvo id.");
            }
        }

    }

    protected void update(Map<String, Object> valores, Integer id) throws SQLException {
        StringBuilder query = new StringBuilder("update " + tabla + " set ");
        for (String key : valores.keySet()) {
            query.append(key + "= ? and ");
        }
        query.append("where id").append(tabla).append("= ?");

        PreparedStatement statement = getStatement(query.toString());

        int i = 1;
        for (Object obj : valores.values()) {
            statement.setObject(i, obj);
            i++;
        }
        statement.setInt(i, id);

        int filas = statement.executeUpdate();
        if (filas == 0) {
            throw new SQLException("El update fallo");
        }
    }


}
