/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sis258.e2ventassupermercado;

import java.util.Scanner;

/**
 *
 * @author Ruta Binar
 */
public class MainMiniSupermercado {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VentasFacade cajera = new VentasFacade();
        cajera.iniciarVenta("Maria Gomez", "31/03/2026", "CI", "12345");

        int opcion = 0;

        while (opcion != 3) {
            System.out.println("\n*** CAJA MINISUPERMERCADO***");
            System.out.println("1. Escanear Producto (Simple o Combo)");
            System.out.println("2. Cobrar Venta");
            System.out.println("3. Salir");
            System.out.println("Elija una opcion: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("Tipo de producto: [1] Simple [2] Combo");
                int tipoProd = sc.nextInt();

                System.out.println("Descripcion del producto/combo: ");
                sc.nextLine();
                String desc = sc.nextLine();
                System.out.println("Cantidad");
                int cant = sc.nextInt();

                if (tipoProd == 1) {
                    System.out.println("Precio unitario: $");
                    
                    sc.nextLine(); // Limpiar buffer
                    String precioStr = sc.nextLine();
                    double precio = Double.parseDouble(precioStr);

                    ProductoSimple prod = new ProductoSimple(desc, cant, precio);
                    cajera.agregarItem(prod);
                } else if (tipoProd == 2) {
                    ProductoCompuesto combo = new ProductoCompuesto(desc, cant);
                    System.out.println("Cuantos productos diferentes incluye este combo? ");

                    int numItems = sc.nextInt();

                    for (int i = 0; i < numItems; i++) {
                        sc.nextLine();
                        System.out.println("Descripcion del item " + (i + 1) + " dentro del combo: ");

                        String descItem = sc.nextLine();
                        System.out.println("Precio de este item: $");
                        double precioItem = sc.nextDouble();

                        combo.agregarProducto(new ProductoSimple(descItem, 1, precioItem));
                    }
                    cajera.agregarItem(combo);
                } else {
                    System.out.println("Opción no válida");
                }
            } else if (opcion == 2) {
                System.out.println("\nSeleccione Metodo de pago:");
                System.out.println("1. Efectivo");
                System.out.println("2. Tarjeta de credito");
                System.out.println("3. Transferencia Bancaria");
                System.out.println("Opcion: ");
                int tipoPago = sc.nextInt();

                cajera.cobrarVenta(tipoPago);
                cajera.iniciarVenta("Cliente final", "31/03/2026", "NIT", "00000");
            }
        }
        sc.close();
        System.out.println("Caja cerrada. hasta pronto! ");
    }

}
