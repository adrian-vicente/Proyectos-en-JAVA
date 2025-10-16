package ud2;

// Importar dependencias: 

import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * @author Adrián Vicente Vera
 * @since 04/10/2025
 * Ejercicio H_5s
 * 
 */

// Class

public class EjercicioH_5 {

    // Variables globales: 

    public static Scanner ent_txt = new Scanner(System.in);
    public static Scanner ent_num = new Scanner(System.in);
    public static Random rand = new Random();

    // Método main

    public static void main(String[] args) {
    
        // Declaración de variables:

        HashMap<Integer, HashMap<Integer, Integer>> puntuaciones = new HashMap<>();
        int numeroPuntuacion = 0, numeroPreguntas = 10, numeroUsuarios = 0;
        int numeroDePregunta = 0; int acumuladorPuntuaciones = 0;
        boolean existePregunta = false;
        double media = 0.0d;

        // Declarar e inicializar la estructura con valores enteros aleatorios:
        
        for(int i = 1; i <= 10; i++) {
            // Generar el hash map de las puntuaciones internas: 

            HashMap<Integer, Integer> submapa = new HashMap<>();

            // Rellenar las puntuaciones internas: 

            for(int j = 1; j <= 5; j++) submapa.put(j, rand.nextInt(10) + 1);

            // Añadir al hash map del valor actual el hash map interior ya rellenado

            puntuaciones.put(i, submapa);
            
        } // for

        // Por comprobación imprimir el tamaño del hash map

        System.out.println("Tamaño actual del hash map: " + puntuaciones.size());

        // Pedir al usuario número de pregunta: 

        System.out.println("Introduce un número de pregunta: ");
        numeroDePregunta = ent_num.nextInt();
        existePregunta = validarPregunta(numeroDePregunta, puntuaciones);

        // Validar el número de pregunta (Pensé que es una buena práctica)

        if(existePregunta) {

            // Declaración de variables: 

            String asteriscos = "";
            HashMap<Integer, Integer> submapa = puntuaciones.get(numeroDePregunta);

            // Imprimir número de pregunta: 

            System.out.println("Pregunta: " + numeroDePregunta);

            // Acumular el valor de los asteriscos y mostrarlos

            for(Integer clave : submapa.keySet()) {
                int numeroRespuestasDeUsuarios = submapa.get(clave);
                int incrementoNumeroMedia = 1;
                media = media + (incrementoNumeroMedia * numeroRespuestasDeUsuarios);
                acumuladorPuntuaciones = acumuladorPuntuaciones + numeroRespuestasDeUsuarios;

                asteriscos = "";
                for(int k = 1; k <= numeroRespuestasDeUsuarios; k++) asteriscos += "*";

                // Mostrar el resultado: 

                System.out.println(clave + ": " + asteriscos);

            } // for

            // Calcular la media: 

            media = media / acumuladorPuntuaciones;
            System.out.println("Media de las puntuaciones: " + media);

        } else {
            System.out.println("La pregunta no existe. ");
            return;

        } // else

        // Mensajes: 

        System.out.println("Final del programa...");

    } // main

    // Métodos personalizados: 

    public static boolean validarPregunta(int numPreg, HashMap<Integer, HashMap<Integer, Integer>> puntuaciones) {
        if(puntuaciones.containsKey(numPreg)) return true;
        else return false;

    } // validarPregunta
    
} // class