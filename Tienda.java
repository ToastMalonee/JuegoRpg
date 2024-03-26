
package com.mycompany.juegorpg;

import java.util.Scanner;

public class Tienda {
    private final int oro = 1000;
    private Inventario inventario;
    int contador;
    Objetos objetos = new Objetos();
    public Tienda (){   
        
    }
         
    public static void mostrarTienda() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la Tienda Aventurero");
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Comprar objetos, magias, armas");
        System.out.println("2. Vender objetos, magias, armas");
        System.out.println("0. Salir");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("¿Qué deseas comprar?");
                System.out.println("1. Objetos");
                System.out.println("2. Magias");
                System.out.println("3. Armas");
                int opc = scanner.nextInt();

                switch (opc) {
                    case 1:
                        new Objetos().mostrarObjetos();
                      
                        break;
                    case 2:
                        new Magias().mostrarMagias();   
                        break;
                    case 3:
                        new Armas().mostrarArmas();
                        break;
                    default:
                        System.out.println("Selecciona una opción correcta");
                }
                break;

            case 2:
                // Lógica para vender
                break;

            case 0:
                System.out.println("Saliendo de la Tienda");
                break;

            default:
                System.out.println("Selecciona una opción correcta");
        }
    }

   void verificarTienda() {
    
        boolean seguirComprando = true;
        while (seguirComprando) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("¿Quieres seguir comprando en la tienda? (Si/No)");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("Si")) {
                mostrarTienda(); // Mostrar la tienda nuevamente
                // Lógica para comprar en la tienda
            } else if (respuesta.equalsIgnoreCase("No")) {
                seguirComprando = false; // Salir del bucle y continuar con el juego
            } else {
                System.out.println("Por favor, ingresa una respuesta válida (Si/No).");
            }
        }
       
    
    }
}

    
    

