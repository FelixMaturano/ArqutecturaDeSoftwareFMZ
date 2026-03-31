/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sis258.ejercicio1proxylibroselectronicos;

/**
 *
 * @author Ruta Binar
 */
public class Main {
    public static void main(String[] args) {
        LibroReal miLibroReal = new LibroReal(
            "Cien Anios de Soledad", 
            "Gabriel Garcia Marquez", 
            1967, 
            "Muchos anios despues, frente al peloton de fusilamiento..."
        );
        
        Libro proxy = new ProxyLibro(miLibroReal);
        
        System.out.println("El usuario intenta leer el libro: ");
        proxy.leer();
    }
    
}
