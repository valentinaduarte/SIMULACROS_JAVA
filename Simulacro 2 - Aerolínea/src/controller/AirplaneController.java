package controller;

import entities.Airplane;
import model.AirplaneModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class AirplaneController {
    public static void getAll() {
        String list = String.valueOf(getAll(instanceModel().findAll()));

        JOptionPane.showMessageDialog(null, list);
    }

    public static StringBuilder getAll(List<Object> list){
        StringBuilder listString = new StringBuilder("LISTA DE REGISTROS: \n");

        for (Object temp: list) {
            Airplane objAirplane = (Airplane)temp;
            listString.append(objAirplane.toString()).append("\n");
        }

        return listString;
    }

    public static AirplaneModel instanceModel(){
        return new AirplaneModel();
    }

    public static void insert(){
        String model = JOptionPane.showInputDialog("Ingrese el modelo del avion: ");
        int capacity = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad del avion: "));

        instanceModel().insert(new Airplane(model,capacity));
    }
    
    public static void delete(){
        Object[] options  = Utils.listToArray(instanceModel().findAll());

        Airplane objAirplane = (Airplane) JOptionPane.showInputDialog(
                null,
                "Selecciona el paciente a eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(objAirplane);
    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Airplane airplaneSelected = (Airplane) JOptionPane.showInputDialog(
                null,
                "Selecciona el avion a actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        airplaneSelected.setModel(JOptionPane.showInputDialog(null,"Ingresa el nuevo modelo del avion:",airplaneSelected.getModel()));
        airplaneSelected.setCapacity(Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la nueva capacidad del avion:",airplaneSelected.getCapacity())));

        instanceModel().update(airplaneSelected);
    }



}
