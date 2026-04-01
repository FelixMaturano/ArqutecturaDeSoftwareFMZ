/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.e2ventassupermercado;

/**
 *
 * @author Ruta Binar
 */
public class VentasFacade {
    
    private Venta ventaActual;
    
    //1. Iniciar la transaccion
    public void iniciarVenta(String nombreCliente, String fecha, String tipoDoc, String numDoc){
        ventaActual = new Venta(nombreCliente, fecha, tipoDoc, numDoc);
        System.out.println("\n[Sistema] Nueva venta iniciada para : " + nombreCliente);
                
    }
    
    public void agregarItem(IDetalleVenta item){
        if(ventaActual != null){
            ventaActual.agregarDetalle(item);
            System.out.println("-> aniadido al carrito: "+ item.getCantidad()+ "x"+ item.getDescripcion());
        }else{
            System.out.println("[Error] Debes iniciar una venta primero");
        }
    }
    
    public void cobrarVenta(int tipoPago){
        if(ventaActual != null){
            ventaActual.mostrarResumen();
            MetodoPago pago = PagoFactory.obteneMetodoPago(tipoPago);
            pago.procesarPago(ventaActual.calcularTotal());
            System.out.println("--- VENTA FINALIZADA CON EXITO----\n");
            ventaActual = null;
        }
    }
}   

