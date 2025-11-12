
// Importar dependencias: 

import java.util.Scanner; 

// Class

public class VehiculoAcuatico extends Vehiculo {

    // Declaración de atributos: 

    private double dimensionEslora;
    private static final int TIPO_VEHICULO = 2;

    // Constructores

    public VehiculoAcuatico(String matricula, String modelo, double eslora) {
        super(matricula, modelo, VehiculoAcuatico.TIPO_VEHICULO);
        this.dimensionEslora = eslora;

    } // VehiculoAcuatico() -> Con parámetros

    // Getters and Setters

    public double getDimensionEslora() {
        return dimensionEslora;
    
    }

    public void setDimensionEslora(double dimensionEslora) {
        this.dimensionEslora = dimensionEslora;

    }

    // Métodos personalizados: 

    public String imprimir() {
        return "Vehículo acuático, matricula: " + this.getMatricula() + ", modelo: " + this.getModelo() + ", dimensión de eslora: " + this.getDimensionEslora() + " metros.";

    } // imprimir()

} // class