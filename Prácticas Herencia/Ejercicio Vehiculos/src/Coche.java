
// Importar dependencias: 

import java.util.Scanner;

// Class

public class Coche extends VehiculoTerrestre {

    // Declaración de atributos: 

    private boolean tieneAireAcondicionado;

    // Constructores: 

    public Coche(String matricula, String modelo, int numeroRuedas, boolean tieneAire) {
        super(matricula, modelo, numeroRuedas);
        this.tieneAireAcondicionado = tieneAire;

    } // Coche() -> Con parámetros

    // Getters and Setters

    public void setTieneAireAcondicionado(boolean tieneAireAcondicionado) {
        this.tieneAireAcondicionado = tieneAireAcondicionado;
    }

    public boolean getTieneAire() {
        return this.tieneAireAcondicionado;

    } // getTieneAire()

    // Métodos personalizados: 

    public String imprimir() {
        String tieneAire = "";
        if(this.getTieneAire()) tieneAire = "Si";
        else tieneAire = "No";
        return "Vehículo terreste: Coche, matrícula: " + this.getMatricula() + ", modelo: " + this.getModelo() + ", número de ruedas: " + this.getNumeroRueda() + " " + tieneAire;

    } // imprimir()

} // class