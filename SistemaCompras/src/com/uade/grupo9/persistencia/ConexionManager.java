package com.uade.grupo9.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by pablo on 21/10/17.
 */
public class ConexionManager {
    private Connection con;
    private static ConexionManager manager;

    private void connect() {
        try {
            String userName = "sa";
            String password = "Adminadmin1!";
            String url = "jdbc:sqlserver://localhost;databaseName=API";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(url, userName, password);

        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            e.printStackTrace();
        }

    }

    public Connection getCon(){
        try {
            if(con==null || con.isClosed()){
                connect();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void close() {
        try {
            if (!con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
