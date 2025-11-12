
// Importar dependencias: 

import java.util.Scanner; 

// Class

public class Avion extends VehiculoAereo {

    // Declaración de atributos: 

    private double tiempoVuelo;

    // Constructores

    public Avion(String matricula, String modelo, int numeroAsientos, double tiempoVuelo) {
        super(matricula, modelo, numeroAsientos);
        this.tiempoVuelo = tiempoVuelo;

    } // Avion() -> Con parámetros

    // Getters and Setters

    public double getTiempoVuelo() {
        return tiempoVuelo;
    }

    public void setTiempoVuelo(double tiempoVuelo) {
        this.tiempoVuelo = tiempoVuelo;
    }

    // Métodos personalizados: 

    public String imprimir() {
        return "Tipo de Vehículo aereo: Avión, matricula: " + this.getMatricula() + ", modelo: " + this.getModelo() + ", número de asientos: " + this.getNumeroAsientos() + ", tiempo de vuelo: " + this.getTiempoVuelo();

    } // imprimir()

} // class