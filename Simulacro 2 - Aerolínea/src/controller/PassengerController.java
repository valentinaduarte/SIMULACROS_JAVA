package controller;

import entities.Passenger;
import model.PassengerModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class PassengerController {
    public static void insert(){
        String name = JOptionPane.showInputDialog( "Ingrese el nombre del pasajero: ");
        String lastName = JOptionPane.showInputDialog( "Ingrese el apellido del pasajero: ");
        String document = JOptionPane.showInputDialog( "Ingrese el documento del pasajero: ");

        instanceModel().insert(new Passenger(name, lastName, document));

    }

    public static void getAll() {
        String list = String.valueOf(getAll(instanceModel().findAll()));

        JOptionPane.showMessageDialog(null, list);
    }

    public static StringBuilder getAll(List<Object> list){
        StringBuilder listString = new StringBuilder("LISTA DE REGISTROS: \n");

        for (Object temp: list) {
            Passenger objPassenger = (Passenger)temp;
            listString.append(objPassenger.toString()).append("\n");
        }

        return listString;
    }

    public static PassengerModel instanceModel() {
        return new PassengerModel();
    }


    public static void delete(){
        Object[] options  = Utils.listToArray(instanceModel().findAll());

        Passenger objPassenger = (Passenger) JOptionPane.showInputDialog(
                null,
                "Selecciona el pasajero a eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(objPassenger);
    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Passenger objSelected = (Passenger) JOptionPane.showInputDialog(
                null,
                "Selecciona un pasajero a actualizar.",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        objSelected.setName(JOptionPane.showInputDialog(null,"Ingresa el nuevo nombre:",objSelected.getName()));
        objSelected.setLastName(JOptionPane.showInputDialog(null,"Ingresa el nuevo apellido:",objSelected.getLastName()));
        objSelected.setDocument(JOptionPane.showInputDialog(null,"Ingresa el nuevo documento de identidad:",objSelected.getDocument()));

        instanceModel().update(objSelected);
    }
}
