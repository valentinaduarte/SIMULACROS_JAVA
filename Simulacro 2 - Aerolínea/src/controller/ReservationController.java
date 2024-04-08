package controller;

import entities.Airplane;
import entities.Flight;
import entities.Passenger;
import entities.Reservation;
import model.PassengerModel;
import model.ReservationModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class ReservationController {
    public static void insert() {
        String reservationDate = JOptionPane.showInputDialog("Ingrese la fecha de la reserva: YYYY-MM-dd ");
        String seat = JOptionPane.showInputDialog("Ingrese el asiento del pasajero: ");
        
        Object[] optionsFlights = Utils.listToArray(FlightController.instanceModel().findAll());
        Object[] optionsPassengers = Utils.listToArray(PassengerController.instanceModel().findAll());

        Flight FlightSelected = (Flight) JOptionPane.showInputDialog(
                null,
                "Selecciona el medico asignado a la cita: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsFlights,
                optionsFlights[0]
        );

        Passenger passengerSelected = (Passenger) JOptionPane.showInputDialog(
                null,
                "Selecciona el paciente: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsPassengers,
                optionsPassengers[0]
        );

        instanceModel().insert(new Reservation(reservationDate,seat,FlightSelected.getId(),passengerSelected.getId(), FlightSelected, passengerSelected));

    }
    public static ReservationModel instanceModel () {
        return new ReservationModel();
    }

    public static void getAll() {
        String list = String.valueOf(getAll(instanceModel().findAll()));

        JOptionPane.showMessageDialog(null, list);
    }

    public static StringBuilder getAll(List<Object> list){
        StringBuilder listString = new StringBuilder("LISTA DE REGISTROS: \n");

        for (Object temp: list) {
            Reservation objReservation = (Reservation) temp;
            listString.append(objReservation.toString()).append("\n");
        }

        return listString;
    }

    public static void delete(){
        Object[] options  = Utils.listToArray(instanceModel().findAll());

        Reservation ReservationSelected = (Reservation) JOptionPane.showInputDialog(
                null,
                "Selecciona la reservación a eliminar a eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(ReservationSelected);
    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Reservation ReservationSelected = (Reservation) JOptionPane.showInputDialog(
                null,
                "Selecciona una reservación para actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        ReservationSelected.setReservationDate(JOptionPane.showInputDialog("Ingrese la fecha de la reservación: YYYY-MM-dd "));
        ReservationSelected.setSeat(JOptionPane.showInputDialog("Ingrese el asiento del pasajero: "));

        Object[] optionsFlights = Utils.listToArray(FlightController.instanceModel().findAll());
        Object[] optionsPassengers = Utils.listToArray(PassengerController.instanceModel().findAll());

        Flight FlightSelected = (Flight) JOptionPane.showInputDialog(
                null,
                "Selecciona el vuelo asignado a la reservacion: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsFlights,
                optionsFlights[0]
        );

        Passenger passengerSelected = (Passenger) JOptionPane.showInputDialog(
                null,
                "Selecciona el pasajero asignado a la reservacion: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsPassengers,
                optionsPassengers[0]
        );

        ReservationSelected.setIdVuelo(ReservationSelected.getObjFlight().getId());

        ReservationSelected.setIdPasajero(ReservationSelected.getObjPassenger().getId());

        instanceModel().update(ReservationSelected);
    }


    
}
