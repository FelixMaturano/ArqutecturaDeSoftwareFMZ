/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sis258.abstract_factory;

/**
 *
 * @author Ruta Binar
 */
public class Main {
    public static void main(String[] args) {
        
        AnimalFactory factory = new MamiferoFactory();

        IMamiferos animal = factory.setMamiferos("leon");

        // Cast porque queremos usar métodos de la clase base
        MamiferoBase leon = (MamiferoBase) animal;

        leon.setNombre("Simba");
        leon.setTemperatura(38.5);

        System.out.println(leon);
    }
    
}
