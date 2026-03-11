/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.estudiantes;

/**
 *
 * @author Felix
 */
public class Materia {

    private int    id;
    private String nombre;
    private String sigla;

    public Materia() {}

    public Materia(String nombre, String sigla) {
        this.nombre = nombre;
        this.sigla  = sigla;
    }

    public Materia(int id, String nombre, String sigla) {
        this.id     = id;
        this.nombre = nombre;
        this.sigla  = sigla;
    }

    // Getters y Setters
    public int getId()             { return id; }
    public void setId(int id)      { this.id = id; }

    public String getNombre()              { return nombre; }
    public void setNombre(String nombre)   { this.nombre = nombre; }

    public String getSigla()               { return sigla; }
    public void setSigla(String sigla)     { this.sigla = sigla; }

    @Override
    public String toString() {
        return "Materia{id=" + id + ", sigla='" + sigla + "', nombre='" + nombre + "'}";
    }
}