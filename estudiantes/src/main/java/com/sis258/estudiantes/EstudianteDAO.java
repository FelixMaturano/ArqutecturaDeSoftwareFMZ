/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sis258.estudiantes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felix
 */
public class EstudianteDAO {

    private final IConexionBD conexion;
    private final MateriaDAO materiaDAO;

    public EstudianteDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.materiaDAO = new MateriaDAO(conexion);
    }

    /**
     * CREATE
     */
    public Estudiante guardar(Estudiante est) throws SQLException {
        String sql = "INSERT INTO estudiantes (ci, nombres, apellidos, celular, sexo) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, est.getCi());
            ps.setString(2, est.getNombres());
            ps.setString(3, est.getApellidos());
            ps.setString(4, est.getCelular());
            ps.setString(5, String.valueOf(est.getSexo()));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                est.setId(rs.getInt(1));
            }
        }
        // Guardar materias asociadas si las tiene
        for (Materia m : est.getMaterias()) {
            inscribirMateria(est.getId(), m.getId());
        }
        return est;
    }

    /**
     * READ por ID (incluye sus materias)
     */
    public Estudiante buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, ci, nombres, apellidos, celular, sexo "
                + "FROM estudiantes WHERE id = ?";
        Estudiante est = null;
        try (Connection conn = conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                est = mapearFila(rs);
            }
        }
        if (est != null) {
            est.setMaterias(materiaDAO.listarPorEstudiante(est.getId()));
        }
        return est;
    }

    /**
     * READ por CI
     */
    public Estudiante buscarPorCi(String ci) throws SQLException {
        String sql = "SELECT id, ci, nombres, apellidos, celular, sexo "
                + "FROM estudiantes WHERE ci = ?";
        Estudiante est = null;
        try (Connection conn = conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, ci);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                est = mapearFila(rs);
            }
        }
        if (est != null) {
            est.setMaterias(materiaDAO.listarPorEstudiante(est.getId()));
        }
        return est;
    }

    /**
     * READ ALL (incluye materias de cada uno)
     */
    public List<Estudiante> listarTodos() throws SQLException {
        String sql = "SELECT id, ci, nombres, apellidos, celular, sexo "
                + "FROM estudiantes ORDER BY apellidos, nombres";
        List<Estudiante> lista = new ArrayList<>();
        try (Connection conn = conexion.obtenerConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Estudiante est = mapearFila(rs);
                est.setMaterias(materiaDAO.listarPorEstudiante(est.getId()));
                lista.add(est);
            }
        }
        return lista;
    }

    /**
     * UPDATE datos personales
     */
    public boolean actualizar(Estudiante est) throws SQLException {
        String sql = "UPDATE estudiantes SET ci=?, nombres=?, apellidos=?, celular=?, sexo=? "
                + "WHERE id=?";
        try (Connection conn = conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, est.getCi());
            ps.setString(2, est.getNombres());
            ps.setString(3, est.getApellidos());
            ps.setString(4, est.getCelular());
            ps.setString(5, String.valueOf(est.getSexo()));
            ps.setInt(6, est.getId());
            return ps.executeUpdate() > 0;
        }
    }

    /**
     * DELETE estudiante (la FK CASCADE elimina sus inscripciones)
     */
    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM estudiantes WHERE id = ?";
        try (Connection conn = conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    // -------------------------------------------------------
    // Operaciones sobre tabla intermedia estudiante_materia
    // -------------------------------------------------------
    /**
     * Inscribir una materia a un estudiante
     */
    public boolean inscribirMateria(int idEstudiante, int idMateria) throws SQLException {
        String sql = "INSERT INTO estudiante_materia (id_estudiante, id_materia) VALUES (?, ?)";
        try (Connection conn = conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idEstudiante);
            ps.setInt(2, idMateria);
            return ps.executeUpdate() > 0;
        }
    }

    /**
     * Desinscribir una materia de un estudiante
     */
    public boolean desinscribirMateria(int idEstudiante, int idMateria) throws SQLException {
        String sql = "DELETE FROM estudiante_materia WHERE id_estudiante=? AND id_materia=?";
        try (Connection conn = conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idEstudiante);
            ps.setInt(2, idMateria);
            return ps.executeUpdate() > 0;
        }
    }

    // -------------------------------------------------------
    // Metodo privado de mapeo
    // -------------------------------------------------------
    private Estudiante mapearFila(ResultSet rs) throws SQLException {
        return new Estudiante(
                rs.getInt("id"),
                rs.getString("ci"),
                rs.getString("nombres"),
                rs.getString("apellidos"),
                rs.getString("celular"),
                rs.getString("sexo").charAt(0)
        );
    }
}
