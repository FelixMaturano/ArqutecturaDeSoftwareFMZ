/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.e1_sistemanotificaciones;

/**
 *
 * @author Lab-F304-
 */
public class E1_sistemaNotificaciones {

    public static void main(String[] args) {
               // Registro de la nueva implementación (Push)
        INotificacionService miNotificador = new PushNotificacion();
        
        // Inyección por constructor
        PaqueteService paquete = new PaqueteService(miNotificador);
        
        paquete.actualizarEstado("DESPACHADO");
    }
}
