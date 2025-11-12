
// Importar dependencias

import java.util.Scanner;

// Import class

public class VehiculoAereo extends Vehiculo {

    // Declaración de atributos: 

    private int numeroAsientos;
    private final static int TIPO_VEHICULO = 3;

    // Constructores:  

    public VehiculoAereo(String matricula, String modelo, int asientos) {
        super(matricula, modelo, VehiculoAereo.TIPO_VEHICULO);
        this.numeroAsientos = asientos;

    } // vehiculoAereo() -> Con parámetros

    // Getters and Setters

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    // Métodos personalizados: 

    public String imprimir() {
        return "Vehículo areo, matrícula: " + this.getMatricula() + ", modelo: " + this.getModelo() + ", número de asientos: " + this.getNumeroAsientos();

    } // imprimir()

} // class