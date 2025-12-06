package com.example.dinamic_form.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// Importar dependencias: 


// Class
@Getter @Setter
public class FormContact {

    // Declaración de atributos: 

    @NotBlank(message = "El campo nombre no puede estar vacío.")
    private String nombre;
    
    @Email(message = "El campo email no tiene el formato correcto")
    @NotBlank(message = "El campo email debe de tener algún valor asignado")
    private String email;

    @NotBlank(message = "El mensaje que nos quieres enviar no puede estar vacío.")
    private String mensaje;

    // Constructor

    public FormContact() {
        this.nombre = "";
        this.email = "";
        this.mensaje = "";
    }

    public FormContact(String n, String e, String m) {
        this.nombre = n;
        this.email = e;
        this.mensaje = m;
    }

    // Métodos personalizados: 
    
}