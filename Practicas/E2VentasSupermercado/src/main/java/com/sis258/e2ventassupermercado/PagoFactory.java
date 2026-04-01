/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.e2ventassupermercado;

/**
 *
 * @author Ruta Binar
 */
public class PagoFactory {
    
    public static MetodoPago obteneMetodoPago(int tipo){
        switch (tipo) {
            case 1:return new PagoEfectivo();
            case 2:return new PagoTarjeta();
            case 3:return new PagoTransferencia();
            default:throw new IllegalArgumentException("Opcion de pago no valida");
        }
    }
    
}
