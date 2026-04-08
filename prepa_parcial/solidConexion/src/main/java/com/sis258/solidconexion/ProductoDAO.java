/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.solidconexion;

/**
 *
 * @author Ruta Binar
 */
public class ProductoDAO {
    // No usa conexionMysql directamente, usa interfaz 
    // la variable puede guardar cualquier objeto que si impl.. ICon..
    private IConexion conexion;

    // le pasan conexion desde afuera
    public ProductoDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    public void guardar(){
        conexion.conectar();
        System.out.println("Guardando producto...");
    }
}
