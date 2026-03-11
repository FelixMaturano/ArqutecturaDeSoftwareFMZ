/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sis258.estudiantes;

import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Felix
 */
public interface IConexionBD {
    Connection obtenerConexion() throws SQLException;
}
