package com.example.p1.model;

// Importar dependencias: 

import java.util.HashMap;

// Class

public class FormEntry {
    
    // Declaración de atributos: 

    private String name;
    private String type;
    private String label;
    private String placeholder;

    // Constructores: 

    public FormEntry() {
        this.name = "";
        this.type = "";
        this.label = "";
        this.placeholder = "";
    }

    // Getters and Setters

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    // Métodos personalizados: 

} // class