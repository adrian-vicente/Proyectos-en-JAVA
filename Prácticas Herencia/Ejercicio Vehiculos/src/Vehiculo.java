
// Importar dependencias: 

import java.util.Scanner;

// Class Vehiculo

abstract class Vehiculo {

    // Declaración de atributos:

    private String matricula;
    private String modelo;

    // Declaración de constantes:

    private static final Scanner ent_txt = new Scanner(System.in);
    private static final Scanner ent_num = new Scanner(System.in);

    // Constructores:

    protected Vehiculo() {
        this.matricula = "";
        this.modelo = "";

    } // Vehiculo() -> Sin parámetros

    protected Vehiculo(String matricula, String modelo, int tipoVehiculo) {

        // Declaración de variables:

        boolean matriculaValida = false;

        // Introducción de datos:

        matriculaValida = this.setMatricula(matricula, tipoVehiculo);
        while (!matriculaValida) {
            System.out.println("Tipo de vehiculo: " + tipoVehiculo + "Introduce una nueva matrícula: ");
            matricula = ent_txt.nextLine();
            matriculaValida = this.setMatricula(matricula, tipoVehiculo);

        } // while

        this.modelo = modelo;

    } // Vehiculo() -> Con parámetros

    // Método set matricula para validarla según el tipo de vehículo

    private boolean setMatricula(String matricula, int tipoVehiculo) {

        // Declaración de variables:

        int contadorLetras = 0, contadorNumeros = 0;

        // Comprobaciones:

        switch (tipoVehiculo) {

            // Tipo de vehículo 1

            case 1: 
                for(int i = 0; i < matricula.length(); i++) {
                    Character caracterCadena = matricula.charAt(i);
                        if(Character.isLetter(caracterCadena)) contadorLetras++;
                        else if (Character.isDigit(caracterCadena)) contadorNumeros++;

                } // for

                if(contadorNumeros == 4 && contadorLetras == 3) {
                    this.matricula = matricula;
                    return true;
                }
                else return false;

            // Tipo de vehóculo 2

            case 2:
                for(int o = 0; o < matricula.length(); o++) {
                    Character caracterCadena = matricula.charAt(o);
                    if(Character.isLetter(caracterCadena)) contadorLetras++;
                    else if (Character.isDigit(caracterCadena)) contadorNumeros++;

                } // for

                if(contadorLetras >= 3 && contadorLetras <= 10) {
                    this.matricula = matricula;
                    return true;
                }
                else return false;

            // Tipo de vehículo 3

            case 3:
                for(int j = 0; j < matricula.length(); j++) {
                    Character caracterCadena = matricula.charAt(j);
                    if(Character.isLetter(caracterCadena)) contadorLetras++;
                    else if (Character.isDigit(caracterCadena)) contadorNumeros++;

                } // for

                if(contadorLetras == 4 && contadorNumeros == 6) {
                    this.matricula = matricula;
                    return true;
                }
                else return false;

            // Opción por defecto: 

            default: 
                return false;

        } // switch

    } // setMatricula

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    // Métodos personalizados:

    abstract String imprimir();

} // class