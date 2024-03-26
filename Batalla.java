package com.mycompany.juegorpg;

import java.util.Random;
import java.util.Scanner;

public class Batalla {

    private Jugador jugador;
    private Enemigo[] enemigos;

    public Batalla(Jugador jugador) {
        this.jugador = jugador;
        generarEnemigosAleatorios();
    }

    private void generarEnemigosAleatorios() {
        Random random = new Random();
        int cantidadEnemigos = random.nextInt(3) + 1; // Entre 1 y 3 enemigos
        this.enemigos = new Enemigo[cantidadEnemigos];
        for (int i = 0; i < cantidadEnemigos; i++) {
            enemigos[i] = Enemigo.generarEnemigoAleatorio();
        }
    }

    public void iniciarBatalla() {
        System.out.println("¡Una batalla ha comenzado!");

        // Mostrar información de los enemigos
        System.out.println("Enemigos:");
        for (int i = 0; i < enemigos.length; i++) {
            System.out.println((i + 1) + ". " + enemigos[i].getNombre() + " - Tipo: " + enemigos[i].getTipo() + " - Puntos de Vida: " + enemigos[i].getPuntosDeVida());
        }

        // Mostrar menú de opciones
        mostrarMenu();
    }

    private void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean batallaActiva = true;

        while (batallaActiva) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Atacar");
            System.out.println("2. Usar objeto");
            System.out.println("3. Usar magia (solo para magos)");
            System.out.println("4. Saltar turno");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    atacar();
                    break;
                case 2:
                    usarObjeto();
                    break;
                case 3:
                    usarMagia();
                    break;
                case 4:
                    saltarTurno();
                    break;
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
                    break;
            }

            // Simulación de turno de los enemigos
            for (Enemigo enemigo : enemigos) {
                Random random = new Random();
                if (enemigo.estaConVida()) {
                    int opcionEnemigo = random.nextInt(3) + 1;
                    switch (opcionEnemigo) {
                        case 1:
                            enemigo.recibirDañoFisico(jugador.getFuerza());
                            break;
                        case 2:
                            // Lógica para que los enemigos usen objetos
                            break;
                        case 3:
                            // Lógica para que los enemigos usen magia
                            break;
                    }
                }
            }

            // Verificar si el jugador o los enemigos han sido derrotados
            if (!jugador.estaConVida()) {
                System.out.println("¡El jugador ha sido derrotado!");
                batallaActiva = false;
            } else {
                boolean enemigosVivos = false;
                for (Enemigo enemigo : enemigos) {
                    if (enemigo.estaConVida()) {
                        enemigosVivos = true;
                        break;
                    }
                }
                if (!enemigosVivos) {
                    System.out.println("¡Todos los enemigos han sido derrotados!");
                    batallaActiva = false;
                }
            }
        }
    }

    private void atacar() {
        // Lógica para permitir al jugador atacar a un enemigo seleccionado
        System.out.println("Has seleccionado atacar.");
    }

    private void usarObjeto() {
        // Lógica para permitir al jugador usar un objeto
        System.out.println("Has seleccionado usar un objeto.");
    }

    private void usarMagia() {
        // Lógica para permitir al jugador usar magia (solo para magos)
        System.out.println("Has seleccionado usar magia.");
    }

    private void saltarTurno() {
        // Lógica para permitir al jugador saltar turno
        System.out.println("Has seleccionado saltar turno.");
    }
}







