/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sis258.abs_factorty_sistema_vehiculos;

/**
 *
 * @author Ruta Binar
 */
public class Main {
    public static void main(String[] args) {
        //Fabrica terrestre
        VehiculoFactory factoryT = new VehiculoTerrestreFactory();
        IVehiculoTerrestre auto = factoryT.crearTerrestre("auto");
        auto.conducir();
    }
    
}
