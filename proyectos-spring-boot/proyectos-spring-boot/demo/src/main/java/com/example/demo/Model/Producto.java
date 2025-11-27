package com.example.demo.Model;

// Class

public class Producto {

    // Declaración de atributos: 

    private String nombre;
    private String categoria;
    private Double precio;

    // Declaración de atributos estáticos para el placeholder del producto: 

    public final static String NOMBRE_PH = "Introduce el nombre del producto";
    public final static String CATEGORIA_PH = "Introduce la categoría del producto";
    public final static String PRECIO_PH = "Introduce el precio del producto. Valor en €";

    // Constructores:

    public Producto() {
        this.nombre = "";
        this.categoria = "";
        this.precio = 0.0d;
    }

    // Getters and Setters

    public String getCategoria() {
        return categoria;
    }
    
    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    // Métodos personalizados: 

    @Override
    public String toString() {
        return "Nombre del producto: " + this.getNombre() + ", categoría: " + this.getCategoria() + ", precio: " + this.getPrecio() + "€";

    } // toString()

} // class