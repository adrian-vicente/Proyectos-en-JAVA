package main.java.ud2;

// Importar dependencias 

import java.util.Scanner;
import java.util.Random;

/**
 * 
 * @author Adrián Vicente Vera
 * @since 05/10/2025
 * Ejercicio M_5
 * 
 */

// Class

public class EjercicioM_5 {

    // Variables globales

    public static Scanner ent_txt = new Scanner(System.in);
    public static Scanner ent_num = new Scanner(System.in);
    public static Random rand = new Random();

    // Método main: 

    public static void main(String[] args) {
        
        // Declaración de la matriz: 

        int filas = 6, columnas = 4;
        String[][] mVersiones = new String[filas][columnas];
        String[] vEstados = {"OK", "NULL", "ERROR"};
        int numeroAleatorio = 0, numeroErrores = 0;

        // Inicializar la matriz: 

        for(int i = 0; i < mVersiones.length; i++) {
            for(int o = 0; o < mVersiones[o].length; o++) {
                
                // Generar número aleatorio para el contenido de la variable: 

                numeroAleatorio = rand.nextInt(3);

                // Asignar el contenido a la posición actual de la matriz: 

                mVersiones[i][o] = vEstados[numeroAleatorio];

            } // for

        } // for

        // Mostrar la variable: 

        for(int i = 0; i < mVersiones.length; i++) {
            for(int o = 0; o < mVersiones[o].length; o++) System.out.println("Variable: " + (i + 1) + ", versión: " + (o + 1) + ", valor: " + mVersiones[i][o]);

        } // for

        // Mostrar qué variables han tenido al menos un error

        numeroErrores = 0; 
        for(int i = 0; i < mVersiones.length; i++) {
            for(int j = 0; j < mVersiones[i].length; j++) {
                if(mVersiones[i][j].equalsIgnoreCase("ERROR")) numeroErrores++;

            } // for
            
            // Comprobaciones

            if(numeroErrores >= 1) {
                System.out.println("Variable: " + (i + 1) + ", número de errores: " + numeroErrores);

            } // if

            // Reiniciar variable

            numeroErrores = 0;
        
        } // for

        // Mostrar en qué versión se producen más null 

        int versionNulls = 0;
        int cantidadMaxNulls = 0;  
        for (int j = 0; j < mVersiones[0].length; j++) { 
            int contadorNulls = 0;

            for (int i = 0; i < mVersiones.length; i++) { 
                if (mVersiones[i][j].equalsIgnoreCase("NULL")) {
                    contadorNulls++;

                } // if

            } // for

            if (contadorNulls > cantidadMaxNulls) {
                cantidadMaxNulls = contadorNulls;
                versionNulls = j;

            } // if

        } // for

        // Mostrar resultado

        System.out.println("Versión con más NULL: " + (versionNulls + 1) +  ", con " + cantidadMaxNulls + " NULLs");

        // Mostrar un resumen con cuántas veces aparece cada estado glboalment

        int contadorOK = 0, contadorERROR = 0, contadorNull = 0;
        for(int i = 0; i < mVersiones.length; i++) {
            for(int j = 0; j < mVersiones[j].length; j++) {
                if(mVersiones[i][j].equalsIgnoreCase("ERROR")) contadorERROR++;
                else if (mVersiones[i][j].equalsIgnoreCase("OK")) contadorOK++;
                else if (mVersiones[i][j].equalsIgnoreCase("NULL")) contadorNull++;
            } // for

        } // for

        System.out.println("Apariciones globales OK: " + contadorOK);
        System.out.println("Apariciones globales NULL: " + contadorNull);
        System.out.println("Apariciones globales ERROR: " + contadorERROR);

        // Cerrar los escáners: 

        ent_num.close();
        ent_txt.close();

    } // main

    // Métodos personalizados

} // class