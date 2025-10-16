package main.java.ud2;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * 
 * @author Adrián Vicente
 * @since 08/10/2025
 * Ejercicio R_4
 * No poner a buscar en la carpeta C:\. Por seguridad del equipo puede dar problemas.
 * 
 */

public class EjercicioR_4 {
    
    // Variables globales: 

    public static Scanner ent_txt = new Scanner(System.in);
    public static Scanner ent_num = new Scanner(System.in);

    // Método main: 

    public static void main(String[] args) {
        
        // Declaración de variables: 

        String nombreFichero = "";
        String nombreCarpeta = "";
        File f = null;
        boolean ficheroExiste = false;

        // Recogida de datos: 

        System.out.println("Introduce la ruta de la carpeta: ");
        nombreCarpeta = ent_txt.nextLine();

        System.out.println("Introduce el nombre del fichero: ");
        nombreFichero = ent_txt.nextLine();

        // Creación del objeto file: 

        File carpeta = new File(nombreCarpeta);

        // Validar si la carpeta existe: 

        if(!validar(carpeta)) {
            System.out.println("No se ha podido validar la carpeta");
            return;

        } // validar(Carpeta)

        // Comprobar si existe el fichero: 

        ficheroExiste = comprobarFicheroExiste(carpeta, nombreFichero);
        if(!ficheroExiste) {
            System.out.println("El fichero no ha sido encontrado...");
            
        } // if

        // Mensajes: 

        System.out.println("Final del programa...");

        // Cerrar los escáners: 

        ent_txt.close();
        ent_num.close();

    } // main

    // Métodos personalizados: 

    public static boolean validar(File carpeta) {
        if(carpeta.exists()) {
            System.out.println("La carpeta existe...");
            return true; 

        } else return false;

    } // validar()

    public static boolean comprobarFicheroExiste(File carpeta, String nombreFichero) {
        
        // Guardar en un vector objetos de tipo file tanto ficheros cómo nombres
        
        File[] vectorFicheros = carpeta.listFiles();

        // Comprobaciones sobre el vector: 

        if(vectorFicheros == null) return false;

        // Recorrer el vector:

        for(File elementoVector : vectorFicheros) {
            
            // Comprobaciones: 

            if(elementoVector.isFile()) {
                // Comprobar si se correlaciona con el nombre: 
                if(elementoVector.getName().equalsIgnoreCase(nombreFichero)) {
                    System.out.println("Fichero encontrado en: " + elementoVector.getAbsolutePath());
                    return true; 

                } // if

            } else if (elementoVector.isDirectory()) {
                boolean encontrado = comprobarFicheroExiste(elementoVector, nombreFichero);
                if(encontrado) return true;

            } // else if

        } // for

        return false;

    } // comprobarFicheroExiste()

} // class