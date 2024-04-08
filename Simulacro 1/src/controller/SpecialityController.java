package controller;

import entity.Medic;
import entity.Speciality;
import model.SpecialityModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class SpecialityController {
    public static void insert(){
        String name = JOptionPane.showInputDialog( "Ingrese el nombre de la especialidad: ");
        String description = JOptionPane.showInputDialog( "Ingrese la descripcion de la especialidad: ");

        instanceModel().insert(new Speciality(name, description));

    }

    public static void getAll() {
        String list = String.valueOf(getAll(instanceModel().findAll()));

        JOptionPane.showMessageDialog(null, list);
    }

    public static StringBuilder getAll(List<Object> list){
        StringBuilder listString = new StringBuilder("LISTA DE REGISTROS: \n");

        for (Object temp: list) {
            Speciality objSpeciality = (Speciality)temp;
            listString.append(objSpeciality.toString()).append("\n");
        }

        return listString;
    }

    public static SpecialityModel instanceModel() {
        return new SpecialityModel();
    }


    public static void delete(){
        Object[] options  = Utils.listToArray(instanceModel().findAll());

        Speciality objSpeciality = (Speciality) JOptionPane.showInputDialog(
                null,
                "Selecciona la especializacion a eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(objSpeciality);
    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Speciality objSelected = (Speciality) JOptionPane.showInputDialog(
                null,
                "Selecciona una especialidad.",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

       objSelected.setName(JOptionPane.showInputDialog(null,"Ingresa el nuevo nombre:",objSelected.getName()));
       objSelected.setDescription(JOptionPane.showInputDialog(null,"Ingresa la nueva descripción:",objSelected.getDescription()));

       instanceModel().update(objSelected);
    }
}
