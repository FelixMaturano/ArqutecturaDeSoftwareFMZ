/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.systemazologico;

/**
 *
 * @author Ruta Binar
 */
public class MamiferoFactory implements AnimalFactory {
    @Override public IMamiferos setMamiferos(String tipo) {
        if (tipo.equalsIgnoreCase("leon")) return new Leon();
        if (tipo.equalsIgnoreCase("oso")) return new Oso(); 
        if (tipo.equalsIgnoreCase("mono")) return new Mono(); 
        return null;
    }
    @Override public IAves setAves(String tipo) { return null; }
    @Override public IPeces setPeces(String tipo) { return null; }
}