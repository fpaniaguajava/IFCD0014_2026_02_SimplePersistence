package com.cursogetafe.persistence.impl;

import com.cursogetafe.model.Serie;
import com.cursogetafe.persistence.interfaces.ISerieDAO;

import java.sql.*;
import java.util.List;

public class SerieDAOSQLiteImpl implements ISerieDAO {
    private static final String URL = "jdbc:sqlite:series.db";

    public SerieDAOSQLiteImpl() {
        createDB();
    }

    private void createDB() {
        String sql = """
                CREATE TABLE IF NOT EXISTS serie (
                    titulo TEXT PRIMARY KEY,
                    genero TEXT NOT NULL,
                    numeroTemporadas INTEGER NOT NULL
                );
                """;
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    @Override
    public Serie create(Serie serie) {
        String sql = "INSERT INTO serie (titulo, genero, numeroTemporadas) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, serie.getTitulo());
            stmt.setString(2, serie.getGenero());
            stmt.setInt(3, serie.getNumeroTemporadas());

            stmt.executeUpdate();
            return serie;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Serie read(String titulo) {
        String sql = "SELECT * FROM serie WHERE titulo = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Serie(
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        rs.getInt("numeroTemporadas")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Serie update(Serie serie) {
        return null;
    }

    @Override
    public void delete(String titulo) {

    }

    @Override
    public List<Serie> readAll() {
        return List.of();
    }
}
