/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.systemazologico;

/**
 *
 * @author Ruta Binar
 */
// Usamos <T> para no depender de ninguna clase base. Abstract Factory puro.
public class Jaula<T> { 
    private T animal;
    private double alto, ancho, largo;

    public Jaula(T animal, double alto, double ancho, double largo) {
        this.animal = animal; this.alto = alto; this.ancho = ancho; this.largo = largo;
    }
    
    public T getAnimal() { return animal; }
    
    @Override public String toString() {
        return "Jaula [" + alto + "x" + ancho + "x" + largo + "m] contiene a -> " + animal.toString();
    }
}
