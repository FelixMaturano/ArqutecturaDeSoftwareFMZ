/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.systemazologico;

/**
 *
 * @author Ruta Binar
 */
public abstract class MamiferoBase implements IMamiferos {
    protected String nombre;
    protected double temperatura;
    protected int numeroPatas;
    protected String color;

    @Override public double getTemperatura() { return temperatura; }
    
    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }
    public void setNumeroPatas(int numeroPatas) { this.numeroPatas = numeroPatas; }
    public void setColor(String color) { this.color = color; }

    @Override public String toString() {
        return "Nombre: " + nombre + " | Temp: " + temperatura + "°C | Patas: " + numeroPatas + " | Color: " + color;
    }
}