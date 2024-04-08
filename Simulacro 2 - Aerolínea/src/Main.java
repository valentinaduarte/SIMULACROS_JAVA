import controller.AirplaneController;
import controller.FlightController;
import controller.PassengerController;
import controller.ReservationController;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int option = 0, option2 = 2;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Administrar Vuelos.
                    2. Administrar Aviones.
                    3. Administrar Pasajeros.
                    4. Administrar Reservaciones.
                    5. Salir.
                    
                    Ingrese una opción:
                    """));

            switch (option) {
                case 1:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Vuelos.
                                2. Crear Vuelos.
                                3. Eliminar Vuelos.
                                4. Actualizar Vuelos.
                                5. Salir.
                                
                                Ingrese una opcion:
                                """));

                        switch (option2) {
                            case 1:
                                FlightController.getAll();
                                break;
                            case 2:
                                FlightController.insert();
                                break;
                            case 3:
                                FlightController.delete();
                                break;
                            case 4:
                                FlightController.update();
                                break;
                        }
                    } while (option2 != 5);
                    break;

                case 2:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog(
                                """
                                1. Listar Aviones.
                                2. Crear Aviones.
                                3. Eliminar Aviones.
                                4. Actualizar Aviones.
                                5. Salir.
                                """));
                        switch (option2){
                            case 1:
                                AirplaneController.getAll();
                                break;
                            case 2:
                                AirplaneController.insert();
                                break;
                            case 3:
                                AirplaneController.delete();
                                break;
                            case 4:
                                AirplaneController.update();
                                break;
                        }
                    } while (option2 != 5);
                    break;

                case 3:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog(
                                """
                                1. Listar Pasajeros.
                                2. Crear Pasajeros.
                                3. Eliminar Pasajeros.
                                4. Actualizar Pasajeros.
                                5. Salir.
                                """));
                        switch (option2){
                            case 1:
                                PassengerController.getAll();
                                break;
                            case 2:
                                PassengerController.insert();
                                break;
                            case 3:
                                PassengerController.delete();
                                break;
                            case 4:
                                PassengerController.update();
                                break;
                        }
                    } while (option2 != 5);
                    break;

                case 4:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog(
                                """
                                1. Listar Reservaciones.
                                2. Crear Reservaciones.
                                3. Eliminar Reservaciones.
                                4. Actualizar Reservaciones.
                                5. Salir.
                                """));
                        switch (option2){
                            case 1:
                                ReservationController.getAll();
                                break;
                            case 2:
                                ReservationController.insert();
                                break;
                            case 3:
                                ReservationController.delete();
                                break;
                            case 4:
                                ReservationController.update();
                                break;
                        }
                    }while (option2 != 5);
            }
        } while (option != 5);
    }

}