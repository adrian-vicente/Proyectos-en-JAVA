
// Importar dependencias: 

import java.util.Scanner;

// Class

public class Barco extends VehiculoAcuatico{

    // Declaración de atributos: 

    private boolean tieneMotor;

    // Constructores

    public Barco(String matricula, String modelo, double dimensionEslora, boolean tieneMotor) {
        super(matricula, modelo, dimensionEslora);
        this.tieneMotor = tieneMotor;

    } // Barco() -> Con parámetros

    // Getters and Setters

    public boolean getTieneMotor() {
        return this.tieneMotor;

    }

    public void setTieneMotor(boolean tieneMotor) {
        this.tieneMotor = tieneMotor;

    }

    // Métodos personalizados: 

    public String imprimir() {
        String cadena = "";
        if(this.getTieneMotor()) cadena = "Si";
        else cadena = "No";
        return "Tipo de Vehículo acuático: Barco, matricula: " + this.getMatricula() + ", modelo: " + this.getModelo() + ", dimensiones de eslora: " + this.getDimensionEslora() + " metros" + ", tiene motor: " + cadena;

    } // imprimir()

} // class