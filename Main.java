package com.mycompany.juegorpg;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        Mapa mapa = new Mapa();
        Objetos objetos = new Objetos();

        // Mostrar el mapa inicial
        mapa.mostrarMapa();

        // Bucle para permitir que el jugador se mueva hasta que decida salir
        boolean juegoActivo = true;
        while (juegoActivo) {
            // Leer la entrada del usuario
            System.out.println("Presiona L, si deseas salir de la partida:");
            System.out.println("Presiona I, si deseas abrir el inventario:");
            System.out.print("Mueve al jugador con las teclas WASD (W: arriba, A: izquierda, S: abajo, D: derecha): ");
            System.out.println("");
            char input = Character.toUpperCase(scanner.next().charAt(0));

            // Realizar acciones según la entrada del usuario
            switch (input) {
                case 'L':
                    juegoActivo = false;
                    System.out.println("¡Gracias por jugar!");
                    break;
                case 'I':
                    objetos.mostrarInventario();
                    break;
                default:
                    mapa.moverJugador(input);
                    mapa.mostrarMapa(); // Mostrar el mapa después de mover al jugador
                    break;
            }
        }

        scanner.close();
    }
}


