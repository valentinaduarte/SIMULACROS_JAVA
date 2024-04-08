package controller;

import entity.Appointment;
import entity.Medic;
import entity.Patient;
import entity.Speciality;
import model.AppointmentModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class AppointmentController {
    public static void insert() {
        String date = JOptionPane.showInputDialog("Ingrese la fecha de la cita: YYYY-MM-dd ");
        String time = JOptionPane.showInputDialog("Ingrese la hora de la cita: HH:mm:ss ");
        String motive = JOptionPane.showInputDialog("Ingrese el motivo de la cita: ");


        Object[] optionsPatients = Utils.listToArray(PatientController.instanceModel().findAll());
        Object[] optionsMedics = Utils.listToArray(MedicController.instanceModel().findAll());

        Medic MedicSelected = (Medic) JOptionPane.showInputDialog(
                null,
                "Selecciona el medico asignado a la cita: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsMedics,
                optionsMedics[0]
        );

        Patient patientSelected = (Patient) JOptionPane.showInputDialog(
                null,
                "Selecciona el paciente: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsPatients,
                optionsPatients[0]
        );

        instanceModel().insert(new Appointment(date,time,motive,patientSelected.getId(),MedicSelected.getId(), MedicSelected, patientSelected));

    }
    public static AppointmentModel instanceModel () {
        return new AppointmentModel();
    }

    public static void getAll() {
        String list = getAll(instanceModel().findAll());

        JOptionPane.showMessageDialog(null, list);
    }

    public static String getAll(List<Object> list){
        String listString = "LISTA DE REGISTROS: \n";

        for (Object temp: list) {
            Appointment objAppointment = (Appointment) temp;
            listString+= objAppointment.toString() + "\n";
        }
        return listString;
    }

    public static void delete(){
        Object[] options  = Utils.listToArray(instanceModel().findAll());

        Appointment AppointmentSelected = (Appointment) JOptionPane.showInputDialog(
                null,
                "Selecciona la cita a eliminar a eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(AppointmentSelected);
    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Appointment AppointmentSelected = (Appointment) JOptionPane.showInputDialog(
                null,
                "Selecciona una cita ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        AppointmentSelected.setDate(JOptionPane.showInputDialog("Ingrese la fecha de la cita: YYYY-MM-dd "));
        AppointmentSelected.setTime(JOptionPane.showInputDialog("Ingrese la hora de la cita: HH:mm:ss "));
        AppointmentSelected.setMotive(JOptionPane.showInputDialog("Ingrese el motivo de la cita: "));

        Object[] optionsPatients = Utils.listToArray(PatientController.instanceModel().findAll());
        Object[] optionsMedics = Utils.listToArray(MedicController.instanceModel().findAll());

        AppointmentSelected.setObjMedic( (Medic) JOptionPane.showInputDialog(
                null,
                "Selecciona el medico asignado a la cita: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsMedics,
                optionsMedics[0]
        ));


        AppointmentSelected.setIdMedic(AppointmentSelected.getObjMedic().getId());


        AppointmentSelected.setObjPatient( (Patient) JOptionPane.showInputDialog(
                null,
                "Selecciona el paciente: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsPatients,
                optionsPatients[0]
        ));

        AppointmentSelected.setIdPatient(AppointmentSelected.getObjPatient().getId());

        instanceModel().update(AppointmentSelected);
    }

}
