package com.example;

// Importar dependencias: 

import java.util.Scanner;

import com.google.gson.annotations.SerializedName;

// Class

public class Usuario {

    // Declaración de atributos: 

    @SerializedName("nombre")
    private String nombre;
    
    @SerializedName("email")
    private String email;
    
    @SerializedName("rol")
    private String rol;

    // Constructores: 

    public Usuario() {
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public Usuario(String n, String e, String r) {
        this.nombre = n;
        this.email = e;
        this.rol = r;
    }

    // Getters and Setters

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Métodos personalizados: 

    public void leerUsuario(Scanner ent_txt, Scanner ent_num) {
        System.out.println("Introduce el nombre del usuario: ");
        this.setNombre(ent_txt.nextLine());
        System.out.println("Introduce el email del usuario: ");
        this.setEmail(ent_txt.nextLine());
        System.out.println("Introduce el rol del usuario: ");
        this.setRol(ent_txt.nextLine());

    } // leerUsuario()

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nombre del usuario: " + this.getNombre() + ", email: " + this.getEmail() + ", rol: " + this.getEmail();
    }

} // class