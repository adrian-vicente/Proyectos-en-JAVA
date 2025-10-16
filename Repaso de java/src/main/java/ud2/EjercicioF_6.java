package ud2;

// Importar dependencias: 

import java.util.Scanner; 
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * 
 * @author Adrián Vicente Vera
 * @since 04/10/2025
 * Ejercicio F_6
 * 
 */

public class EjercicioF_6 {

    // Variables globales: 

    public static Scanner ent_txt = new Scanner(System.in);
    public static Scanner ent_num = new Scanner(System.in);

    // Método main

    public static void main(String[] args) {
        
        // Declaración de variable

        Alumno alu1 = new Alumno();
        Alumno alu2 = new Alumno();
        alu1.leerAlumno(ent_txt, ent_num);
        alu2.leerAlumno(ent_txt, ent_num);
        LinkedList<Alumno> lista = new LinkedList<>();
        lista.add(alu1); lista.add(alu2);
        int op = 0;
        boolean continuar = true;

        // Inicio APP

        while(continuar) {
            imprimirMenu(); 
            op = ent_num.nextInt();
            switch(op) {
                case 0:
                default:
                    continuar = false;
                    break;

                case 1:
                    // Listar alumnos con media mayor o igual a 9
                    listadoAlumnosMediaNueve(lista);
                    break;

                case 2:
                    // Alumno con mayor variabilidad de nota
                    alumnoVariabilidadNota(lista);
                    break;

            } // switch

        } // while

        // Final APP

        // Cerrar los escáners

        ent_txt.close();
        ent_num.close();

        // Mensajes

        System.out.println("Final del programa...");

    } // main

    // Métodos personalizados: 

    public static void imprimirMenu() {
        System.out.println("Introduce una opción: ");
        System.out.println("0. Salir");
        System.out.println("1. Listado de alumnos con media superior a 9");
        System.out.println("2. Alumno con mayor variabilidad de notas");

    }

    public static void listadoAlumnosMediaNueve(LinkedList<Alumno> lista) {

        // Declaración de variables: 

        ListIterator<Alumno> li = lista.listIterator();

        // Recorrer el lista iterator: 

        while(li.hasNext()) {

            // Asociar el elemento del list iterator de la lista a una variable de tipo objeto

            Alumno aluLista = li.next();    

            // Declarar variables para calcular la media

            double acumuladorNotas = aluLista.getNota1() + aluLista.getNota2() + aluLista.getNota3() + aluLista.getNota4() + aluLista.getNota5();
            double media = acumuladorNotas / 5;

            // Comprobaciones sobre la media

            if(media >= 9) {
                System.out.println("Alumno: " + aluLista.getNombre());

            } // if
            
        } // while

    } // listadoAlumnosMediaNueve

    public static void alumnoVariabilidadNota(LinkedList<Alumno> lista) {

        // Declaración de variables: 

        double diferenciaNota = 0;
        double notaActual = 0.0d;
        ListIterator<Alumno> liAlumnos = lista.listIterator();
        String nombreAlumno = "";
        double mayorDiferencia = 0.0d;

        // Recorrer el LI: 

        while(liAlumnos.hasNext()) {
            Alumno alu = liAlumnos.next();
            double[] vNotas = { alu.getNota1(), alu.getNota2(), alu.getNota3(), alu.getNota4(), alu.getNota5()};
            double notaMasAlta = vNotas[0];
            double notaMasBaja = vNotas[0];

            // Asignar la nota más alta y la más baja: 

            for(int i = 0; i < vNotas.length; i++) {
                notaActual = vNotas[i];
                if(notaActual > notaMasAlta) notaMasAlta = notaActual;
                if(notaActual < notaMasBaja) notaMasBaja = notaActual;

            } // for

            // Calculo de varabilidad: 

            diferenciaNota = notaMasAlta - notaMasBaja;

            // Comprobaciones

            if(diferenciaNota > mayorDiferencia) {
                mayorDiferencia = diferenciaNota;
                nombreAlumno = alu.getNombre();

            } // if

        } // while

        // Imprimir información: 

        System.out.println("Alumno con mayor variabilidad: " + nombreAlumno + ", con una variabilidad de: " + mayorDiferencia);

    } // alumnoVariabilidadNota

} // class