package model;

import database.CRUD;
import database.ConfigDB;
import entities.Airplane;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneModel implements CRUD {
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Airplane objAirplane = (Airplane) obj;

        try {
            String sql = "INSERT INTO avion (modelo, capacidad) VALUES (?, ?);";
            PreparedStatement objPrepare =  objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objAirplane.getModel());
            objPrepare.setInt(2, objAirplane.getCapacity());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()){
                objAirplane.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "El avion fue agregado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error >" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return objAirplane;
    }



    public List<Object> findAll() {
        List<Object> listAirplanes = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM avion;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Airplane objAirplane = new Airplane();

                objAirplane.setId(objResult.getInt("id"));
                objAirplane.setModel(objResult.getString("modelo"));
                objAirplane.setCapacity(objResult.getInt("capacidad"));

                listAirplanes.add(objAirplane);
            }
        }catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return listAirplanes;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Airplane objAirplane = (Airplane) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE avion SET modelo = ?, capacidad = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objAirplane.getModel());
            objPrepare.setInt(2,objAirplane.getCapacity());

            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected > 0){
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"El avion ha sido actualizado correctamente.");
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
        Airplane objAirplane = (Airplane) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM avion WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objAirplane.getId());

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
