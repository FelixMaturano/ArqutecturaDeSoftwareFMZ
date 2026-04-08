/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.e1_sistemanotificaciones;

/**
 *
 * @author Lab-F304-
 */
public class EmailNotificacion implements INotificacionService{

    @Override
    public void send(String destinatario, String mensaje) {
   System.out.println("Enviando EMAIL a " + destinatario + ": " + mensaje);
    }
    
}
