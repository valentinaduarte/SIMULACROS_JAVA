package controller;

import entity.Patient;
import model.PatientsModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class PatientController {
    public static void getAll() {
        String list = String.valueOf(getAll(instanceModel().findAll()));

        JOptionPane.showMessageDialog(null, list);
    }

    public static StringBuilder getAll(List<Object> list){
        StringBuilder listString = new StringBuilder("LISTA DE REGISTROS: \n");

        for (Object temp: list) {
            Patient objPatient = (Patient)temp;
            listString.append(objPatient.toString()).append("\n");
        }

        return listString;
    }


    public static void insert(){
        String name = JOptionPane.showInputDialog("Ingrese el nombre del paciente: ");
        String lastName = JOptionPane.showInputDialog("Ingrese el apellido del paciente: ");
        String birthday = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del paciente: ");
        String document = JOptionPane.showInputDialog("Ingrese el documento de identidad del paciente: ");
        
        instanceModel().insert(new Patient(name,lastName,birthday,document));
    }

    public static PatientsModel instanceModel(){
        return new PatientsModel();
    }

    public static void delete(){
        Object[] options  = Utils.listToArray(instanceModel().findAll());

        Patient objPatient = (Patient) JOptionPane.showInputDialog(
                null,
                "Selecciona el paciente a eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(objPatient);
    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Patient patientSelected = (Patient) JOptionPane.showInputDialog(
                null,
                "Selecciona el paciente:",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        patientSelected.setName(JOptionPane.showInputDialog(null,"Ingresa el nuevo nombre:",patientSelected.getName()));
        patientSelected.setLastName(JOptionPane.showInputDialog(null,"Ingresa la nueva descripción:",patientSelected.getLastName()));
        patientSelected.setBirthday(JOptionPane.showInputDialog(null,"Ingresa la nueva descripción:",patientSelected.getBirthday()));
        patientSelected.setDocument(JOptionPane.showInputDialog(null,"Ingresa la nueva descripción:",patientSelected.getDocument()));

        instanceModel().update(patientSelected);
    }
}
