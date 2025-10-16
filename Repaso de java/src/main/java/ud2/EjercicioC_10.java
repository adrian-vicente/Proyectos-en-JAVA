package ud2;

// Importar dependencias:

import java.util.Scanner;
import main.java.ud2.Producto;
import java.util.LinkedList;

/**
 * 
 * @author Adrián Vicente Vera
 * @since 04/10/2025
 * Ejercicio C_10
 * 
 */

// Classs

public class EjercicioC_10 {

    // Variables globales: 

    public static Scanner ent_txt = new Scanner(System.in);
    public static Scanner ent_num = new Scanner(System.in);

    // Método main: 

    public static void main(String[] args) {

        /*
         * 
         * - Mostrar valor total vendido
         * - Mostrar productos agotados
         * 
        */
        
        // Declaración de variables: 

        double valorTotalVendido = 0.0d;
        String productosAgotados = " ";
        int opcion; boolean continuar = true;

        final int STOCK_INICIAL = 100;
        final String MENSAJE_SIN_STOCK = "Stock insuficiente";
        final String MENSAJE_CODIGO_INCORRECTO = "Código incorrecto";

        LinkedList<Producto> listaProductos = new LinkedList<>();

        // Carga inicial de tres productos: 

        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        Producto producto3 = new Producto();

        producto1.setStockDisponible(STOCK_INICIAL);
        producto2.setStockDisponible(STOCK_INICIAL);
        producto3.setStockDisponible(STOCK_INICIAL);

        producto1.leerProducto(ent_txt, ent_num);
        producto2.leerProducto(ent_txt, ent_num);
        producto3.leerProducto(ent_txt, ent_num);

        // Añadir los elementos a la lista: 

        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);

        // Mostrar la lista: 

        for(int i = 0; i < listaProductos.size(); i++) System.out.println("Producto" + (i+1) + ", " + listaProductos.get(i).toString());
        
        // Inicio de la aplicación

        while(continuar) {
            imprimirMenu();
            opcion = ent_num.nextInt();
            switch(opcion) {

                case 0:
                    continuar = false;
                    break;

                case 1:
                    valorTotalVendido = hacerPedido(listaProductos, valorTotalVendido,  MENSAJE_CODIGO_INCORRECTO, MENSAJE_SIN_STOCK);
                    productosAgotados = identificarAgotados(listaProductos);
                    break;

                default:
                    System.out.println("Opción elegida no válida. Finalizando programa...");
                    continuar = false;
                    break;

            } // switch

        } // while

        // Mensajes tras la ejecución de pedidos: 

        System.out.println("Valor total vendido: " + valorTotalVendido + " euros.");
        if(productosAgotados.equalsIgnoreCase(" ")) System.out.println("No hay ningún producto agotado");
        else
            System.out.println("Productos agotados: " + productosAgotados);

        // Final de la aplicación:

        // Mensaje final del programa: 

        System.out.println("Final del programa");

        // Cerrar los escáners:

        ent_txt.close();
        ent_num.close();

    } // método main

    // Métodos personalizados: 

    public static void imprimirMenu() {
        System.out.println("====MENU===");
        System.out.println("0. Salir");
        System.out.println("1. Hacer un pedido");
        System.out.println("====================");

    } // imprimirMenu()

    public static double hacerPedido(LinkedList<Producto> listaProductos, double valorVendido, String mensajeCodigo, String mensajeStock) {

        // Declaración de variables: 

        int codigoProductoPedido = 0;
        int cantidadPedido = 0;
        boolean codigoCorrecto = true;

        // Recogida de datos: 

        System.out.println("Introduce el código del producto para hacer el pedido: ");
        codigoProductoPedido = ent_num.nextInt();

            // Comprobaciones sobre el código del producto: 

            // Si el código es cero: 

            if(codigoProductoPedido == 0) return 0.0d;

            // Si el código no es cero y no existe: 

            for(int i = 0; i < listaProductos.size(); i++) {
                if(listaProductos.get(i).getCodigoProducto() == codigoProductoPedido) {
                    codigoCorrecto = true;
                    break;

                } else codigoCorrecto = false;

            } // for 

            if(!codigoCorrecto) {
                System.out.println(mensajeCodigo);
                return 0.0d;

            } // if

        // Recoger la cantidad a pedir en caso de que el código del producto exista 

        System.out.println("Introduce la cantidad a pedir");
        cantidadPedido = ent_num.nextInt();

            // Comprobaciones sobre la cantidad antes de hacer el pedido: 

            if(listaProductos.get(codigoProductoPedido - 1).getStockDisponible() < cantidadPedido) {
                System.out.println(mensajeStock);
                return 0.0d;

            } // if

        // Si las comprobaciones se superan. Proceso para realizar el pedido: 

        // 1. Restar la cantidad del pedido al stock actual del producto: 

        listaProductos.get(codigoProductoPedido - 1).setStockDisponible(listaProductos.get(codigoProductoPedido - 1).getStockDisponible() - cantidadPedido);

        // 2. Calcular el valor total vendido: 

        valorVendido = listaProductos.get(codigoProductoPedido - 1).getPrecio() * cantidadPedido;
        return valorVendido;

    } // hacerPedido

    public static String identificarAgotados(LinkedList<Producto> listaProductos) {
        String agotados = "";
        for(int i = 0; i < listaProductos.size(); i++) {
            if(listaProductos.get(i).getStockDisponible() == 0) {
                agotados = agotados + listaProductos.get(i).getNombre() + ", ";

            } else continue; 
            
        } // for

        // Devolver el valor acumulado: 

        return agotados;

    } // identificarAgotados

} // class