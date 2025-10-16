package main.java.ud2;

// Importar dependencias: 

import java.util.Scanner;

// Class

public class Producto {

    // Declaración de atributos: 

    private int codigoProducto;
    private String nombre;
    private double precio;
    private int stockDisponible;

    // Constructores

    public Producto() {
        this.nombre = "";
        this.precio = 0.0d;

    }

    public Producto(int codigo, String nombre, double pvpr, int stock) {
        this.codigoProducto = codigo;
        this.nombre = nombre;
        this.precio = pvpr;
        this.stockDisponible = stock;

    }

    // Getters and Setters

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    // Métodos personalizados: 

    public void leerProducto(Scanner ent_txt, Scanner ent_num) {

        System.out.println("Introduce el código del producto:  ");
        this.setCodigoProducto(ent_num.nextInt());

        System.out.println("Introduce el nombre del producto:  ");
        this.setNombre(ent_txt.nextLine());

        System.out.println("Introduce el precio del producto:  ");
        this.setPrecio(ent_num.nextDouble());

    } // leerProducto()

    @Override
    public String toString() {
        return "Código: " + this.getCodigoProducto() + ", nombre: " + this.getNombre() + ", precio: " + this.getPrecio() + ", stock: " + this.getStockDisponible();
        
    } // toString()

} // class