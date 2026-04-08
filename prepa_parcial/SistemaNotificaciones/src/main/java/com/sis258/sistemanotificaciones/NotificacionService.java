/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.sistemanotificaciones;

/**
 *
 * @author Ruta Binar
 */
public class NotificacionService {
    private INotificacion notificacion;

    public NotificacionService(INotificacion notificacion) {
        this.notificacion = notificacion;
    }
    
    public void enviar(){
        notificacion.enviar();
        System.out.println("Guardando....");
    }
    
}
