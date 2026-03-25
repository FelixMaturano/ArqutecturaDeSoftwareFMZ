/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.abstractfactory;

/**
 *
 * @author Ruta Binar
 */
public class Aplicacion {
    private GUIFactory factory;

    // La aplicación recibe la fábrica sin saber de qué sistema es
    public Aplicacion(GUIFactory factory) {
        this.factory = factory;
    }

    public void mostrarUI() {
        Boton boton = factory.crearBoton();
        Casilla casilla = factory.crearCasilla();
        
        boton.dibujar();
        casilla.dibujar();
    }
}
