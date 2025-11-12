
// Importar dependencias: 

import java.util.Scanner;

// Class

public class Submarino extends VehiculoAcuatico {

    // Declaración de atributos: 

    private double profundidad;

    // Constructores

    public Submarino(String matricula, String modelo, double dimensionEslora, double profundidad) {
        super(matricula, modelo, dimensionEslora);
        this.profundidad = profundidad;

    } // Submarino() -> Con parámetros

    // Getters and Setters

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    // Métodos personalizados:

    public String imprimir() {
        return "Tipo de vehículo: Submarino, matricula: " + this.getMatricula() + ", modelo: " + this.getModelo() + ", dimensión de eslora: " + this.getDimensionEslora() + " metros. Profunidad: " + this.getProfundidad() + " metros.";
        
    } // imprimir()

} // class