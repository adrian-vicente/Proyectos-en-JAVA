
// Importar dependencias: 

import java.util.LinkedList;
import java.util.Scanner;

// Class

public class AppMain {

    // Variables globales: 

    public static Scanner ent_txt = new Scanner(System.in);
    public static Scanner ent_num = new Scanner(System.in);

    // Método main 

    public static void main(String[] args) {
        
        // Declaración de variables: 

        Cancion cancionPrueba = new Cancion();
        Album albumPrueba = new Album();

        // Recogida de datos: 

        System.out.println("Proceso de creación de una canción: ");
        cancionPrueba.leerCancion(ent_txt, ent_num);

        System.out.println("Proceso de creación de un album: ");
        albumPrueba.leerAlbum(ent_txt, ent_num);

        // Mostrar la información de la canción generada: 

        System.out.println("Información de la canción a texto: " );
        System.out.println(cancionPrueba.toString());

        // Mostrar la información de un album generado: 

        System.out.println("Información de un álbum: " );
        System.out.println(albumPrueba.toString());

        // Canciones superiores a 5 minutos: 

        LinkedList<Cancion> cancionesLargas = albumPrueba.getCancionesLargas();
        if(cancionesLargas == null || cancionesLargas.isEmpty()) {
            System.out.println("Puede que no existan canciones o que ninguna sea superior a 5 minutos...");

        } else {
            System.out.println("Canciones superiores a 5 minutos: ");
            for(int i = 0; i < cancionesLargas.size(); i++) {
                Cancion cancionLista = cancionesLargas.get(i);
                System.out.println(cancionLista.toString());

            } // for

        } // if - else

        // Comparación de la duración de dos canciones: 

        System.out.println("Proceso para comparar dos canciones: ");
        Cancion nuevaCancion = new Cancion();
        nuevaCancion.leerCancion(ent_txt, ent_num);
        int resultado = cancionPrueba.compareTo((nuevaCancion));
        if(resultado == 1) System.out.println("La canción: " + cancionPrueba.getTitulo() + " tiene una mayor duración.");
        else if (resultado == -1) System.out.println("La canción: " + nuevaCancion.getTitulo() + " tiene una mayor duración.");
        else System.out.println("Ambas canciones tienen la misma duración...");

        // Duración total de las canciones de un álbum: 

        System.out.println("Proceso para saber la duración total del álbum: ");
        double duracionTotal = albumPrueba.getDuracionAlbum();
        if(duracionTotal == 0.0d) {
            System.out.println("No habían canciones registradas. Duración: " + duracionTotal);

        } else System.out.println("Duración total del álbum: " + duracionTotal);
        
        // Canción más corta y más larga: 

        System.out.println("Canción más corta y más larga: ");
        Cancion masCorta = albumPrueba.getCancionCorta();
        Cancion masLarga = albumPrueba.getCancionLarga();

        if(masCorta == null || masLarga == null ){
            System.out.println("No se ha podido encontrar las canciones...");

        } else {
            System.out.println("Canción más corta: " + masCorta.getTitulo());
            System.out.println("Canción más larga: " + masLarga.getTitulo());

        } // if - else

        // Seleccionar canción de manera aleatoria: 

        Cancion cancionAleatoria = albumPrueba.getCancionAleatoria();
        if(cancionAleatoria != null) {
            System.out.println(cancionAleatoria.toString());

        } // if

        // Mensajes: 

        System.out.println("Final del programa...");

        // Cerrar los escáners: 

        ent_num.close();
        ent_txt.close();

    } // main

    // Métodos personalizados

} // class