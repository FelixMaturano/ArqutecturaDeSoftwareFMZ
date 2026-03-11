/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.estudiantes;

import java.util.List;
/**
 *
 * @author Felix
 */
public class MateriaVista {

    public void mostrarGuardada(Materia m) {
        System.out.println("\n========================================");
        System.out.println("  MATERIA REGISTRADA EXITOSAMENTE");
        System.out.println("========================================");
        mostrarDetalle(m);
        System.out.println("========================================\n");
    }

    public void mostrarEncontrada(Materia m) {
        if (m != null) {
            System.out.println("\n========================================");
            System.out.println("  MATERIA ENCONTRADA");
            System.out.println("========================================");
            mostrarDetalle(m);
            System.out.println("========================================\n");
        } else {
            System.out.println("  No se encontro ninguna materia.\n");
        }
    }

    public void mostrarActualizada(Materia m, boolean exito) {
        if (exito) {
            System.out.println("\n  Materia actualizada correctamente.\n");
            mostrarDetalle(m);
        } else {
            System.out.println("\n  No se pudo actualizar la materia.\n");
        }
    }

    public void mostrarEliminada(int id, boolean exito) {
        if (exito) {
            System.out.println("\n  Materia con ID " + id + " eliminada correctamente.\n");
        } else {
            System.out.println("\n  No se encontro materia con ID: " + id + "\n");
        }
    }

    public void mostrarListado(List<Materia> lista) {
        System.out.println("\n================================================");
        System.out.println("  LISTADO DE MATERIAS");
        System.out.println("================================================");
        System.out.printf("  %-4s %-12s %-30s%n", "ID", "SIGLA", "NOMBRE");
        System.out.println("------------------------------------------------");
        for (Materia m : lista) {
            System.out.printf("  %-4d %-12s %-30s%n",
                    m.getId(), m.getSigla(), m.getNombre());
        }
        System.out.println("================================================");
        System.out.println("  Total: " + lista.size() + " materia(s)");
        System.out.println("================================================\n");
    }

    public void mostrarError(String mensaje) {
        System.err.println("\n  ERROR: " + mensaje + "\n");
    }

    private void mostrarDetalle(Materia m) {
        System.out.println("  ID:     " + m.getId());
        System.out.println("  Sigla:  " + m.getSigla());
        System.out.println("  Nombre: " + m.getNombre());
    }
}
