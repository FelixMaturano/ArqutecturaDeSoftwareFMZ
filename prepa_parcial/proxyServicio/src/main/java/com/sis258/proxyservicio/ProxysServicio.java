/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.proxyservicio;

/**
 *
 * @author Ruta Binar
 */
public class ProxysServicio implements IServicio{

    private ServicioReal servicioReal;
    private boolean tienePermiso;

    public ProxysServicio(boolean tienePermiso) {
        this.tienePermiso = tienePermiso;
    }
    
    
    @Override
    public void mostrar() {
        if(tienePermiso){
            if(servicioReal == null){
                servicioReal = new ServicioReal();
            }
            servicioReal.mostrar();
        }else{
            System.out.println("Acceso denegado");
        }
    }
    
}
