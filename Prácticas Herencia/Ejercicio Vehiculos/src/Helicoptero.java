
// Importar dependencias: 

import java.util.Scanner; 

// Class

public class Helicoptero extends VehiculoAereo {

    // Declaración de atributos: 

    private int numeroHelices;

    // Constructores:

    public Helicoptero(String matricula, String modelo, int numeroAsientos, int numeroHelices) {
        super(matricula, modelo, numeroAsientos);
        this.numeroHelices = numeroHelices;

    } // Helicoptero() -> Con parámetros

    // Getters and Setters

    public int getNumeroHelices() {
        return numeroHelices;
    }

    public void setNumeroHelices(int numeroHelices) {
        this.numeroHelices = numeroHelices;
    }

    // Métodos personalizados: 

    public String imprimir() {
        return "Tipo de vehículo aereo: Helicóptero, matricula: " + this.getMatricula() + ", modelo: " + this.getModelo() + ", número de asientos: " + this.getNumeroAsientos() 
         + ", número de helices: " + this.getNumeroHelices();

    } // imprimir()

} // class