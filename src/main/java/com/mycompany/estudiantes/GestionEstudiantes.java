
package com.mycompany.estudiantes;

/**
 *
 * @author Giovanna
 */

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class GestionEstudiantes {
    private static Map<String, Estudiante> estudiantesMap = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            String[] opciones = {"Ingresar Estudiante", "Buscar Estudiante", "Eliminar Estudiante", "Mostrar Todos", "Salir"};
            String seleccion = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción",
                    "Menú Principal",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            if (seleccion == null || seleccion.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                break;
            }

            switch (seleccion) {
                case "Ingresar Estudiante":
                    ingresarEstudiante();
                    break;
                case "Buscar Estudiante":
                    buscarEstudiante();
                    break;
                case "Eliminar Estudiante":
                    eliminarEstudiante();
                    break;
                case "Mostrar Todos":
                    mostrarTodosLosEstudiantes();
                    break;
            }
        }
    }

    private static void ingresarEstudiante() {
        String carnet = JOptionPane.showInputDialog("Ingrese el carnet del estudiante:");
        if (carnet == null || carnet.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Carnet no válido.");
            return;
        }

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre completo del estudiante:");
        if (nombre == null || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre no válido.");
            return;
        }

        Estudiante nuevoEstudiante = new Estudiante(carnet, nombre);
        estudiantesMap.put(carnet, nuevoEstudiante);
        JOptionPane.showMessageDialog(null, "Estudiante ingresado exitosamente.");
    }

    private static void buscarEstudiante() {
        String carnet = JOptionPane.showInputDialog("Ingrese el carnet del estudiante a buscar:");
        if (carnet == null || carnet.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Carnet no válido.");
            return;
        }

        Estudiante estudiante = estudiantesMap.get(carnet);
        if (estudiante != null) {
            JOptionPane.showMessageDialog(null, "Estudiante encontrado: \n" + estudiante);
        } else {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado, no se puede mostrar.");
        }
    }

    private static void eliminarEstudiante() {
        String carnet = JOptionPane.showInputDialog("Ingrese el carnet del estudiante a eliminar:");
        if (carnet == null || carnet.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Carnet no válido.");
            return;
        }

        if (estudiantesMap.remove(carnet) != null) {
            JOptionPane.showMessageDialog(null, "Estudiante eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado, no se puede eliminar.");
        }
    }

    private static void mostrarTodosLosEstudiantes() {
        if (estudiantesMap.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");
        } else {
            StringBuilder listaEstudiantes = new StringBuilder("Lista de todos los estudiantes:\n");
            for (Estudiante estudiante : estudiantesMap.values()) {
                listaEstudiantes.append(estudiante).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaEstudiantes.toString());
        }
    }
}

