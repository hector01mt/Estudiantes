
package com.mycompany.estudiantes;

/**
 *
 * @author Giovanna
 */

public class Estudiante {
    private String carnet;
    private String nombreCompleto;

    public Estudiante(String carnet, String nombreCompleto) {
        this.carnet = carnet;
        this.nombreCompleto = nombreCompleto;
    }

    public String getCarnet() {
        return carnet;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    @Override
    public String toString() {
        return "Carnet: " + carnet + ", Nombre: " + nombreCompleto;
    }
}

