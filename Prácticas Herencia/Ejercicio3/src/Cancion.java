// Importar dependencias: 

import java.util.Scanner;

// Class

public class Cancion {

    // Declaración de constantes: 

    private final static double DURACION_MAXIMA = 600;
    private final static double DURACION_MINIMA = 10;
    private final static int CARACTERES_MAXIMOS = 50;

    // Declaración de atributos: 

    private String titulo;
    private String artista;
    private double duracion;

    // Constructor: 

    public Cancion() {
        this.titulo = "";
        this.artista = "";
        this.duracion = 0.0d;

    }

    public Cancion(String titulo, String artista, double duracion) {
        this.titulo = titulo; 
        this.artista = artista;
        this.duracion = duracion;
    }

    // Getters and Setters

    public String getArtista() {
        return artista;
    }

    public double getDuracion() {
        return duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public boolean setDuracion(double duracion) {
        if(duracion >= Cancion.DURACION_MINIMA && duracion <= Cancion.DURACION_MAXIMA) {
            this.duracion = duracion;
            return true; 

        } else return false;

    } // setDuracion()

    public boolean setTitulo(String titulo) {
        if(titulo.length() <= Cancion.CARACTERES_MAXIMOS) {
            this.titulo = titulo;
            return true;

        } else return false;

    } // setTitulo

    // Métodos personalizados: 

    @Override
    public String toString() {
        return "Nombre de la canción: " + this.getTitulo() + ", artista: " + this.getArtista() + ", duración en segundos: " + this.getDuracion();

    } // toString()
    
    public void leerCancion(Scanner ent_txt, Scanner ent_num) {
        
        // Declaración de variables: 

        boolean tituloValido = false, duracionValida = false;

        // Recogida de datos: 
        
        System.out.println("Introduce el nombre del artista: ");
        this.setArtista(ent_txt.nextLine());

        // Título: 

        do {
            System.out.println("Introduce el título de la canción: ");
            tituloValido = this.setTitulo(ent_txt.nextLine());

        } while(!tituloValido);

        // Duración: 

        do {
            System.out.println("Introduce la duración de la canción: ");
            duracionValida = this.setDuracion(ent_num.nextDouble());

        } while(!duracionValida);

    } // leerCancioN

    public int compareTo(Cancion cancionNueva) {
        if(this.getDuracion() > cancionNueva.getDuracion()) return 1;
        else if (this.getDuracion() == cancionNueva.getDuracion()) return 0;
        else return -1;

    } // compareTo

} // class