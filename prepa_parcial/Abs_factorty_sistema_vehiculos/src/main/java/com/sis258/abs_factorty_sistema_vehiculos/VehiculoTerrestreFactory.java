/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.abs_factorty_sistema_vehiculos;

/**
 *
 * @author Ruta Binar
 */
public class VehiculoTerrestreFactory implements VehiculoFactory{

    @Override
    public IVehiculoTerrestre crearTerrestre(String tipo) {
     if(tipo.equalsIgnoreCase("auto")){
         return new Auto();
     }
        if(tipo.equalsIgnoreCase("moto")){
         return new Auto();
     }
     return null;
    }

    @Override
    public IVehiculoAereo crearAereo(String tipo) {
        return null;
    }
    
}
