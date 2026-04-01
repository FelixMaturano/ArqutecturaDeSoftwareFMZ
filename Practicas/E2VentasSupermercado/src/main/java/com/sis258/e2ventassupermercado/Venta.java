/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.e2ventassupermercado;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ruta Binar
 */
public class Venta {
    
    private String nombreCliente;
    private String fecha;
    private String tipoDocumento;
    private String numeroDocumento;
    
    private List<IDetalleVenta> detalles;

    public Venta(String nombreCliente, String fecha, String tipoDocumento, String numeroDocumento) {
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.detalles = new ArrayList<>();
    }
    
    public void agregarDetalle(IDetalleVenta detalle){
        detalles.add(detalle);
    }
    
    public double calcularTotal(){
        double total =0;
        
        for(IDetalleVenta d : detalles){
            total += d.getPrecio();
        }
        return total;
    }
    
    public void mostrarResumen(){
        System.out.println("\n--- TICKET DE VENTA ---");
        System.out.println("Cliente: " + nombreCliente + " | Fecha: " + fecha);
        System.out.println(tipoDocumento + ": " + numeroDocumento);
        System.out.println("-----------------------");
        
        for(IDetalleVenta d : detalles){
            System.out.println("- " + d.getCantidad() + "x " + d.getDescripcion() + " = $" + d.getPrecio());
        }
        
        System.out.println("-----------------------");
        System.out.println("TOTAL A COBRAR: $" + calcularTotal());
    }
    
}
