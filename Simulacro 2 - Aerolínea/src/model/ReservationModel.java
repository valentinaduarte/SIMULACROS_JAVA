package model;

import database.CRUD;
import database.ConfigDB;
import entities.Flight;
import entities.Passenger;
import entities.Reservation;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationModel implements CRUD {
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Reservation objReservation = (Reservation) obj;

        try {
            String sql = "INSERT INTO reservacion ( fecha_reservacion, asiento,id_vuelo, id_pasajero ) VALUES (? ,? ,? ,?);";
            PreparedStatement objPrepare =  objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setDate(1, Date.valueOf(objReservation.getReservationDate()));
            objPrepare.setString(2, objReservation.getSeat());
            objPrepare.setInt(3, objReservation.getIdVuelo());
            objPrepare.setInt(4, objReservation.getIdPasajero());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()){
                objReservation.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "La reservación fue agregada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error >" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return objReservation;
    }

    public List<Object> findAll() {
        List<Object> listReservations = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM reservacion \n" + "INNER JOIN vuelo ON vuelo.id = reservacion.id_vuelo \n" + "INNER JOIN pasajero ON pasajero.id = reservacion.id_pasajero;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Reservation objReservation = new Reservation();
                Flight objFlight = new Flight();
                Passenger objPassenger = new Passenger();

                objReservation.setId(objResult.getInt("reservacion.id"));
                objReservation.setReservationDate(objResult.getString("reservacion.fecha_reservacion"));
                objReservation.setSeat(objResult.getString("reservacion.asiento"));
                objReservation.setIdVuelo(objResult.getInt("reservacion.id_vuelo"));
                objReservation.setIdPasajero(objResult.getInt("reservacion.id_pasajero"));


                objFlight.setDestination(objResult.getString("vueLo.destino"));
                objPassenger.setName(objResult.getString("pasajero.nombre"));

                objReservation.setObjFlight(objFlight);
                objReservation.setObjPassenger(objPassenger);

                listReservations.add(objReservation);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listReservations;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Reservation objReservation = (Reservation) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE reservacion SET fecha_reservacion = ?, asiento = ?, id_vuelo = ?, id_pasajero = ? WHERE id = ? ";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setDate(1, Date.valueOf(objReservation.getReservationDate()));
            objPrepare.setString(2, objReservation.getSeat());
            objPrepare.setInt(3, objReservation.getIdVuelo());
            objPrepare.setInt(4, objReservation.getIdPasajero());
            objPrepare.setInt(5,objReservation.getId());

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
        Reservation objReservation = (Reservation) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM reservacion WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objReservation.getId());

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
