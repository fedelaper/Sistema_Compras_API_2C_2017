package com.uade.grupo9.persistencia;

import com.uade.grupo9.model.Contrasenia;
import com.uade.grupo9.model.CtaCorriente;
import com.uade.grupo9.model.Reputacion;
import com.uade.grupo9.model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by pablo on 28/10/17.
 */
public class UsuarioDao extends AbstractDao<Usuario> {
    private static final String TABLA = "Usuario";

    public UsuarioDao() {
        super(TABLA);
    }

    @Override
    protected Usuario getFromResultSet(ResultSet resultSet) {
        try {
            if(resultSet.getRow()==0){
                //tirar excepcion
            }

            return new Usuario(resultSet.getString("nombre"), resultSet.getString("apellido"),
                    resultSet.getString("dni"), resultSet.getString("domicilio"), resultSet.getString("mail"),
                    resultSet.getString("nomUsuario"), new CtaCorriente(), new Reputacion(), new Reputacion(),
                    new Contrasenia(resultSet.getString("contrasena"), resultSet.getDate("fechaUpdatePass")),
                            new ArrayList<>());

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Usuario getByNomUsuario(String nomUsuario) {
        PreparedStatement statement = getStatement("select * from " + TABLA + " where nomUsuario = ?");
        try {
            statement.setString(1, nomUsuario);
            return getFromResultSet(correrQuery(statement), Boolean.TRUE);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
