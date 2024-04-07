package model;

import database.ConfigDb;
import database.PasajeroRepository;
import entities.Pasajero;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasajeroModel implements PasajeroRepository {
    @Override
    public Pasajero insert(Pasajero pasajero) {

        try {
            Connection conexion = obtenerConexion();
            String sql = "INSERT INTO pasajero (nombre, apellido, documento_identidad) VALUES (?, ?, ?);";

            PreparedStatement sentencia = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            sentencia.setString(1, pasajero.getNombre());
            sentencia.setString(2, pasajero.getApellido());
            sentencia.setString(3, pasajero.getDocumentoIdentidad());

            sentencia.execute();

            try (ResultSet generatedKeys = sentencia.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idGenerado = generatedKeys.getInt(1);
                    pasajero.setIdPasajero(idGenerado);
                } else {
                    throw new SQLException("No se pudo obtener el id para el pasajero");
                }
            }

            JOptionPane.showMessageDialog(null, "El pasajero se insertó correctamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error añadiendo pasajero" + e.getMessage());
        }

        cerrarConexion();

        return pasajero;
    }

    @Override
    public boolean update(Pasajero pasajero) {
        boolean actualizado = false;
        
        try {
            Connection conexion = obtenerConexion();
            String sql = "UPDATE pasajero SET nombre = ?, apellido = ?, documento_identidad = ? WHERE id_pasajero = ?; ";

            PreparedStatement sentencia = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            sentencia.setString(1, pasajero.getNombre());
            sentencia.setString(2, pasajero.getApellido());
            sentencia.setString(3, pasajero.getDocumentoIdentidad());
            sentencia.setInt(4, pasajero.getIdPasajero());
            
            int columnasAfectadas = sentencia.executeUpdate();
            
            if (columnasAfectadas > 0) {
                actualizado = true;
                JOptionPane.showMessageDialog(null, "Actualización exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Actualización no exitosa");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error actualizando pasajero" + e.getMessage());
        }

        cerrarConexion();

        return actualizado;
    }

    @Override
    public boolean delete(Pasajero pasajero) {
        boolean eliminado = false;

        try {
            Connection conexion = obtenerConexion();
            String sql = "DELETE FROM pasajero WHERE id_pasajero = ?; ";

            PreparedStatement sentencia = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            sentencia.setInt(1, pasajero.getIdPasajero());

            int columnasAfectadas = sentencia.executeUpdate();

            if (columnasAfectadas > 0) {
                eliminado = true;
                JOptionPane.showMessageDialog(null, "Eliminación exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Eliminación no exitosa");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error eliminando pasajero" + e.getMessage());
        }

        cerrarConexion();

        return eliminado;
    }

    @Override
    public Pasajero findById(int idPasajero) {
        Pasajero pasajero = new Pasajero();

        try {
            Connection conexion = obtenerConexion();

            String sql = "SELECT * FROM pasajero WHERE id_pasajero = ?;";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, idPasajero);

            ResultSet pasajeroEncontrado = sentencia.executeQuery();

            while (pasajeroEncontrado.next()) {
                pasajero.setIdPasajero(pasajeroEncontrado.getInt("id_pasajero"));
                pasajero.setNombre(pasajeroEncontrado.getString("nombre"));
                pasajero.setApellido(pasajeroEncontrado.getString("apellido"));
                pasajero.setDocumentoIdentidad(pasajeroEncontrado.getString("documento_identidad"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontro el pasajero" + e.getMessage());
        }

        cerrarConexion();

        return pasajero;
    }

    @Override
    public List<Pasajero> findAll() {
        List<Pasajero> pasajeros = new ArrayList<>();

        try {
            Connection conexion = obtenerConexion();
            String sql = "SELECT * FROM pasajero ORDER BY pasajero.id_pasajero ASC;";
            PreparedStatement sentencia = conexion.prepareStatement(sql);

            ResultSet pasajerosEncontrados = sentencia.executeQuery();

            while (pasajerosEncontrados.next()) {
                Pasajero pasajero = new Pasajero();

                pasajero.setIdPasajero(pasajerosEncontrados.getInt("id_pasajero"));
                pasajero.setNombre(pasajerosEncontrados.getString("nombre"));
                pasajero.setApellido(pasajerosEncontrados.getString("apellido"));
                pasajero.setDocumentoIdentidad(pasajerosEncontrados.getString("documento_identidad"));

                pasajeros.add(pasajero);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontraron pasajeros" + e.getMessage());
        }

        cerrarConexion();

        return pasajeros;
    }

    private void cerrarConexion() {
        ConfigDb.getInstance().closeConnection();
    }

    private Connection obtenerConexion() {
        return ConfigDb.getInstance().getConnection();
    }
}
