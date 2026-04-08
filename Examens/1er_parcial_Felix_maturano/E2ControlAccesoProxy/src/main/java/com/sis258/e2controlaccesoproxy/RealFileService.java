/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.e2controlaccesoproxy;

/**
 *
 * @author Lab-F304-
 */
public class RealFileService implements IFileService {

    @Override
    public void download(String usuario, String archivo) {
        System.out.println("Descarga iniciada de '" + archivo + "' para el usuario " + usuario + ".......");
    }

}
