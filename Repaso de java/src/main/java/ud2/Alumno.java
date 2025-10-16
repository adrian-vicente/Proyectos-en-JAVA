package ud2;

import java.io.ObjectInputStream.GetField;

// Importar dependencias: 

import java.util.Scanner;

// Class

public class Alumno {

    // Declaración de atributos: 

    private String nombre;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private double nota5;

    // Constructores: 

    public Alumno() {
        this.nombre = "";

    }

    public Alumno(String nombre, double n1, double n2, double n3, double n4, double n5) {
        this.nombre = nombre;
        this.nota1 = n1;
        this.nota2 = n2;
        this.nota3 = n3;
        this.nota4 = n4;
        this.nota5 = n5;
    }

    // Getters and Setters: 

    public String getNombre() {
        return nombre;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public double getNota5() {
        return nota5;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public void setNota5(double nota5) {
        this.nota5 = nota5;
    }

    // Métodos personalizados: 

    public void leerAlumno(Scanner ent_txt, Scanner ent_num) {
        System.out.println("Introduce el nombre del alumno: ");
        this.setNombre(ent_txt.nextLine());

        System.out.println("Introduce la nota1: ");
        this.setNota1(ent_num.nextDouble());

        System.out.println("Introduce la nota2: ");
        this.setNota2(ent_num.nextDouble());

        System.out.println("Introduce la nota3: ");
        this.setNota3(ent_num.nextDouble());

        System.out.println("Introduce la nota4: ");
        this.setNota4(ent_num.nextDouble());

        System.out.println("Introduce la nota5: ");
        this.setNota5(ent_num.nextDouble());

    } // leerAlumno

} // class