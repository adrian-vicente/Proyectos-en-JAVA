package com.example.dinamic_form.model;

// Importar dependencias:

import lombok.Getter;
import lombok.Setter;

// Class

@Getter @Setter
public class FormEntry {
 
    // Declaración de atributos: 

    private String name;
    private String type;
    private String label;

    // Constructor: 

    public FormEntry() {
        this.name = "";
        this.type = "";
        this.label = "";

    }

    public FormEntry(String n, String t) {
        this.name = n;
        this.type = t;
        this.label = this.name.toUpperCase().charAt(0) + this.name.toUpperCase().substring(1).concat(":");
    }

    // Métodos personalizados: 
    
}