package com.mycompany.juegorpg;

import java.util.Scanner;

public class Objetos {
    private int oro = 1000;
    private String[] inventario = new String[100]; // Arreglo para almacenar el inventario
    private int indexInventario = 0;
    
    public Objetos() {
       oro = 1000;
    }
    
    public void mostrarObjetos() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("¿Qué tipo de Objeto deseas comprar?");
        System.out.println("1. Poción");
        System.out.println("2. Poción Mayor");
        System.out.println("3. Pluma de Fénix");
        System.out.println("4. Tienda de Campaña");
        System.out.println("5. Velocidad");
        System.out.println("6. Freno");
        System.out.println("0. Salir");
        
        int opcion = scanner.nextInt();
        
        switch (opcion) {
            case 1:
                System.out.println("Recupera algunos puntos de vida del personaje al que se le aplica.");
                comprarObjeto("Poción", 125);
                break;
            case 2:
                System.out.println("Recupera bastantes puntos de vida del personaje al que se le aplica.");
                comprarObjeto("Poción Mayor", 400);
                break;
            case 3:
                System.out.println("Revive a un personaje exhausto, recuperando también una pequeña parte de los puntos de vida. ");
                comprarObjeto("Pluma de Fénix", 500);
                break;
            case 4:
                System.out.println("Permite a los personajes descansar y recuperar por completo los puntos de vida. ");
                comprarObjeto("Tienda de Campaña", 450);
                break;
            case 5:
                System.out.println("Al aplicar a un personaje, sus puntos de velocidad aumentan y el orden de los turnos se recalcula.");
                comprarObjeto("Velocidad", 250);
                break;
            case 6:
                System.out.println("Al aplicar a un personaje, sus puntos de velocidad disminuyen y el orden de los turnos se recalcula.");
                comprarObjeto("Freno", 250);
                break;
            case 0:
                System.out.println("Volviendo al Menú");
                break;
            default:
                System.out.println("Selecciona una opción correcta");
                mostrarObjetos();
        }
    }

    public void comprarObjeto(String nombreObjeto, int precioObjeto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Deseas comprar " + nombreObjeto + " por " + precioObjeto + " de Oro? (Si/No)");
        String respuesta = scanner.next();

        if (respuesta.equalsIgnoreCase("Si")) {
            if (oro >= precioObjeto) {
                oro -= precioObjeto;
                // Agregar el objeto al inventario
                if (indexInventario < inventario.length) {
                    inventario[indexInventario++] = nombreObjeto;
                    System.out.println("¡Has comprado " + nombreObjeto + "!");
                    System.out.println("Tu saldo actual de oro es: " + oro);
                } else {
                    System.out.println("El inventario está lleno. No puedes comprar más objetos.");
                }
            } else {
                System.out.println("No tienes suficiente oro para comprar " + nombreObjeto);
            }
        } else {
            System.out.println("No has comprado " + nombreObjeto);
        }
    }

    public void mostrarInventario() {
        System.out.println("Inventario:");
        for (String objeto : inventario) {
            if (objeto != null) {
                System.out.println(objeto);
            }
        }
    }
}





