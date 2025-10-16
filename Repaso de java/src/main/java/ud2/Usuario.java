package main.java.ud2;

// Importar dependencias: 

import java.util.Scanner;
import java.util.Random;

// Clase 

public class Usuario {

    // Declaración de atributos: 

    private String nombre; 
    private int contrasena;
    private final static Random RAND = new Random();

    // Constructores

    public Usuario() {
        this.nombre = "";
        this.contrasena = 0;

    }

    public Usuario(String nombre, int contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;

    }

    // Getters and Setters

    public int getContrasena() {
        return contrasena;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos personalizados: 

    public void leerUsuario(Scanner ent_txt) {
        System.out.println("Introduce el nombre de usuario: ");
        this.setNombre(ent_txt.nextLine());
        generarContrasena();

    } // leerUsuario

    private void generarContrasena() {

        // Declaración de variables: 

        int min = 1;
        int max = 5;
        int numeroGenerado = RAND.nextInt() * (max -  min + 1) + min;
        this.setContrasena(numeroGenerado);
        
    } // generarContrasena()

    @Override
    public String toString() {
        return "Nombre de usuario: " + this.getNombre() + ", password: " + this.getContrasena();
    }

} // usuario() (Clase)