/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sis258.abs_factorty_sistema_vehiculos;

/**
 *
 * @author Ruta Binar
 */
public interface VehiculoFactory {
    //Debemos tener metodos para crear familias 
    IVehiculoTerrestre crearTerrestre(String tipo);
    IVehiculoAereo crearAereo(String tipo);
}
