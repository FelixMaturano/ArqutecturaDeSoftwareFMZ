/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.e1_sistemanotificaciones;

/**
 *
 * @author Lab-F304-
 */
public class PaqueteService {
    private INotificacionService notif;

    public PaqueteService(INotificacionService notif) {
        this.notif = notif;
    }

    public void actualizarEstado(String nuevoEstado) {
        String msj = "El estado de tu paquete es: " + nuevoEstado;
        notif.send("Usuario_Cliente", msj);
    }
}