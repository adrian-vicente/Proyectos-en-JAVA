package main.java.ud2;

// Importar dependencias: 

import java.util.Scanner;

// Class

public class Estudiante {
    
    // Declaración de atributos: 

    private String nombre; 
    private String estadoAsistencia;

    // Constructores

    public Estudiante() {
        this.nombre = "";
        this.estadoAsistencia = "";

    }

    public Estudiante(String nombre, String estadoAsistencia) {
        this.nombre = nombre;

    }

    // Getters and Setters

    public String getEstadoAsistencia() {
        return estadoAsistencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEstadoAsistencia(String estadoAsistencia) {
        this.estadoAsistencia = estadoAsistencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos personalizados: 

    public void validarAsistencia(String estado) {
        String estadoNoAsistido = "no asistido";
        String estadoAsistido = "asistido";
        if(estado.equalsIgnoreCase(estadoAsistido) || estado.equalsIgnoreCase(estadoNoAsistido)) {
            this.setEstadoAsistencia(estado);

        } else {
            throw new IllegalArgumentException("Argumento no permitido");

        } // else

    } // validarAsistencia

    public void leerEstudiante(Scanner ent_txt) {
        System.out.println("Introduce el nombre del estudiante: ");
        this.setNombre(ent_txt.nextLine());

    } // leerEstudiante

    @Override
    public String toString() {
        return "Nombre: " + this.getNombre() + ", estado de asistencia: " + this.getEstadoAsistencia();
    }

} // class