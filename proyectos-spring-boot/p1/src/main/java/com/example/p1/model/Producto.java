package com.example.p1.model;

// Importar dependencias: 

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

// Class

public class Producto {
 
    // Declaración de atributos: 

    private String nombre;
    private Double precio;
    private String material;
    private int id;

    // Declaración de atributos estáticos:

    private static int contador = 0;
    public static LinkedList<Producto> lista_productos = new LinkedList<>(
            List.of(
                    new Producto("Mesa de comedor", "Madera maciza", 249.99),
                    new Producto("Silla ergonómica", "Plástico y metal", 89.90),
                    new Producto("Lámpara de pie", "Acero inoxidable", 59.95),
                    new Producto("Estantería modular", "Madera MDF", 129.50),
                    new Producto("Espejo decorativo", "Cristal y aluminio", 39.99),
                    new Producto("Alfombra suave", "Fibras sintéticas", 45.00),
                    new Producto("Cama doble", "Madera de roble", 399.00),
                    new Producto("Sofá 3 plazas", "Tela y espuma", 699.90),
                    new Producto("Mesa auxiliar redonda", "Cristal templado", 79.99),
                    new Producto("Taburete alto", "Metal y cuero sintético", 65.40)));

    // Constructores

    public Producto() {
        this.nombre = "";
        this.material = "";
        this.precio = 0.0d;
        this.id = ++contador;
    }

    public Producto(String nombre, String material, Double precio) {
        this.nombre = nombre;
        this.material = material;
        this.precio = precio;
        this.id = ++contador;
    }

    // Getters and Setters

    public String getMaterial() {
        return material;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    // Métodos personalizados: 

    @Override
    public String toString() {
        return "Nombre del producto: " + this.getNombre() + ", material: " + this.getMaterial() + ", precio: " + this.getPrecio() + "€";
    }
    
    public LinkedList<Producto> getDestacados() {
        LinkedList<Producto> destacados = new LinkedList<Producto>();
        destacados.add(Producto.lista_productos.get(new Random().nextInt(1, Producto.lista_productos.size())));
        destacados.add(Producto.lista_productos.get(new Random().nextInt(1, Producto.lista_productos.size())));
        destacados.add(Producto.lista_productos.get(new Random().nextInt(1, Producto.lista_productos.size())));
        destacados.add(Producto.lista_productos.get(new Random().nextInt(1, Producto.lista_productos.size())));
        return destacados;
    }

}