/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.ejercicio1proxylibroselectronicos;

/**
 *
 * @author Ruta Binar
 */
public class ProxyLibro implements Libro {

    private LibroReal libroReal;

    public ProxyLibro(LibroReal libroReal) {
        this.libroReal = libroReal;
    }

    @Override
    public void leer() {
        // 1. Control de acceso (El trabajo extra del Proxy)
        System.out.println("Verificando permisos..."); // 

        // 2. Delegar la acción al objeto real (Muestra el contenido)
        libroReal.leer(); //
    }

}
