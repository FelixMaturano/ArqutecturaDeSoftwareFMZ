/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.solidconexion;

/**
 *
 * @author Ruta Binar
 */
public class ConexionPostgreSQL implements IConexion{

    @Override
    public void conectar() {
        System.out.println("Conectando a PostgreSQL....");
    }
    
}
