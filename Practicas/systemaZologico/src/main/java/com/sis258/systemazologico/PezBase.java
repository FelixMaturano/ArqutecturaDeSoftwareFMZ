/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.systemazologico;

/**
 *
 * @author Ruta Binar
 */
public abstract class PezBase implements IPeces {
    protected String nombre;
    protected double longitud;

    @Override public void nadar() { System.out.println(nombre + " está nadando rápidamente."); }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setLongitud(double longitud) { this.longitud = longitud; }

    @Override public String toString() {
        return "Nombre: " + nombre + " | Longitud: " + longitud + "cm";
    }
}
