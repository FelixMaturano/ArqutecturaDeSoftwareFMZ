/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.e2controlaccesoproxy;

import java.time.LocalDateTime;


/**
 *
 * @author Lab-F304-
 */
public class FileServiceProxy implements IFileService {

    private RealFileService realService;
    // Lista para los usuarios 
    private String[] sesionesActivas = {"admin", "estudiante1", "profesor"};

    @Override
    public void download(String usuario, String archivo) {

        System.out.println(LocalDateTime.now() + "Intento de acceso al archivo: " + archivo + " por el usuario: " + usuario);
      
        boolean accesoPermitido = false;

        for (String sesion : sesionesActivas) {
            if (sesion.equals(usuario)) {
                accesoPermitido = true;
                break; 
            }
        }

        // 3. Lógica de control
        if (accesoPermitido) {
            if (realService == null) {
                realService = new RealFileService();
            }
            realService.download(usuario, archivo);
        } else {
            System.out.println("Acceso denegado para el usuario: " + usuario);
        }
    }

}
