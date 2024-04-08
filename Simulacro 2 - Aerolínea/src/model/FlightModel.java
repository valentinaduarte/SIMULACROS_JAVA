package model;

import database.CRUD;
import database.ConfigDB;
import entities.Airplane;
import entities.Flight;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Flight objFlight = (Flight) obj;

        try {
            String sql = "INSERT INTO vuelo (destino , fecha_salida, hora_salida ,id_avion ) VALUES (?, ?, ?, ?);";
            PreparedStatement objPrepare =  objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objFlight.getDestination());
            objPrepare.setString(2, objFlight.getDepartureDate());
            objPrepare.setString(3, objFlight.getDepartureTime());
            objPrepare.setInt(4, objFlight.getIdAvion());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()){
                objFlight.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "El vuelo fue agregado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error >" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return objFlight;

    }

    @Override
    public List<Object> findAll() {
        List<Object> listFlights = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM vuelo \n" + "INNER JOIN avion ON avion.id = vuelo.id_avion;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Flight objFlight = new Flight();
                Airplane objAirplane = new Airplane();

                objFlight.setId(objResult.getInt("vuelo.id"));
                objFlight.setDestination(objResult.getString("vuelo.destino"));
                objFlight.setDepartureDate(objResult.getString("vuelo.fecha_salida"));
                objFlight.setDepartureTime(objResult.getString("vuelo.hora_salida"));

                objAirplane.setId(objResult.getInt("avion.id"));
                objAirplane.setModel(objResult.getString("avion.modelo"));
                objAirplane.setCapacity(Integer.parseInt(objResult.getString("avion.capacidad")));

                objFlight.setObjAirplane(objAirplane);

                listFlights.add(objFlight);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listFlights;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Flight objFlight = (Flight) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE vuelo SET destino = ?, fecha_salida = ?, fecha_salida = ?, id_avion = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objFlight.getDestination());
            objPrepare.setString(2,objFlight.getDepartureDate());
            objPrepare.setString(3,objFlight.getDepartureTime());
            objPrepare.setInt(4,objFlight.getIdAvion());
            objPrepare.setInt(5,objFlight.getId());

            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected > 0){
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"Registro actualizado correctamente.");
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isUpdated;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Flight objFlight = (Flight) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM vuelo WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objFlight.getId());

            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows > 0){
                isDeleted = true;

                JOptionPane.showMessageDialog(null,"Registro eliminado correctamente.");

            }
        }catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }
}
