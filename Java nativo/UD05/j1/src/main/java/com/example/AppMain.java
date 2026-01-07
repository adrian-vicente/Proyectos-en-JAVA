package com.example;

// Importar dependencias:

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

// Clase main:

public class AppMain {

    // Variables globales: 

    public static Scanner ent_txt = new Scanner(System.in);
    public static Scanner ent_num = new Scanner(System.in);

    // Método main

    public static void main(String[] args) {

        // Declaración de variables: 

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Path rFichero = Paths.get("C:\\Users\\adria\\Desktop\\Carpeta ficheros\\Repaso Examen\\usuarios.json");
        Path rFicheroAdmin = Paths.get("C:\\Users\\adria\\Desktop\\Carpeta ficheros\\Repaso Examen\\usuarios_admin.json");
        
        // Comprobaciones:

        if(!Files.exists(rFichero)) {
            System.out.println("El fichero no existe, se procede a crearlo...");
            try {
                Files.createFile(rFichero);
                System.out.println("El fichero ha sido creado correctamente...");

            } catch (IOException e) {
                System.out.println("Se ha producido un error creando el fichero: " + e.getMessage());

            } // try - catch

        } else {
            System.out.println("El fichero ya existía. No es necesario crearlo...");

        } // if - else

        if(!Files.exists(rFicheroAdmin)) {
            System.out.println("El fichero no existe, se procede a crearlo...");
            try {
                Files.createFile(rFicheroAdmin);
                System.out.println("El fichero ha sido creado correctamente...");

            } catch (IOException e) {
                System.out.println("Se ha producido un error creando el fichero...");

            } // try - catch

        } else {
            System.out.println("El fichero ya existía. No es necesario crearlo....");

        } // if - else 

        // Leer el contenido del fichero: 

        leerFichero(rFichero, gson);

        // Escribir contenido en el fichero: 

        escribirFichero(rFichero, gson);

        // Exportar losa dministradores a otro fichero:

        exportarAdmin(rFichero, rFicheroAdmin, gson);

    } // main

    // Métodos personalizados:

    public static void leerFichero(Path rFichero, Gson gson) {
        BufferedReader br = null;
        try {
            String contenido = Files.readString(rFichero);
            if(Files.size(rFichero) >= 1) {
                br = new BufferedReader(new FileReader(rFichero.toAbsolutePath().toString()));
                if(contenido.startsWith("{")) {
                    Usuario usuarioFichero = gson.fromJson(br, Usuario.class);
                    System.out.println("Información del usuario: " + usuarioFichero.toString());

                } else if (contenido.startsWith("[")) {
                    Type tipoLista = new TypeToken<List<Usuario>>(){}.getType();
                    List<Usuario> lista = gson.fromJson(br, tipoLista);
                    System.out.println("Usuarios en la lista: " + lista.size());
                    for(Usuario uLista : lista) System.out.println(uLista.toString());

                } // if - else if

            } else {
                System.out.println("No se puede leer el contenido del fichero, debido a que está vacío...");
                return;

            } // if - else

        } catch (IOException e) {
            System.out.println("Se ha producido un error leyendo la información del fichero: " + e.getMessage());

        } finally {
            try {
                br.close();

            } catch (IOException e) {
                System.out.println("Se ha producido un error leyendo el fichero: " + e.getMessage());

            } // try - catch

        } // try - catch - finally

    }; // leerFichero()

    public static void escribirFichero(Path rFichero, Gson gson) {

        // Obtener información nuevo usuario:

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.leerUsuario(ent_txt, ent_num);

        // Declarción de variables

        BufferedReader br = null; BufferedWriter bw = null;
        Type tipoLista = null; ArrayList<Usuario> lista = new ArrayList<>();

        // Proceso de escritura en el fichero:

        try {
            String contenido = Files.readString(rFichero);
            br = new BufferedReader(new FileReader(rFichero.toAbsolutePath().toString()));
            Usuario usuarioFichero = null;
            if(Files.size(rFichero) >= 1) {
                if(contenido.startsWith("{")) {
                    usuarioFichero = gson.fromJson(br, Usuario.class);
                    if(usuarioFichero.getEmail().toLowerCase().equalsIgnoreCase(nuevoUsuario.getEmail().toLowerCase())) {
                        System.out.println("El email del usuario ya existe, no e puede guardar");
                        return;
                    }
                    lista.add(nuevoUsuario);
                    lista.add(usuarioFichero);

                } else if (contenido.startsWith("[")) {
                    tipoLista = new TypeToken<List<Usuario>>(){}.getType();
                    lista = gson.fromJson(br, tipoLista);
                    for(Usuario uLista : lista) {
                        if(uLista.getEmail().toLowerCase().equalsIgnoreCase(nuevoUsuario.getEmail().toLowerCase())) {
                            System.out.println("El email ya existe, no se puede guardar el usuario.");
                            return;

                        } // if

                    } // for 

                    lista.add(nuevoUsuario);

                } // if - else if

            } // if

        } catch (IOException e) {
            System.out.println("Se ha producido un error ene l método de escritura en fichero JSON: " + e.getMessage());

        } finally {
            try {
                br.close();

            } catch (IOException e) {
                System.out.println("Se ha producido un error cerrando el buffer de lectura: " + e.getMessage());

            } // try  catch

        } // try catch finally

        try {
            bw = new BufferedWriter(new FileWriter(rFichero.toAbsolutePath().toString()));
            gson.toJson(lista, bw);
            System.out.println("Se ha sobreescrito correctamente la información en el fichero: " + rFichero.getFileName().toString());

        } catch (IOException e) {
            System.out.println("Se ha producido un error escribiendo en el fichero: " +e .getMessage());

        } finally {
            try {
                bw.close();

            } catch (IOException e) {
                System.out.println("Se ha producido un error cerrando el fujo del buffered writer: " + e.getMessage());

            } // try - catch

        } // try - catch - finally

    } // escribirFichero

    public static void exportarAdmin(Path rFichero, Path rFicheroAdmin, Gson gson) {

        // Declaración de varibles:

        BufferedReader br = null; BufferedWriter bw = null;
        ArrayList<Usuario> lista = new ArrayList<Usuario>(); ArrayList<Usuario> listaAdmin = new ArrayList<Usuario>();

        // Obtención de datos: 

        try {
            br = new BufferedReader(new FileReader(rFichero.toAbsolutePath().toString()));
            String contenidoFichero = Files.readString(rFichero);
            if(contenidoFichero.startsWith("{")) {
                Usuario usuarioFichero = gson.fromJson(br, Usuario.class);
                if(usuarioFichero.getRol().toLowerCase().equalsIgnoreCase("admin")) {
                    listaAdmin.add(usuarioFichero);
                    System.out.println("Tamaño de la lista de usuarios: " + listaAdmin.size());

                } // if

            } else if (contenidoFichero.startsWith("[")) {
                Type tipoLista = new TypeToken<ArrayList<Usuario>>(){}.getType();
                lista = gson.fromJson(br, tipoLista);
                for(Usuario u : lista) {
                    if(u.getRol().toLowerCase().equalsIgnoreCase("admin")) {
                        listaAdmin.add(u);
                        System.out.println("Tamaño de la lista de usuarios: " + listaAdmin.size());
                        
                    } else continue;

                } // for

            } // if - else if

        } catch (IOException e) {
            System.out.println("Se ha producido un error leyendo el fichero: " + e.getMessage());

        } finally {
            try {
                br.close();

            } catch (IOException e) {
                System.out.println("Se ha producido un error cerrando el flujo del fichero: " + e.getMessage());

            } // try catch

        } // try catch finally

        // Proceso de escritura en el nuevo fichero: 

        try {
            bw = new BufferedWriter(new FileWriter(rFicheroAdmin.toAbsolutePath().toString()));
            gson.toJson(listaAdmin, bw);
            for(Usuario u : listaAdmin) System.out.println(u.toString());
            System.out.println("Se ha escrito correctamente en el fichero de amdinistradores");

        } catch (IOException e) {
            System.out.println("Se ha producido un error escribiendo en el fichero: " + e.getMessage());

        } finally {
            try {
                bw.close();

            } catch (IOException e) {
                System.out.println("Se ha producido un error cerrando el fujo de escritura: " + e.getMessage());

            } // try catch

        } // try catch finally

    } // exportarAdmin

} // class