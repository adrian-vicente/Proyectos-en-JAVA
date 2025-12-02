package com.example.p1.model;

import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

// Class

public class FormContact {
    
    // Declaración de atributos: 

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String nombre;

    @NotBlank(message = "El email no puede quedarse vacío.")
    @Email(message = "El email debe de tener el formato correcto.")
    private String email;

    @NotBlank(message = "El mensaje debe tener contenido. No puede estar vacío.")
    private String mensaje;

    // Constructores

    public FormContact() {
        this.nombre = "";
        this.email = "";
        this.mensaje = "";
    }

    // Getters and Setters

    public String getEmail() {
        return email;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos personalizados:

    @Override
    public String toString() {
        return "Nombre: " + this.getNombre() + ", email: " + this.getEmail() + ", mensaje: " + this.getMensaje();
    }

} // class