/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sis258.e2controlaccesoproxy;

/**
 *
 * @author Lab-F304-
 */
public class E2ControlAccesoProxy {

    public static void main(String[] args) {
        
        IFileService proxy = new FileServiceProxy();

        // Prueba 1: Usuario autorizado
        System.out.println(" prueba para el usuario autori");
        proxy.download("estudiante1", "patrones_disenio.pdf");

        // Prueba 2: Usuario no autorizado
        System.out.println(" Prueba uauario no autorizado ");
        proxy.download("invitado42", "archivo");
    }
}