import controller.MedicController;
import controller.PatientController;
import controller.SpecialityController;
import database.ConfigDB;
import entity.Medic;
import entity.Speciality;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int option = 0, option2 = 2;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Administrar Especialidades.
                    2. Administrar Medicos.
                    3. Administrar Pacientes.
                    4. Administrar Citas.
                    5. Salir.
                    
                    Ingrese una opción:
                    """));

            switch (option) {
                case 1:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Especialidades.
                                2. Crear Especialidades.
                                3. Eliminar Especialidad.
                                4. Actualizar Especialidad.
                                5. Salir.
                                
                                Ingrese una opcion:
                                """));

                        switch (option2) {
                            case 1:
                                SpecialityController.getAll();
                                break;
                            case 2:
                                SpecialityController.insert();
                                break;
                            case 3:
                                SpecialityController.delete();
                                break;
                            case 4:
                                SpecialityController.update();
                                break;
                        }
                    } while (option2 != 5);
                    break;

                case 2:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog(
                                """
                                1. Listar Medicos.
                                2. Crear Medico.
                                3. Eliminar Medico.
                                4. Actualizar Medico.
                                5. Salir.
                                """));
                            switch (option2){
                                case 1:
                                    MedicController.getAll();
                                    break;
                                case 2:
                                    MedicController.insert();
                                    break;
                                case 3:
                                    MedicController.delete();
                                    break;
                                case 4:
                                    MedicController.update();
                                    break;
                            }
                    } while (option2 != 5);
                    break;

                case 3:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog(
                                """
                                1. Listar Pacientes.
                                2. Crear Paciente.
                                3. Eliminar Paciente.
                                4. Actualizar Paciente.
                                5. Salir.
                                """));
                        switch (option2){
                            case 1:
                                PatientController.getAll();
                                break;
                            case 2:
                                PatientController.insert();
                                break;
                            case 3:
                                PatientController.delete();
                                break;
                            case 4:
                                PatientController.update();
                                break;
                        }
                    } while (option2 != 5);
                    break;
                    }


        } while (option != 5);
    }
}