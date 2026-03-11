package com.sis258.estudiantes;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * RESPONSABILIDAD UNICA: Gestionar el menu de consola y coordinar
 * las acciones del usuario con los DAOs y Vistas.
 */
public class Estudiantes {

    private static Scanner         sc          = new Scanner(System.in);
    private static EstudianteDAO   estudianteDAO;
    private static MateriaDAO      materiaDAO;
    private static EstudianteVista estVista    = new EstudianteVista();
    private static MateriaVista    matVista    = new MateriaVista();

    // ============================================================
    // PUNTO DE ENTRADA
    // ============================================================
    public static void main(String[] args) {

        System.out.println("=====================================================");
        System.out.println("   SISTEMA DE GESTION DE ESTUDIANTES");
        System.out.println("   Aplicando principios SOLID");
        System.out.println("=====================================================");

        IConexionBD conexion = elegirBaseDeDatos();
        estudianteDAO = new EstudianteDAO(conexion);
        materiaDAO    = new MateriaDAO(conexion);

        menuPrincipal();

        System.out.println("\n  Hasta luego!");
        sc.close();
    }

    // ============================================================
    // SELECCION DE BASE DE DATOS
    // ============================================================
    private static IConexionBD elegirBaseDeDatos() {
        System.out.println("\n  Seleccione el motor de base de datos:");
        System.out.println("  1. MySQL");
        System.out.println("  2. PostgreSQL");
        System.out.print("  Opcion: ");

        int opcion = leerEntero();
        switch (opcion) {
            case 1:
                System.out.println("  Usando MySQL...\n");
                return new ConexionMySQL();
            case 2:
                System.out.println("  Usando PostgreSQL...\n");
                return new ConexionPostgreSQL();
            default:
                System.out.println("  Opcion invalida. Usando MySQL por defecto.\n");
                return new ConexionMySQL();
        }
    }

    // ============================================================
    // MENU PRINCIPAL
    // ============================================================
    private static void menuPrincipal() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n=====================================================");
            System.out.println("   MENU PRINCIPAL");
            System.out.println("=====================================================");
            System.out.println("  1. Gestion de Estudiantes");
            System.out.println("  2. Gestion de Materias");
            System.out.println("  3. Inscribir / Desinscribir materias");
            System.out.println("  0. Salir");
            System.out.print("  Opcion: ");

            switch (leerEntero()) {
                case 1: menuEstudiantes(); break;
                case 2: menuMaterias();    break;
                case 3: menuInscripcion(); break;
                case 0: salir = true;      break;
                default: System.out.println("  Opcion no valida.");
            }
        }
    }

    // ============================================================
    // MENU ESTUDIANTES
    // ============================================================
    private static void menuEstudiantes() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- ESTUDIANTES ---");
            System.out.println("  1. Registrar estudiante");
            System.out.println("  2. Buscar por ID");
            System.out.println("  3. Buscar por CI");
            System.out.println("  4. Listar todos");
            System.out.println("  5. Actualizar");
            System.out.println("  6. Eliminar");
            System.out.println("  0. Volver");
            System.out.print("  Opcion: ");

            try {
                switch (leerEntero()) {
                    case 1: registrarEstudiante();   break;
                    case 2: buscarEstudiantePorId(); break;
                    case 3: buscarEstudiantePorCi(); break;
                    case 4: listarEstudiantes();     break;
                    case 5: actualizarEstudiante();  break;
                    case 6: eliminarEstudiante();    break;
                    case 0: volver = true;           break;
                    default: System.out.println("  Opcion no valida.");
                }
            } catch (SQLException e) {
                estVista.mostrarError(e.getMessage());
            }
        }
    }

    private static void registrarEstudiante() throws SQLException {
        System.out.println("\n  -- Registrar nuevo estudiante --");
        System.out.print("  CI:        "); String ci        = sc.nextLine().trim();
        System.out.print("  Nombres:   "); String nombres   = sc.nextLine().trim();
        System.out.print("  Apellidos: "); String apellidos = sc.nextLine().trim();
        System.out.print("  Celular:   "); String celular   = sc.nextLine().trim();
        char sexo = leerSexo();

        Estudiante est = new Estudiante(ci, nombres, apellidos, celular, sexo);
        est = estudianteDAO.guardar(est);
        estVista.mostrarGuardado(est);
    }

    private static void buscarEstudiantePorId() throws SQLException {
        System.out.print("\n  Ingrese el ID del estudiante: ");
        int id = leerEntero();
        Estudiante est = estudianteDAO.buscarPorId(id);
        estVista.mostrarEncontrado(est);
    }

    private static void buscarEstudiantePorCi() throws SQLException {
        System.out.print("\n  Ingrese el CI del estudiante: ");
        String ci = sc.nextLine().trim();
        Estudiante est = estudianteDAO.buscarPorCi(ci);
        estVista.mostrarEncontrado(est);
    }

    private static void listarEstudiantes() throws SQLException {
        List<Estudiante> lista = estudianteDAO.listarTodos();
        estVista.mostrarListado(lista);
    }

    private static void actualizarEstudiante() throws SQLException {
        System.out.print("\n  ID del estudiante a actualizar: ");
        int id = leerEntero();
        Estudiante est = estudianteDAO.buscarPorId(id);
        if (est == null) {
            System.out.println("  Estudiante no encontrado.");
            return;
        }
        System.out.println("  (Enter para mantener valor actual)");
        System.out.print("  CI [" + est.getCi() + "]: ");
        String ci = sc.nextLine().trim();
        if (!ci.isEmpty()) est.setCi(ci);

        System.out.print("  Nombres [" + est.getNombres() + "]: ");
        String nombres = sc.nextLine().trim();
        if (!nombres.isEmpty()) est.setNombres(nombres);

        System.out.print("  Apellidos [" + est.getApellidos() + "]: ");
        String apellidos = sc.nextLine().trim();
        if (!apellidos.isEmpty()) est.setApellidos(apellidos);

        System.out.print("  Celular [" + est.getCelular() + "]: ");
        String celular = sc.nextLine().trim();
        if (!celular.isEmpty()) est.setCelular(celular);

        System.out.print("  Sexo (M/F) [" + est.getSexo() + "]: ");
        String sexoStr = sc.nextLine().trim().toUpperCase();
        if (!sexoStr.isEmpty() && (sexoStr.equals("M") || sexoStr.equals("F"))) {
            est.setSexo(sexoStr.charAt(0));
        }

        boolean ok = estudianteDAO.actualizar(est);
        estVista.mostrarActualizado(est, ok);
    }

    private static void eliminarEstudiante() throws SQLException {
        System.out.print("\n  ID del estudiante a eliminar: ");
        int id = leerEntero();
        boolean ok = estudianteDAO.eliminar(id);
        estVista.mostrarEliminado(id, ok);
    }

    // ============================================================
    // MENU MATERIAS
    // ============================================================
    private static void menuMaterias() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- MATERIAS ---");
            System.out.println("  1. Registrar materia");
            System.out.println("  2. Buscar por ID");
            System.out.println("  3. Listar todas");
            System.out.println("  4. Actualizar");
            System.out.println("  5. Eliminar");
            System.out.println("  0. Volver");
            System.out.print("  Opcion: ");

            try {
                switch (leerEntero()) {
                    case 1: registrarMateria();   break;
                    case 2: buscarMateriaPorId(); break;
                    case 3: listarMaterias();     break;
                    case 4: actualizarMateria();  break;
                    case 5: eliminarMateria();    break;
                    case 0: volver = true;        break;
                    default: System.out.println("  Opcion no valida.");
                }
            } catch (SQLException e) {
                matVista.mostrarError(e.getMessage());
            }
        }
    }

    private static void registrarMateria() throws SQLException {
        System.out.println("\n  -- Registrar nueva materia --");
        System.out.print("  Nombre: "); String nombre = sc.nextLine().trim();
        System.out.print("  Sigla:  "); String sigla  = sc.nextLine().trim();

        Materia m = materiaDAO.guardar(new Materia(nombre, sigla));
        matVista.mostrarGuardada(m);
    }

    private static void buscarMateriaPorId() throws SQLException {
        System.out.print("\n  ID de la materia: ");
        int id = leerEntero();
        Materia m = materiaDAO.buscarPorId(id);
        matVista.mostrarEncontrada(m);
    }

    private static void listarMaterias() throws SQLException {
        List<Materia> lista = materiaDAO.listarTodas();
        matVista.mostrarListado(lista);
    }

    private static void actualizarMateria() throws SQLException {
        System.out.print("\n  ID de la materia a actualizar: ");
        int id = leerEntero();
        Materia m = materiaDAO.buscarPorId(id);
        if (m == null) { System.out.println("  Materia no encontrada."); return; }

        System.out.print("  Nuevo nombre [" + m.getNombre() + "]: ");
        String nombre = sc.nextLine().trim();
        if (!nombre.isEmpty()) m.setNombre(nombre);

        System.out.print("  Nueva sigla  [" + m.getSigla() + "]: ");
        String sigla = sc.nextLine().trim();
        if (!sigla.isEmpty()) m.setSigla(sigla);

        boolean ok = materiaDAO.actualizar(m);
        matVista.mostrarActualizada(m, ok);
    }

    private static void eliminarMateria() throws SQLException {
        System.out.print("\n  ID de la materia a eliminar: ");
        int id = leerEntero();
        boolean ok = materiaDAO.eliminar(id);
        matVista.mostrarEliminada(id, ok);
    }

    // ============================================================
    // MENU INSCRIPCION
    // ============================================================
    private static void menuInscripcion() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- INSCRIPCION DE MATERIAS ---");
            System.out.println("  1. Inscribir materia a estudiante");
            System.out.println("  2. Desinscribir materia de estudiante");
            System.out.println("  3. Ver materias de un estudiante");
            System.out.println("  0. Volver");
            System.out.print("  Opcion: ");

            try {
                switch (leerEntero()) {
                    case 1: inscribirMateria();      break;
                    case 2: desinscribirMateria();   break;
                    case 3: verMateriasEstudiante(); break;
                    case 0: volver = true;           break;
                    default: System.out.println("  Opcion no valida.");
                }
            } catch (SQLException e) {
                estVista.mostrarError(e.getMessage());
            }
        }
    }

    private static void inscribirMateria() throws SQLException {
        System.out.print("\n  ID del estudiante: ");
        int idEst = leerEntero();
        System.out.print("  ID de la materia:  ");
        int idMat = leerEntero();

        Estudiante est = estudianteDAO.buscarPorId(idEst);
        Materia    mat = materiaDAO.buscarPorId(idMat);

        if (est == null) { System.out.println("  Estudiante no encontrado."); return; }
        if (mat == null) { System.out.println("  Materia no encontrada.");    return; }

        boolean ok = estudianteDAO.inscribirMateria(idEst, idMat);
        estVista.mostrarInscripcion(est, mat, ok);
    }

    private static void desinscribirMateria() throws SQLException {
        System.out.print("\n  ID del estudiante: ");
        int idEst = leerEntero();
        System.out.print("  ID de la materia:  ");
        int idMat = leerEntero();

        boolean ok = estudianteDAO.desinscribirMateria(idEst, idMat);
        estVista.mostrarDesinscripcion(idEst, idMat, ok);
    }

    private static void verMateriasEstudiante() throws SQLException {
        System.out.print("\n  ID del estudiante: ");
        int id = leerEntero();
        Estudiante est = estudianteDAO.buscarPorId(id);
        estVista.mostrarEncontrado(est);
    }

    // ============================================================
    // Utilidades de lectura
    // ============================================================

    /**
     * Lee un entero de consola y consume el salto de linea.
     * Esto evita que el siguiente sc.nextLine() capture una linea vacia.
     */
    private static int leerEntero() {
        int valor = -1;
        try {
            String linea = sc.nextLine().trim();   // consume toda la linea incluyendo Enter
            valor = Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            // devuelve -1 si no es numero
        }
        return valor;
    }

    private static char leerSexo() {
        while (true) {
            System.out.print("  Sexo (M/F): ");
            String s = sc.nextLine().trim().toUpperCase();
            if (s.equals("M") || s.equals("F")) return s.charAt(0);
            System.out.println("  Ingrese solo M o F.");
        }
    }
}