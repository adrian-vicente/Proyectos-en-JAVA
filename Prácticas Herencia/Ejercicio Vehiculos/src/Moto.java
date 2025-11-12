
// Importar dependencias: 

import java.util.Scanner;

// Class

public class Moto extends VehiculoTerrestre {

    // Declaraciones de atributos: 

    private String color;

    // Constructores

    public Moto(String matricula, String modelo, int numeroRuedas, String color) {
        super(matricula, modelo, numeroRuedas);
        this.color = color;

    } // moto() -> Con parámetros

    // Getters and Setters: 

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Métodos personalizados: 

    public String imprimir() {
        return "Vehículo terrestre: Moto. Matrícula: " + this.getMatricula() + ", modelo: " + this.getModelo() + ", número de ruedas: " + this.getNumeroRueda() + ", color de la moto: " + this.getColor();

    } // imprimir()
    
} // class