/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.e2ventassupermercado;

/**
 *
 * @author Ruta Binar
 */
public class PagoEfectivo implements MetodoPago{

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago de $" + monto + " en EFECTIVO. ¡Cambio entregado!");
    }
    
}
