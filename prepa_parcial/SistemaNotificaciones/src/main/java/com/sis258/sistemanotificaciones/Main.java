/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sis258.sistemanotificaciones;

/**
 *
 * @author Ruta Binar
 */
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        INotificacion noti = new Email();
        NotificacionService service = new NotificacionService(noti);
        service.enviar();
    }
    
}
