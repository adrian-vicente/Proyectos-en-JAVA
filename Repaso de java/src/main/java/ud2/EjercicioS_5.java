package main.java.ud2;

// Importar dependencias: 

import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 
 * @author Adrián Vicente Vera
 * @since 05/10/2025
 * Ejercicio S_5
 * 
 */

// Clase 

public class EjercicioS_5 {

    // Variables globales

    public static Scanner ent_txt = new Scanner(System.in);
    public static Scanner ent_num = new Scanner(System.in);

    // Método main 

    public static void main(String[] args) {
        
        // Declaración de variables: 

        LinkedList<String> listaUsuarios = new LinkedList<>(); ListIterator<String> li = null;
        String nombre = new String(" "), nombreLista = new String(" "); String nuevaPalabra = new String(" ");
        char caracterInicial = ' '; char[] vCaracteresNombre = null; char caracterVector = ' ';
        boolean empezarConLetra = false, longitudCorrecta = false, sinEspacios = false, soloCaracteresAlfanumericos = false;
        int longitudMaxima = 0, longitudMinima = 0;

        // Recoger 5 nombres

        do {
            System.out.println("Introduce un nombre: ");
            nombre = ent_txt.nextLine();
            listaUsuarios.add(nombre);

        } while(listaUsuarios.size() <= 5);

        // Mostrar los 5 nombres:

        li = listaUsuarios.listIterator();
        while(li.hasNext()) {
            System.out.println("Nombre: " + li.next());
        } // while

        // Validar los 5 nombres: 

        li = listaUsuarios.listIterator();
        while(li.hasNext()) {

            // Recoger elemento de la lista y añadirlo a una variable: 

            nombreLista = li.next();

            // El nombre empieza por una letra

            caracterInicial = nombreLista.charAt(0);
            if(Character.isLetter(caracterInicial)) {
                System.out.println("El nombre empieza por una letra. Validación superada. ");
                empezarConLetra = true;

            } else {
                System.out.println("El nombre no empieza por una letra. Validación no superada.");
                empezarConLetra = false;

            } // else

            // El nombre tiene entre 5 y 12 carácteres

            longitudMinima = 5; longitudMaxima = 12;
            if(nombreLista.length() >= 5 && nombreLista.length() <= 12) {
                System.out.println("El nombre tiene el rango necesario. Validación superada.");
                longitudCorrecta = true;

            } else {
                System.out.println("El nombre no tiene el rango de carácteres requerido. Validación no superada. ");
                longitudCorrecta = false;

            } // else

            // El nombre no tiene espacios

            if(!(nombreLista.contains(" "))) {
                System.out.println("El nombre no contiene espacios. Validación superada.");
                sinEspacios = true;

            } else {
                System.out.println("El nombre contiene espacios. Validación no superada.");
                sinEspacios = false;

            } // else
            
            // Solo tiene carácteres alfanuméricos

            vCaracteresNombre = nombreLista.toCharArray();
            for(int i = 0; i < vCaracteresNombre.length; i++) {
                caracterVector = vCaracteresNombre[i];
                if(!(Character.isLetterOrDigit(caracterVector))) soloCaracteresAlfanumericos = true;
                else soloCaracteresAlfanumericos = false;

            } // for

            if(soloCaracteresAlfanumericos) System.out.println("El nombre solo tiene carácteres alfanuméricos. Validación superada.");
            else System.out.println("El nombre contiene carácteres alfanuméricos. Validación no superada.");

            // Correciones de las validaciones no superadas: 

            if(!empezarConLetra) {
                System.out.println("Nombre actual con fallos: " + nombreLista);
                System.out.println("Versión sugerida: " + nombreLista.replace(caracterInicial, 'A'));

            } else if (!longitudCorrecta) {

            } else if (!sinEspacios) {
                System.out.println("Nombre actual con fallos: " + nombreLista);
                System.out.println("Versión sugerida: " + nombreLista.trim());

            } else if (!soloCaracteresAlfanumericos) {
                for(int i = 0; i < vCaracteresNombre.length; i++){
                    if(!(Character.isLetterOrDigit(vCaracteresNombre[i]))) {
                        vCaracteresNombre[i] = 'A';

                    } else continue;

                } // for

                for(int o = 0; o < vCaracteresNombre.length; o++) nuevaPalabra = nuevaPalabra +  String.valueOf(vCaracteresNombre[o]);

                // Versión sugerida: 

                System.out.println("Versión actual: " + nombreLista);
                System.out.println("Versión sugerida: " + nuevaPalabra);

            } // else if

        } // while

        // Cerrar los escáners: 

        ent_txt.close();
        ent_num.close();

        // Mensjes: 

        System.out.println("Final del programa...");

    } // main

    // Métodos personalizados:

} // class