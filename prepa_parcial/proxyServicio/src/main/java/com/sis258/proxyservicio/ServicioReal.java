/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.proxyservicio;

/**
 *
 * @author Ruta Binar
 */
public class ServicioReal implements IServicio{

    @Override
    public void mostrar() {
        System.out.println("Accediendo a servicio real....");
    }
    
}
