/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.abstract_factory;

/**
 *
 * @author Ruta Binar
 */
public abstract class MamiferoBase implements IMamiferos {

    protected String nombre;
    protected double temperatura;

    @Override
    public double getTemperatura() {
        return temperatura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "| Temp: " + temperatura;
    }
}
