
// Importar dependencias: 

import java.util.Scanner;
import java.util.ArrayList;
import java.util.ListIterator;

// Class

public class Programa {

    // Variables globales: 

    public static final Scanner ent_txt = new Scanner(System.in);
    public static final Scanner ent_num = new Scanner(System.in);

    // Método main 

    public static void main(String[] args) {
        
        // Declaración de variables: 

        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        // Declarar objeto tipo vehiculo terrestre: 

        Vehiculo vt = new VehiculoTerrestre("1234ABC", "Seat Leon", 4);
        listaVehiculos.add(vt);

        // Declarar objeto tipo vehículo acuático: 

        Vehiculo va = new VehiculoAcuatico("AAA", "kawasaki N30", 150);
        listaVehiculos.add(va);

        // Declarar objeto tipo vehículo aereo: 

        Vehiculo v_a = new VehiculoAereo("AAAA656533", "FALCON", 2);
        listaVehiculos.add(v_a);

        // Declarar objeto de tipo coche: 

        Vehiculo nuevoCoche = new Coche("1234ABC", "Seat Leon MK2 1P1 1.2 TSI", 4, true);
        listaVehiculos.add(nuevoCoche);

        // Declarar un objeto tipo moto

        Vehiculo nuevaMoto = new Moto("1234ABC", "KAWASAKI NINJA", 2, "Blanco");
        listaVehiculos.add(nuevaMoto);

        // Declarar un objeto tipo barco

        Vehiculo nuevoBarco = new Barco("AAA", "pRUEBA", 250, false);
        listaVehiculos.add(nuevoBarco);

        // Declarar un objeto tipo submarino

        Vehiculo nuevoSubmarino = new Submarino("AAA", "Pedro Sanchez", 1250, 452);
        listaVehiculos.add(nuevoSubmarino);

        // Declarar un objeto tipo avión

        Vehiculo nuevoAvion = new Avion("AAAA656533", "FALCON", 150, 200);
        listaVehiculos.add(nuevoAvion);

        // Declarar un objeto tipo helicóptero

        Vehiculo nuevoHelicoptero = new Helicoptero("AAAA656533", "heli1", 4, 1);
        listaVehiculos.add(nuevoHelicoptero);

        // Recorrer la lista y mostrar la información: 

        for(Vehiculo v : listaVehiculos) System.out.println(v.imprimir());

        // Mensajes: 

        System.out.println("Final del programa....");

        // Cerrar los escáners: 

        ent_num.close();
        ent_txt.close();

    } // main

    // Métodos personalizados: 

} // class