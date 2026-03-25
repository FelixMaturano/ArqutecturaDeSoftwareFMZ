/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sis258.systemazologico;

/**
 *
 * @author Ruta Binar
 */
public class Main {
    public static void main(String[] args) {
        Zoologico zoo = new Zoologico("Zoo Central", "Av. Fauna 123", "555-9999");
        
        AnimalFactory factoryMamiferos = new MamiferoFactory();
        AnimalFactory factoryAves = new AveFactory();
        AnimalFactory factoryPeces = new PezFactory();

        System.out.println("--- Añadiendo Animales ---");
        
        // Creamos el mamífero y configuramos sus atributos propios
        MamiferoBase m1 = (MamiferoBase) factoryMamiferos.setMamiferos("leon");
        m1.setNombre("Simba"); m1.setTemperatura(38.5); m1.setNumeroPatas(4); m1.setColor("Dorado");
        // Creamos una jaula específicamente para esta familia
        Jaula<IMamiferos> jaulaLeon = new Jaula<>(m1, 5, 5, 5);
        zoo.agregarJaula(jaulaLeon);
        
        // Creamos el ave
        AveBase a1 = (AveBase) factoryAves.setAves("loro");
        a1.setNombre("Paco"); a1.setPeso(1.2); a1.setTamanoAlas(0.5);
        Jaula<IAves> jaulaLoro = new Jaula<>(a1, 2, 2, 2);
        zoo.agregarJaula(jaulaLoro);

        System.out.println("\n--- Probando Comportamientos Exclusivos ---");
        System.out.println("Dato vital -> Temperatura de Simba: " + m1.getTemperatura() + "°C");
        a1.volar(); // Solo las aves vuelan

        System.out.println("\n--- Mostrar Solo Mamíferos ---");
        zoo.mostrarAnimalesPorTipo(IMamiferos.class); // Filtramos por interfaz
        
        System.out.println("\n--- Mostrar Solo Aves ---");
        zoo.mostrarAnimalesPorTipo(IAves.class); // Filtramos por interfaz
    }
}