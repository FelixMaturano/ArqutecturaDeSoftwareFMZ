package com.sis258.estudiantes;

import java.util.List;

/**
 * RESPONSABILIDAD UNICA: Presentacion / formateo de datos de Estudiante.
 *
 * Solo muestra informacion en consola.
 * No accede a BD ni conoce logica de negocio.
 *
 * Solo cambia si cambia el formato de presentacion.
 */
public class EstudianteVista {

    public void mostrarGuardado(Estudiante est) {
        System.out.println("\n========================================");
        System.out.println("  ESTUDIANTE REGISTRADO EXITOSAMENTE");
        System.out.println("========================================");
        mostrarDetalle(est);
        System.out.println("========================================\n");
    }

    public void mostrarEncontrado(Estudiante est) {
        if (est != null) {
            System.out.println("\n========================================");
            System.out.println("  ESTUDIANTE ENCONTRADO");
            System.out.println("========================================");
            mostrarDetalle(est);
            System.out.println("========================================\n");
        } else {
            System.out.println("  No se encontro ningun estudiante.\n");
        }
    }

    public void mostrarActualizado(Estudiante est, boolean exito) {
        if (exito) {
            System.out.println("\n========================================");
            System.out.println("  ESTUDIANTE ACTUALIZADO EXITOSAMENTE");
            System.out.println("========================================");
            mostrarDetalle(est);
            System.out.println("========================================\n");
        } else {
            System.out.println("  No se pudo actualizar. ID no encontrado: " + est.getId() + "\n");
        }
    }

    public void mostrarEliminado(int id, boolean exito) {
        if (exito) {
            System.out.println("\n  Estudiante con ID " + id + " eliminado correctamente.\n");
        } else {
            System.out.println("\n  No se encontro estudiante con ID: " + id + "\n");
        }
    }

    public void mostrarListado(List<Estudiante> lista) {
        System.out.println("\n================================================================");
        System.out.println("  LISTADO DE ESTUDIANTES");
        System.out.println("================================================================");
        System.out.printf("  %-4s %-12s %-18s %-18s %-5s%n",
                          "ID", "CI", "NOMBRES", "APELLIDOS", "SEXO");
        System.out.println("----------------------------------------------------------------");
        for (Estudiante e : lista) {
            System.out.printf("  %-4d %-12s %-18s %-18s %-5s%n",
                e.getId(), e.getCi(), e.getNombres(), e.getApellidos(),
                String.valueOf(e.getSexo()));
        }
        System.out.println("================================================================");
        System.out.println("  Total: " + lista.size() + " estudiante(s)");
        System.out.println("================================================================\n");
    }

    public void mostrarInscripcion(Estudiante est, Materia mat, boolean exito) {
        if (exito) {
            System.out.println("\n  Materia [" + mat.getSigla() + "] "
                + mat.getNombre() + " inscrita al estudiante "
                + est.getNombres() + " " + est.getApellidos() + "\n");
        } else {
            System.out.println("\n  No se pudo inscribir la materia.\n");
        }
    }

    public void mostrarDesinscripcion(int idEst, int idMat, boolean exito) {
        if (exito) {
            System.out.println("\n  Materia desinscrita correctamente.\n");
        } else {
            System.out.println("\n  No se pudo desinscribir la materia (verifique IDs).\n");
        }
    }

    public void mostrarError(String mensaje) {
        System.err.println("\n  ERROR: " + mensaje + "\n");
    }

    // -------------------------------------------------------
    // Detalle privado
    // -------------------------------------------------------
    private void mostrarDetalle(Estudiante est) {
        System.out.println("  ID:        " + est.getId());
        System.out.println("  CI:        " + est.getCi());
        System.out.println("  Nombres:   " + est.getNombres());
        System.out.println("  Apellidos: " + est.getApellidos());
        System.out.println("  Celular:   " + est.getCelular());
        System.out.println("  Sexo:      " + est.getSexo());

        List<Materia> materias = est.getMaterias();
        if (materias != null && !materias.isEmpty()) {
            System.out.println("  Materias:");
            for (Materia m : materias) {
                System.out.println("    - [" + m.getSigla() + "] " + m.getNombre());
            }
        } else {
            System.out.println("  Materias:  (ninguna inscrita)");
        }
    }
}