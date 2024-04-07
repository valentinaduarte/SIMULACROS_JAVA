package controller;

import entity.Medic;
import entity.Speciality;
import model.MedicModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class MedicController {

    public static void getAll() {
        String list = String.valueOf(getAll(instanceModel().findAll()));

        JOptionPane.showMessageDialog(null, list);
    }

    public static StringBuilder getAll(List<Object> list){
        StringBuilder listString = new StringBuilder("LISTA DE REGISTROS: \n");

        for (Object temp: list) {
            Medic objMedic = (Medic) temp;
            listString.append(objMedic.toString()).append("\n");
        }
        return listString;
    }

    public static void delete(){
        Object[] options  = Utils.listToArray(instanceModel().findAll());

        Medic objMedic = (Medic) JOptionPane.showInputDialog(
                null,
                "Selecciona el medico a eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(objMedic);
    }

    public static void insert(){
        String name = JOptionPane.showInputDialog("Ingrese el nombre del medico: ");
        String lastName = JOptionPane.showInputDialog("Ingrese el apellido del medico: ");

        Object[] optionsSpecialities  = Utils.listToArray(SpecialityController.instanceModel().findAll());

        Speciality objSpeciality = (Speciality) JOptionPane.showInputDialog(
                null,
                "Selecciona una especialidad.",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsSpecialities,
                optionsSpecialities[0]
        );

        instanceModel().insert(new Medic(name,lastName,objSpeciality.getId(),objSpeciality));
    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Medic objMedic = (Medic) JOptionPane.showInputDialog(
                null,
                "Selecciona un medico.",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        String name = JOptionPane.showInputDialog(null,"Ingresa el nombre del medico:",objMedic.getName());
        String lastName = JOptionPane.showInputDialog(null,"Ingresa el apellido del medico:",objMedic.getLastName());

        Object[] optionsSpecialities  = Utils.listToArray(SpecialityController.instanceModel().findAll());

        Speciality objSpeciality = (Speciality) JOptionPane.showInputDialog(
                null,
                "Selecciona una especialidad.",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsSpecialities,
                optionsSpecialities[0]
        );

        instanceModel().update(new Medic(name,lastName,objSpeciality.getId(),objSpeciality));
    }



    public static MedicModel instanceModel(){
        return new MedicModel();
    }

}
