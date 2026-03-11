/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.estudiantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Felix
 */
public class ConexionPostgreSQL implements IConexionBD {

    private static final String URL      = "jdbc:postgresql://localhost:5432/bd_estudiantes";
    private static final String USUARIO  = "postgres";
    private static final String PASSWORD = "postgres";

    @Override
    public Connection obtenerConexion() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver PostgreSQL no encontrado", e);
        }
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}
