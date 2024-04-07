package model;

import database.CRUD;
import database.ConfigDB;
import entity.Appointment;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AppointmentModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Appointment objAppoinment = (Appointment) obj;

        try {
            String sql = "INSERT INTO cita (fecha, hora, motivo,id_paciente, id_medico ) VALUES (? ,? ,? ,? ,?);";
            PreparedStatement objPrepare =  objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objAppoinment.getDate());
            objPrepare.setString(2, objAppoinment.getTime());
            objPrepare.setString(3, objAppoinment.getMotive());
            objPrepare.setInt(4, objAppoinment.getIdPatient());
            objPrepare.setInt(5, objAppoinment.getIdMedic());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()){
                objAppoinment.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "La cita fue agregada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error >" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return objAppoinment;
    }

    @Override
    public List<Object> findAll() {
        return null;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
