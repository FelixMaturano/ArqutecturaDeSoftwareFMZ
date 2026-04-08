/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.sistemanotificaciones;

/**
 *
 * @author Ruta Binar
 */
public class Email implements INotificacion{

    @Override
    public void enviar() {
        System.out.println("Enviando correo ....");
    }
    
}
