/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.systemazologico;

/**
 *
 * @author Ruta Binar
 */
public class PezFactory implements AnimalFactory {

    @Override 
    public IMamiferos setMamiferos(String tipo) { 
        return null; // Esta fábrica no hace mamíferos
    }

    @Override 
    public IAves setAves(String tipo) { 
        return null; // Esta fábrica no hace aves
    }
    
    @Override
    public IPeces setPeces(String tipo) {
        if (tipo.equalsIgnoreCase("pacu")) {
            return new Pacu();
        }
        if (tipo.equalsIgnoreCase("sabalo")) {
            return new Sabalo(); // Asegúrate de tener la clase Sabalo creada extendiendo de PezBase
        }
        return null; // Si no es ninguno de esos peces, devuelve vacío
    }
}
