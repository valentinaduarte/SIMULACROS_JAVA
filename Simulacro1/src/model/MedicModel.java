package model;

import database.CRUD;
import database.ConfigDB;
import entity.Medic;
import entity.Medic;
import entity.Speciality;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Medic objMedic = (Medic) obj;

        try {
            String sql = "INSERT INTO medico (nombre, apellidos, id) VALUES (?, ?, ?);";
            PreparedStatement objPrepare =  objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objMedic.getName());
            objPrepare.setString(2, objMedic.getLastName());
            objPrepare.setInt(3, objMedic.getId());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()){
                objMedic.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "El medico fue agregado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error >" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return objMedic;

    }

    @Override
    public List<Object> findAll() {
        List<Object> listMedics = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM medico \n" + "INNER JOIN especialidad ON especialidad.id = medico.id_especialidad;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Medic objMedic = new Medic();
                Speciality objSpeciality = new Speciality();

                objMedic.setId(objResult.getInt("medico.id"));
                objMedic.setName(objResult.getString("medico.nombre"));
                objMedic.setLastName(objResult.getString("medico.apellidos"));
                objMedic.setIdSpeciality(objResult.getInt("medico.id_especialidad"));

                objSpeciality.setId(objResult.getInt("especialidad.id"));
                objSpeciality.setName(objResult.getString("especialidad.nombre"));
                objSpeciality.setDescription(objResult.getString("especialidad.descripcion"));

                objMedic.setObjSpeciality(objSpeciality);

                listMedics.add(objMedic);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listMedics;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Medic objMedic = (Medic) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE medico SET nombre = ?, apellidos = ?, id_especialidad = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objMedic.getName());
            objPrepare.setString(2,objMedic.getLastName());
            objPrepare.setInt(3,objMedic.getIdSpeciality());

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
        Medic objMedic = (Medic) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM medico WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objMedic.getId());

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
