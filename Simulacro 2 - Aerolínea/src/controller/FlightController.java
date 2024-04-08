package controller;

import entities.Airplane;
import entities.Flight;
import utils.Utils;
import model.FlightModel;
import javax.swing.*;
import java.util.List;

public class FlightController {

    public static void getAll() {
        String list = String.valueOf(getAll(instanceModel().findAll()));

        JOptionPane.showMessageDialog(null, list);
    }

    public static String getAll(List<Object> list){
        String listString = "LISTA DE REGISTROS: \n";

        for (Object temp: list) {
            Flight objFlight = (Flight) temp;
            listString+= objFlight.toString() + "\n";
        }
        return listString;
    }

    public static void delete(){
        Object[] options  = Utils.listToArray(instanceModel().findAll());

        Flight objFlight = (Flight) JOptionPane.showInputDialog(
                null,
                "Selecciona el flighto a eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(objFlight);
    }

    public static void insert(){
        String destination = JOptionPane.showInputDialog("Ingrese el destino del vuelo: ");
        String departureDate = JOptionPane.showInputDialog("Ingrese la fecha de salida del vuelo: YYYY-MM-dd ");
        String departureTime = JOptionPane.showInputDialog("Ingrese la hora de salida del vuelo: HH:mm:ss ");


        Object[] optionsAirplanes  = Utils.listToArray(AirplaneController.instanceModel().findAll());

        Airplane objAirplane = (Airplane) JOptionPane.showInputDialog(
                null,
                "Selecciona una especialidad.",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsAirplanes,
                optionsAirplanes[0]
        );
        instanceModel().insert(new Flight(destination,departureDate,departureTime,objAirplane.getId(),objAirplane));
    }

    public static void update() {
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Flight objFlight = (Flight) JOptionPane.showInputDialog(
                null,
                "Selecciona un vuelo para actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        objFlight.setDestination(JOptionPane.showInputDialog("Ingrese el destino del vuelo: "));
        objFlight.setDepartureDate(JOptionPane.showInputDialog("Ingrese la fecha de salida del vuelo: YYYY-MM-dd "));
        objFlight.setDepartureTime(JOptionPane.showInputDialog("Ingrese la hora de salida del vuelo: HH:mm:ss "));


        Object[] optionsAirplanes  = Utils.listToArray(AirplaneController.instanceModel().findAll());

        Airplane objAirplane = (Airplane) JOptionPane.showInputDialog(
                null,
                "Selecciona un avion:",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsAirplanes,
                optionsAirplanes[0]
        );

        objFlight.setIdAvion(objFlight.getObjAirplane().getId());
        instanceModel().update(objFlight);
    }


    public static  FlightModel instanceModel(){
        return new FlightModel();
    }
}
