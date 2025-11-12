
// Importar dependencias: 

import java.util.Scanner;

// Class

public class VehiculoTerrestre extends Vehiculo {
 
    // Declaración de atributos: 

    private int numeroRueda;
    private static final int TIPO_VEHICULO = 1;

    // Constructores: 

    public VehiculoTerrestre(String matricula, String modelo, int numeroRueda) {
        super(matricula, modelo, VehiculoTerrestre.TIPO_VEHICULO);
        this.numeroRueda = numeroRueda;

    } // VehiculoTerrestre() -> Con parámetros

    // Getters and Setters

    public int getNumeroRueda() {
        return numeroRueda;
    }

    public void setNumeroRueda(int numeroRueda) {
        this.numeroRueda = numeroRueda;

    } // setNumeroRueda()

    // Métodos personalizados: 

    public String imprimir() {
        return "Vehículo terrestre, matricula: " + this.getMatricula() + ", modelo: " + this.getModelo() + ", número de ruedas: " + this.getNumeroRueda();

    } // imprimir()

} // class