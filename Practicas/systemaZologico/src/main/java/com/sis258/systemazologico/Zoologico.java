/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.systemazologico;

/**
 *
 * @author Ruta Binar
 */
import java.util.ArrayList;

public class Zoologico {
    private String nombre, direccion, telefono;
    // La lista usa <?> (comodín) para aceptar jaulas de mamíferos, aves o peces mezcladas
    private ArrayList<Jaula<?>> listaJaulas; 

    public Zoologico(String nombre, String direccion, String telefono) {
        this.nombre = nombre; this.direccion = direccion; this.telefono = telefono;
        this.listaJaulas = new ArrayList<>();
    }

    public void agregarJaula(Jaula<?> jaula) { listaJaulas.add(jaula); }

    public void mostrarAnimalesPorTipo(Class<?> tipoClase) {
        boolean hay = false;
        for (Jaula<?> j : listaJaulas) {
            // Evaluamos a qué familia pertenece realmente el objeto dentro de la jaula
            if (tipoClase.isInstance(j.getAnimal())) {
                System.out.println(j.toString());
                hay = true;
            }
        }
        if (!hay) System.out.println("No hay animales de esta familia aún.");
    }

    @Override public String toString() {
        return "Zoo: " + nombre + " | Dir: " + direccion + " | Jaulas: " + listaJaulas.size();
    }
}