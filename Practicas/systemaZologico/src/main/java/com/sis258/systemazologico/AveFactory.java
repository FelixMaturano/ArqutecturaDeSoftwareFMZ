/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.systemazologico;

/**
 *
 * @author Ruta Binar
 */
public class AveFactory implements AnimalFactory {

    @Override 
    public IMamiferos setMamiferos(String tipo) { 
        return null; // Esta fábrica no hace mamíferos
    }
    
    @Override
    public IAves setAves(String tipo) {
        if (tipo.equalsIgnoreCase("loro")) {
            return new Loro();
        }
        if (tipo.equalsIgnoreCase("aguila")) {
            return new Aguila(); // Asegúrate de tener la clase Aguila creada extendiendo de AveBase
        }
        if (tipo.equalsIgnoreCase("condor")) {
            return new Condor(); // Asegúrate de tener la clase Condor creada extendiendo de AveBase
        }
        return null; // Si no es ninguna de esas aves, devuelve vacío
    }

    @Override 
    public IPeces setPeces(String tipo) { 
        return null; // Esta fábrica no hace peces
    }
}
