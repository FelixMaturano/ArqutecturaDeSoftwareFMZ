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
public class ProductoCompuesto implements IDetalleVenta{
    
    private String descripcion;
    private int cantidad;
   
    private List<IDetalleVenta> productosInternos;

    public ProductoCompuesto(String descripcion, int cantidad) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.productosInternos = new ArrayList<>();
    }
    
    public void agregarProducto(IDetalleVenta producto){
        productosInternos.add(producto);
    }
    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public double getPrecio() {
        double totalInterno = 0;
        for(IDetalleVenta p : productosInternos){
            totalInterno += p.getPrecio();
        }
        
        return totalInterno * cantidad;
    }
    
}
