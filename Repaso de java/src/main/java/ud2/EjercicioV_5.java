package ud2;

// Importar dependencias: 

import java.util.Scanner;
import java.util.Random;
import main.java.ud2.Usuario;

/**
 * 
 * @author Adrián Vicente Vera
 * @since 04/10/2025
 * Ejercicio V_5
 * 
 */

// Class

public class EjercicioV_5 {

    // Variables globales: 

    public static Scanner ent_txt = new Scanner(System.in);
    public static Scanner ent_num = new Scanner(System.in);

    // Método main

    public static void main(String[] args) {

        // Declaración de variables: 

        Usuario[] vUsuarios_1 = new Usuario[5];
        Usuario[] vUsuarios_2 = new Usuario[5];
        Usuario usuario = null;
        int opcion = 0; boolean continuar = true;

        String nombreUsuario = ""; int contrasena = 0;
        boolean sesionIniciada = false;

        // Rellenar los datos del vector

        for(int i = 0; i < vUsuarios_1.length; i++) {
            usuario = new Usuario();
            usuario.leerUsuario(ent_txt);
            vUsuarios_1[i] = usuario;

        }

        for(int i = 0; i < vUsuarios_2.length; i++) {
            usuario = new Usuario();
            usuario.leerUsuario(ent_txt);
            vUsuarios_2[i] = usuario;

        }

        // Imprimir información de los vectores por comprobación: 

        System.out.println("Longitud vector 1: " + vUsuarios_1.length);
        System.out.println("Longitud vector 2: " + vUsuarios_2.length);

        // Parte del código en el que modifico una contraseña para poder comprobar que el resto del código me funciona

        vUsuarios_1[0].setContrasena(1);

        // Prueba de iniciar sesión: 

        while(!sesionIniciada && nombreUsuario != "fin") {
            for(int i = 0; i < vUsuarios_1.length; i++) {
            System.out.println("Introduce el nombre del usuario ");
            nombreUsuario = ent_txt.nextLine(); 
            
            // Salir del bucle evitando una ejecución innecesaria: 

            if(nombreUsuario.equalsIgnoreCase("fin")) break;

            System.out.println("Introduce la contraseña: ");
            contrasena = ent_num.nextInt(); 

            // Comprobar la contraseña: 

            if(nombreUsuario.equalsIgnoreCase(vUsuarios_1[i].getNombre()) && contrasena == vUsuarios_1[i].getContrasena()) {
                sesionIniciada = true;
                System.out.println("Sesión inicada");
                usuario = vUsuarios_1[i];
                break;

            } else System.out.println("Credenciales incorrectas ");

        } // for

        for(int i = 0; i < vUsuarios_2.length && !sesionIniciada; i++) {
            System.out.println("Introduce el nombre de usuario");
            nombreUsuario = ent_txt.nextLine();
            if(nombreUsuario.equalsIgnoreCase("fin")) break;

            System.out.println("Introduce las credenciales");
            contrasena = ent_num.nextInt();

            // Compobaciones: 

            if(nombreUsuario.equalsIgnoreCase(vUsuarios_2[i].getNombre()) && contrasena == vUsuarios_2[i].getContrasena()) {
                sesionIniciada = true;
                System.out.println("Sesión iniciada");
                usuario = vUsuarios_2[i];
                break;

            } else System.out.println("Credenciales incorrectas");

        } // for

        } // while

        // Inicio de la aplicación 

        while(continuar) {
            imprimirMenu();
            opcion = ent_num.nextInt();
            switch(opcion) {

                case 0: 
                case 1:
                    continuar = false; 
                    break; 

                case 2: 
                    modificarContrasena(usuario);
                    break;

                default: 
                    continuar = false;
                    break;

            } // switch
            
        } // while

        // Final de la aplicación

        // Cerrar el escáner 

        ent_txt.close();
        ent_num.close();

        // Mensajes: 

        System.out.println("Final del programa...");

    } // método main

    // Métodos personalziados: 

    public static void imprimirMenu() {
        System.out.println("Elige una opción: ");
        System.out.println("0. Salir");
        System.out.println("1. Cerrar sesión");
        System.out.println("2. Cambiar contraseña actual");

    } // imprimirMenu()

    public static void modificarContrasena(Usuario usuario) {
        int contrasenaActual = usuario.getContrasena();
        System.out.println("Introduce la nueva contraseña: ");
        usuario.setContrasena(ent_num.nextInt());
        if(contrasenaActual != usuario.getContrasena()) {
            System.out.println("Contrasena modificada. ");

        } else System.out.println("Aunque es la misma contrasena, cuenta cómo modificada. (No recomendable jejeje)");

    } // Usuario()

} // class