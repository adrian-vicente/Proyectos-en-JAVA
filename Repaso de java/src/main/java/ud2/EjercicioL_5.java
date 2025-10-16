package ud2;

// Importar dependencias: 

import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 
 * @author Adrián Vicente Vera
 * @since 04/10/2025
 * Ejercicio: L_5  
 *  
 */

// Class

public class EjercicioL_5 {
    
    // Variables globales: 

    public static Scanner ent_txt = new Scanner(System.in);
    public static Scanner ent_num = new Scanner(System.in);

    // Método main

    public static void main(String[] args) {

        // Declaración de variables: 

        String[] resultado = new String[2];
        LinkedList<String[]> listaResultados = new LinkedList<String[]>();
        String ganador = ""; int partidasGanadas = 0;

        // Generar varios resultados:

        do {
            
            // Recogida de datos:
            
            System.out.println("Introduce el nombre del ganador: ");
            resultado[0] = ent_txt.nextLine();

            System.out.println("Introduce el nombre del perdedor: ");
            resultado[1] = ent_txt.nextLine();

            // Añadir los datos a la lista: 

            listaResultados.add(resultado);

            // Reiniciar el valor de la variable: 

            resultado = new String[2];

        } while(listaResultados.size() < 2);

        // Imprimir el tamaño de la lista por comprobación: 

        System.out.println("Resultados guardados actualmente: " + listaResultados.size());

        // Mostrar lista de jugadores únicos sin repetir 

        LinkedList<String> listaNoRepetidos = new LinkedList<String>();
        for(int i = 0; i < listaResultados.size(); i++) {
            String jugador1 = listaResultados.get(i)[0];
            String jugador2 = listaResultados.get(i)[1];
            if(!listaNoRepetidos.contains(jugador1)) listaNoRepetidos.add(jugador1);
            if(!listaNoRepetidos.contains(jugador2)) listaNoRepetidos.add(jugador2);
        }

        ListIterator<String> li = listaNoRepetidos.listIterator();
        while(li.hasNext()) {
            System.out.println("Jugador: " + li.next());

        } // while

        // Mostrar el número de victorias para cada jugador

        for(int i = 0; i < listaResultados.size(); i++) {
            ganador = listaResultados.get(i)[0];
            partidasGanadas = 0;
            for(int j = 0; j < listaResultados.size(); j++) {
                if(ganador.equals(listaResultados.get(j)[0])) partidasGanadas++;

            } // for

            System.out.println("Ganador: " + ganador + ", partidas ganadas: " + partidasGanadas);

            /**
             * 
             * Se muestra el número de victorias para cada jugador. Si el jugador no ha ganado nada no las mostraré
             * 
             * 
             */

        } // for

        // Cerrar el escáner

        ent_txt.close();
        ent_num.close();

        // Final del programa

        System.out.println("Final del programa...");

    } // main

    // Métodos personalizados

} // class