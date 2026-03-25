/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sis258.abstractfactory;

/**
 *
 * @author Ruta Binar
 */
public class Main {

    public static void main(String[] args) {
        // 1. Elegimos el sistema operativo (La familia de productos)
        // Puedes cambiar esto por new MacFactory() o new LinuxFactory()
        GUIFactory factory = new MacFactory(); 
        
        // 2. Le pasamos la fábrica a nuestra aplicación
        Aplicacion app = new Aplicacion(factory);
        
        // 3. La aplicación arma y muestra la interfaz sin saber las clases concretas
        app.mostrarUI();
    }
    
}
