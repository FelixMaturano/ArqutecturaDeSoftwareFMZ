/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sis258.solidconexion;

/**
 *
 * @author Ruta Binar
 */
public class Main {
    public static void main(String[] args) {
        //Cambia aqui la implementacion
        IConexion conexion = new ConexionPostgreSQL();
        ProductoDAO dao =  new ProductoDAO(conexion);
        dao.guardar();
        
    }
    
}
