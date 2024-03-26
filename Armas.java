package com.mycompany.juegorpg;

import java.util.Scanner;

public class Armas {
    
    private int oro = 1000; // Considerando que el oro es un recurso compartido entre Objetos y Armas
    private Inventario inventario;
    
    public Armas() {
        oro = 1000;

    }
    
    public void mostrarArmas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué tipo de Arma deseas comprar?");
        System.out.println("1. Armas de una mano");
        System.out.println("2. Armas de dos manos");
        System.out.println("3. Armas cortas");
        System.out.println("4. Baculos");
        System.out.println("5. Escudos");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                mostrarArmasUnaMano();
                break;
            case 2:
                mostrarArmasDosManos();
                break;
            case 3:
                mostrarArmasCortas();
                break;
            case 4:
                mostrarBaculos();
                break;
            case 5:
                mostrarEscudos();
                break;
            default:
                System.out.println("Selecciona una opción correcta");
        }
    }
    
    private void comprarArma(String nombreArma, int precioArma) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Deseas comprar " + nombreArma + " por " + precioArma + " de Oro? (Si/No)");
        String respuesta = scanner.next();

        if (respuesta.equalsIgnoreCase("Si")) {
            if (oro >= precioArma) {
                oro -= precioArma;

                System.out.println("¡Has comprado " + nombreArma + "!");
                System.out.println("Tu saldo actual de oro es: " + oro);
            } else {
                System.out.println("No tienes suficiente oro para comprar " + nombreArma);
            }
        } else {
            System.out.println("No has comprado " + nombreArma);
        }
    }
    
    private void mostrarArmasUnaMano() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Las armas de una mano aumentan los puntos de fuerza del personaje que las equipa.");
        System.out.println("¿Qué arma quieres comprar?");
        System.out.println("1. Espada de Hierro");
        System.out.println("2. Cuchillo de Hierro");
        System.out.println("3. Cañon de Mano");
        
        int eleccion = scanner.nextInt();
        
        switch (eleccion) {
            case 1:
                comprarArma("Espada de Hierro", 60);
                break;
            case 2:
                comprarArma("Cuchillo de Hierro", 40);
                break;
            case 3:
                comprarArma("Cañon de Mano", 100);
                break;
            default:
                System.out.println("Selecciona una opción correcta");
        }
    }
    
    private void mostrarArmasDosManos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Las armas de dos manos aumentan los puntos de fuerza mucho más que las armas de una mano "
                + "pero reducen considerablemente la velocidad.");
        System.out.println("¿Qué arma quieres comprar?");
        System.out.println("1. Hacha de dos Manos");
        System.out.println("2. Martillo de Guerra");
        System.out.println("3. Espada del Tigre");
        
        int eleccion = scanner.nextInt();
        
        switch (eleccion) {
            case 1:
                comprarArma("Hacha de dos manos", 125);
                break;
            case 2:
                comprarArma("Martillo de Guerra", 90);
                break;
            case 3:
                comprarArma("Espada del Tigre", 200);
                break;
            default:
                System.out.println("Selecciona una opción correcta");
        }
    }
    
    private void mostrarArmasCortas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Las armas cortas no afectan los puntos de fuerza, pero sí aumentan considerablemente la velocidad.");
        System.out.println("¿Qué arma quieres comprar?");
        System.out.println("1. Daga de Hierro");
        System.out.println("2. Cuchillas a Dos manos");
        System.out.println("3. Puño Envenenado");
        
        int eleccion = scanner.nextInt();
        
        switch (eleccion) {
            case 1:
                comprarArma("Daga de hierro", 80);
                break;
            case 2:
                comprarArma("Cuchillas a Dos manos", 110);
                break;
            case 3:
                comprarArma("Puño envenenado", 0); // Añade el precio si tiene uno
                break;
            default:
                System.out.println("Selecciona una opción correcta");
        }
    }
    
    private void mostrarBaculos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Son armas que pueden ser usadas por magos, "
                + "aumentan los puntos de vida del personaje y también aumentan los puntos de concentración.");
        System.out.println("¿Que baculo quieres comprar?");
        System.out.println("1. Baculo noble");
        System.out.println("2. Baculo de la Ira");
        System.out.println("3. Baculo del Aventurero");
        
        int eleccion = scanner.nextInt();
        
        switch (eleccion) {
            case 1:
                comprarArma("Baculo Noble", 275);
                break;
            case 2:
                comprarArma("Baculo de la Ira", 300);
                break;
            case 3:
                comprarArma("Baculo del Aventurero", 250);
                break;
            default:
                System.out.println("Selecciona una opción correcta");
        }
    }
    
    public void mostrarEscudos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué escudo quieres comprar?");
        System.out.println("1. Escudo Sagrado");
        System.out.println("2. Escudo de Acero");
        System.out.println("3. Escudo del Guardian");

        int eleccion = scanner.nextInt();

        switch (eleccion) {
            case 1:
                comprarEscudo("Escudo Sagrado", 400, 25);
                break;
            case 2:
                comprarEscudo("Escudo de Acero", 175, 15);
            break;

            case 3:
                comprarEscudo("Escudo del Guardian", 100, 10);
            break;

        default:
            System.out.println("Selecciona una opción correcta");
    }
}

private void comprarEscudo(String nombreEscudo, int precioEscudo, int aumentoDefensa) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("¿Deseas comprar " + nombreEscudo + " por " + precioEscudo + " de Oro? (Si/No)");
    String respuesta = scanner.next();

    if (respuesta.equalsIgnoreCase("Si")) {
        if (oro >= precioEscudo) {
            oro -= precioEscudo;
            // Agregar el escudo al inventario
            
            System.out.println("¡Has comprado " + nombreEscudo + "!");
            System.out.println("Aumento Defensa: " + aumentoDefensa + "%");
            System.out.println("Tu saldo actual de oro es: " + oro);

        } else {
            System.out.println("No tienes suficiente oro para comprar " + nombreEscudo);
        }
    } else {
        System.out.println("No has comprado " + nombreEscudo);
    }
}
}
    

