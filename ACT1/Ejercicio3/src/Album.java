
// Importar dependencias: 

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Random;

import javax.smartcardio.Card;

// Class

public class Album {

    // Declaración de atributos: 

    private String nombre;
    private LinkedList<Cancion> lista;

    // Constructores

    public Album() {
        this.nombre = "";
        this.lista = new LinkedList<Cancion>();
    }

    public Album(String nombre, LinkedList<Cancion> lista) {
        this.nombre = nombre;
        this.lista = lista;

    }

    // Getters and Setters: 

    public LinkedList<Cancion> getLista() {
        return lista;
    }

    public String getNombre() {
        return nombre;
    }

    public LinkedList<Cancion> getCancionesLargas() {
        
        // Declaración de variables: 

        LinkedList<Cancion> listaCancionesLargas = new LinkedList<>();

        // Recogida de información: 

        if(this.getLista() == null || this.getLista().isEmpty()) {
            System.out.println("No hay canciones guardas todavía...");
            return null;

        } else {
            for(int i = 0; i < this.getLista().size(); i++) {
                Cancion cancionLista = this.getLista().get(i);
                if(cancionLista.getDuracion() >= 300) {
                    listaCancionesLargas.add(cancionLista);

                }

            } // for

            // Devolver la lista con las canciones añadadidas: 

            return listaCancionesLargas;

        } // if - else

    } // getCancionesLargas()

    public double getDuracionAlbum() {
        double duracion = 0.0d;
        if(this.getLista() != null || !this.getLista().isEmpty()) {
            for(int i = 0; i < this.getLista().size(); i++) {
                duracion = duracion + this.getLista().get(i).getDuracion();

            } // for

            // Devolver el valor acumulado: 

            return duracion;

        } else {
            return 0.0d;
        } // if - else

    } // getDuracionAlbum()

    public Cancion getCancionCorta() {

        // Declaración de variables: 

        boolean albumVacio = this.albumVacio();
        double duracionMinima = Double.MAX_VALUE;
        Cancion cancionMasCorta = new Cancion();

        // Obtener la canción más corta: 

        if(albumVacio || this.getLista().size() < 1) {
            System.out.println("No hay canciones guardadas en este momento o no hay suficientes canciones");
            return null;

        } else {
            for(int i = 0; i < this.getLista().size(); i++) {
                Cancion cancionLista = this.getLista().get(i);
                if(cancionLista.getDuracion() < duracionMinima) {
                    duracionMinima = cancionLista.getDuracion();
                    cancionMasCorta = cancionLista;

                } else continue;

            } // for

            // Devolver la canción más corta encontrada: 

            return cancionMasCorta;

        } // if - else

    } // getCancionCorta()

    public Cancion getCancionLarga() {

        // Declaración de variables: 

        boolean albumVacio = this.albumVacio();
        double duracionMaxima = Double.MIN_VALUE;
        Cancion cancionMasLarga = new Cancion();

        // Obtener la canción más larga: 

        if(albumVacio || this.getLista().size() < 1) {
            System.out.println("No hay canciones guardadas en este momento o no hay suficientes.");
            return null;

        } else {
            for(int i = 0; i < this.getLista().size(); i++) {
                Cancion cancionLista = this.getLista().get(i);
                if(cancionLista.getDuracion() > duracionMaxima) {
                    duracionMaxima = cancionLista.getDuracion();
                    cancionMasLarga = cancionLista;

                } // if

            } // for

            // Devolver la canción más larga encontrada: 

            return cancionMasLarga;

        } // if - else

    } // getCancionLarga()

    public Cancion getCancionAleatoria() {

        // Declaración de variables: 

        Random rand = new Random();
        Cancion cancionAleatoria = null;

        // Seleccionar canción aleatoriamente

        if(this.getLista() == null || this.getLista().isEmpty()) {
            System.out.println("No hay canciones en el álbum");
            return null;

        } else {
            int indexAleatorio = rand.nextInt(this.getLista().size());
            cancionAleatoria = this.getLista().get(indexAleatorio);
            return cancionAleatoria;

        } // if - else

    } // getCancionAleatoria()

    public void setLista(LinkedList<Cancion> lista) {
        this.lista = lista;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos personalizados: 

    public void leerAlbum(Scanner ent_txt, Scanner ent_num) {
        
        // Declaración de variables: 

        boolean continuar = true;

        // Recogida de datos:

        System.out.println("Introduce el nombre del álbum: ");
        this.setNombre(ent_txt.nextLine());

        do {
            Cancion nuevaCancion = new Cancion();
            nuevaCancion.leerCancion(ent_txt, ent_num);
            this.getLista().add(nuevaCancion);

            System.out.println("¿Quieres continuar?");
            if(!(ent_txt.nextLine().equalsIgnoreCase("si"))) continuar = false;

        } while(continuar);

    } // leerAlbum()

    public String toString() {
        String cadena = "Nombre del álbum: " + this.getNombre() + " ";
        if(this.getLista().isEmpty() || this.getLista() == null) {
            cadena = cadena + ", no hay canciones guardadas todavía.";
            return cadena;

        } else {
            for(int i = 0; i < this.getLista().size(); i++) cadena = cadena + this.getLista().get(i).toString();
            return cadena;

        } // if - else

    } // toString()

    public boolean albumVacio() {
        if(this.getLista() == null || this.getLista().isEmpty()) {
            return true;

        } else return false;

    } // albumVacio()

} // class