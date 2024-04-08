package model;

import database.CRUD;
import database.ConfigDB;
import entities.Passenger;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerModel implements CRUD {
    @Override
    public Object insert(Object obj) {

        Connection objConnection = ConfigDB.openConnection();

        Passenger objPassenger = (Passenger) obj;

        try {
            String sql = "INSERT INTO pasajero (nombre, apellido, documento_identidad) VALUES (?, ?, ?);";
            PreparedStatement objPrepare =  objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objPassenger.getName());
            objPrepare.setString(2, objPassenger.getLastName());
            objPrepare.setString(3, objPassenger.getDocument());


            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()){
                objPassenger.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "El pasajero fue agregado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error >" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return objPassenger;
    }


    public List<Object> findAll() {
        List<Object> listPassengers = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM pasajero;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Passenger objPassenger = new Passenger();

                objPassenger.setId(objResult.getInt("id"));
                objPassenger.setName(objResult.getString("nombre"));
                objPassenger.setLastName(objResult.getString("apellido"));
                objPassenger.setDocument(objResult.getString("documento_identidad"));

                listPassengers.add(objPassenger);
            }
        }catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listPassengers;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Passenger objPassenger = (Passenger) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE pasajero SET nombre = ?, appellido = ?, documento_identidad = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objPassenger.getName());
            objPrepare.setString(2,objPassenger.getLastName());
            objPrepare.setString(3,objPassenger.getDocument());
            objPrepare.setInt(4,objPassenger.getId());

            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected > 0){
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"El pasajero ha sido actualizado correctamente.");
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
        Passenger objPassenger = (Passenger) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM pasajero WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objPassenger.getId());

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
