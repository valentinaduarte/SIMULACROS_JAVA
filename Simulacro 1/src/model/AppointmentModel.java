package model;

import database.CRUD;
import database.ConfigDB;
import entity.Appointment;
import entity.Medic;
import entity.Patient;
import entity.Speciality;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Appointment objAppoinment = (Appointment) obj;

        try {
            String sql = "INSERT INTO cita (fecha, hora, motivo,id_paciente, id_medico ) VALUES (? ,? ,? ,? ,?);";
            PreparedStatement objPrepare =  objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setDate(1, Date.valueOf(objAppoinment.getDate()));
            objPrepare.setTime(2, Time.valueOf(objAppoinment.getTime()));
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

    public List<Object> findAll() {
        List<Object> listAppointments = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM cita \n" + "INNER JOIN paciente ON paciente.id = cita.id_paciente \n" + "INNER JOIN medico ON medico.id = cita.id_medico;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Appointment objAppointment = new Appointment();
                Patient objPatient = new Patient();
                Medic objMedic = new Medic();

                objAppointment.setId(objResult.getInt("cita.id"));
                objAppointment.setDate(objResult.getString("cita.fecha"));
                objAppointment.setTime(objResult.getString("cita.hora"));
                objAppointment.setMotive(objResult.getString("cita.motivo"));
                objAppointment.setIdPatient(objResult.getInt("cita.id_paciente"));
                objAppointment.setIdMedic(objResult.getInt("cita.id_medico"));


                objMedic.setName(objResult.getString("medico.nombre"));
                objPatient.setName(objResult.getString("paciente.nombre"));

                objAppointment.setObjPatient(objPatient);
                objAppointment.setObjMedic(objMedic);

                listAppointments.add(objAppointment);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listAppointments;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Appointment objAppointment = (Appointment) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE cita SET fecha = ?, hora = ?, motivo = ?, id_paciente = ?, id_medico = ? WHERE id = ? ";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setDate(1, Date.valueOf(objAppointment.getDate()));
            objPrepare.setTime(2, Time.valueOf(objAppointment.getTime()));
            objPrepare.setString(3, objAppointment.getMotive());
            objPrepare.setInt(4, objAppointment.getIdPatient());
            objPrepare.setInt(5, objAppointment.getIdMedic());
            objPrepare.setInt(6,objAppointment.getId());

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
        Appointment objAppointment = (Appointment) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM cita WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objAppointment.getId());

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
