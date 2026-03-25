/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.systemazologico;

/**
 *
 * @author Ruta Binar
 */
public abstract class AveBase implements IAves {
    protected String nombre;
    protected double peso;
    protected double tamanoAlas;

    @Override public void volar() { System.out.println(nombre + " está volando alto."); }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPeso(double peso) { this.peso = peso; }
    public void setTamanoAlas(double tamanoAlas) { this.tamanoAlas = tamanoAlas; }

    @Override public String toString() {
        return "Nombre: " + nombre + " | Peso: " + peso + "kg | Alas: " + tamanoAlas + "m";
    }
}