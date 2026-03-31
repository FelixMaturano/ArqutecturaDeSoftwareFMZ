/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.ejercicio1proxylibroselectronicos;

/**
 *
 * @author Ruta Binar
 */
public class LibroReal implements Libro {

    private String titulo;
    private String autor;
    private int anio;
    private String contenido;

    public LibroReal(String titulo, String autor, int anio, String contenido) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.contenido = contenido;
    }
    
    
    @Override
    public void leer() {
        System.out.println("--- " + titulo + " ---");
        System.out.println("Autor: " + autor + " | Anio: " + anio);
        System.out.println("Contenido: " + contenido);
    }
    
}
