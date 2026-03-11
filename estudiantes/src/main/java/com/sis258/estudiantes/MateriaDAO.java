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
public class MateriaDAO {

    private final IConexionBD conexion;

    // DIP: depende de la abstraccion ConexionBD, no de una implementacion concreta
    public MateriaDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * CREATE
     */
    public Materia guardar(Materia materia) throws SQLException {
        String sql = "INSERT INTO materias (nombre, sigla) VALUES (?, ?)";
        try (Connection conn = conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, materia.getNombre());
            ps.setString(2, materia.getSigla());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setId(rs.getInt(1));
            }
        }
        return materia;
    }

    /**
     * READ por ID
     */
    public Materia buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, nombre, sigla FROM materias WHERE id = ?";
        try (Connection conn = conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Materia(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("sigla"));
            }
        }
        return null;
    }

    /**
     * READ por sigla
     */
    public Materia buscarPorSigla(String sigla) throws SQLException {
        String sql = "SELECT id, nombre, sigla FROM materias WHERE sigla = ?";
        try (Connection conn = conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Materia(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("sigla"));
            }
        }
        return null;
    }

    /**
     * READ ALL
     */
    public List<Materia> listarTodas() throws SQLException {
        String sql = "SELECT id, nombre, sigla FROM materias ORDER BY sigla";
        List<Materia> lista = new ArrayList<>();
        try (Connection conn = conexion.obtenerConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Materia(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("sigla")));
            }
        }
        return lista;
    }

    /**
     * READ materias de un estudiante (tabla intermedia)
     */
    public List<Materia> listarPorEstudiante(int idEstudiante) throws SQLException {
        String sql = "SELECT m.id, m.nombre, m.sigla "
                + "FROM materias m "
                + "JOIN estudiante_materia em ON m.id = em.id_materia "
                + "WHERE em.id_estudiante = ? "
                + "ORDER BY m.sigla";
        List<Materia> lista = new ArrayList<>();
        try (Connection conn = conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idEstudiante);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Materia(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("sigla")));
            }
        }
        return lista;
    }

    /**
     * UPDATE
     */
    public boolean actualizar(Materia materia) throws SQLException {
        String sql = "UPDATE materias SET nombre = ?, sigla = ? WHERE id = ?";
        try (Connection conn = conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, materia.getNombre());
            ps.setString(2, materia.getSigla());
            ps.setInt(3, materia.getId());
            return ps.executeUpdate() > 0;
        }
    }

    /**
     * DELETE
     */
    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM materias WHERE id = ?";
        try (Connection conn = conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
