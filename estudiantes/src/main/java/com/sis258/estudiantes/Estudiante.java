/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.estudiantes;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Felix
 */
public class Estudiante {
      private int          id;
    private String       ci;
    private String       nombres;
    private String       apellidos;
    private String       celular;
    private char         sexo;          // 'M' o 'F'
    private List<Materia> materias;

    public Estudiante() {
        this.materias = new ArrayList<>();
    }

    public Estudiante(String ci, String nombres, String apellidos,
                      String celular, char sexo) {
        this.ci        = ci;
        this.nombres   = nombres;
        this.apellidos = apellidos;
        this.celular   = celular;
        this.sexo      = sexo;
        this.materias  = new ArrayList<>();
    }

    public Estudiante(int id, String ci, String nombres, String apellidos,
                      String celular, char sexo) {
        this.id        = id;
        this.ci        = ci;
        this.nombres   = nombres;
        this.apellidos = apellidos;
        this.celular   = celular;
        this.sexo      = sexo;
        this.materias  = new ArrayList<>();
    }

    // Getters y Setters
    public int getId()              { return id; }
    public void setId(int id)       { this.id = id; }

    public String getCi()               { return ci; }
    public void setCi(String ci)        { this.ci = ci; }

    public String getNombres()                  { return nombres; }
    public void setNombres(String nombres)      { this.nombres = nombres; }

    public String getApellidos()                { return apellidos; }
    public void setApellidos(String apellidos)  { this.apellidos = apellidos; }

    public String getCelular()                  { return celular; }
    public void setCelular(String celular)      { this.celular = celular; }

    public char getSexo()               { return sexo; }
    public void setSexo(char sexo)      { this.sexo = sexo; }

    public List<Materia> getMaterias()              { return materias; }
    public void setMaterias(List<Materia> materias) { this.materias = materias; }

    public void agregarMateria(Materia m) {
        if (!materias.contains(m)) {
            materias.add(m);
        }
    }

    @Override
    public String toString() {
        return "Estudiante{id=" + id + ", ci='" + ci + "', nombres='" + nombres
             + "', apellidos='" + apellidos + "', sexo=" + sexo + "}";
    }
}

