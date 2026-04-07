/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.abstract_factory;

/**
 *
 * @author Ruta Binar
 */
public class MamiferoFactory implements AnimalFactory{

    @Override
    public IMamiferos setMamiferos(String tipo) {
        if (tipo.equalsIgnoreCase("leon")) {
            return new Leon();
        }
        return null;
    }
    
}
