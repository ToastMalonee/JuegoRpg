
    package com.mycompany.juegorpg;
    
    import java.util.Random;
    import java.util.Scanner;

    /**
     *
     * @author cristian
     */
        public class Mapa {  
            
        String[][] casillas;
        int tamaño;
        int cantidadCiudades;
        private int posicionJugadorV;
        private int posicionJugadorH;
        private Tienda tienda;
        private Posada posada = new Posada();
        private Jugador jugador;
        private Batalla batalla;


        public Mapa() {
        Random random = new Random();
        int[] dimensionesPermitidas = {7, 10, 12};
        this.tamaño = dimensionesPermitidas[random.nextInt(dimensionesPermitidas.length)];
        this.cantidadCiudades = 3 + random.nextInt(3);
        this.jugador = new Jugador();
        
        this.casillas = new String[tamaño][tamaño];
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                this.casillas[i][j] = "";
            }
        }
        
        this.generarMapa();
        this.generarCiudades();
        this.tienda = new Tienda();
        this.batalla = new Batalla(jugador); // Inicialización de batalla con el jugador
    }


private void generarMapa() {
    Random random = new Random();
    int tiendaV = random.nextInt(tamaño);
    int tiendaH = random.nextInt(tamaño);
    int posadaV = random.nextInt(tamaño);
    int posadaH = random.nextInt(tamaño);
    int batallaV = random.nextInt(tamaño);
    int batallaH = random.nextInt(tamaño);

    for(int i = 0; i < tamaño; i++) {
        for (int j = 0; j < tamaño; j++) {
            if (i == tiendaV && j == tiendaH) {
                casillas[i][j] = "Tienda";
            } else if (i == posadaV && j == posadaH) {
                casillas [i][j] = "Posada";
            } else if (i == batallaV && j == batallaH) {
                casillas[i][j] = "Batalla";
            } else {
                casillas [i][j] = "";
            }
        }
    }
}
        

public void moverJugador(char direccion) {
    Scanner scanner = new Scanner(System.in);
    switch (direccion) {
        case 'W':
            if (posicionJugadorV > 0) {
                posicionJugadorV--;
            } else {
                System.out.println("¡Has alcanzado el límite superior del mapa! Intenta otro movimiento.");
            }
            break;
        case 'A':
            if (posicionJugadorH > 0) {
                posicionJugadorH--;
            } else {
                System.out.println("¡Has alcanzado el límite izquierdo del mapa! Intenta otro movimiento.");
            }
            break;
        case 'S':
            if (posicionJugadorV < tamaño - 1) {
                posicionJugadorV++;
            } else {
                System.out.println("¡Has alcanzado el límite inferior del mapa! Intenta otro movimiento.");
            }
            break;
        case 'D':
            if (posicionJugadorH < tamaño - 1) {
                posicionJugadorH++;
            } else {
                System.out.println("¡Has alcanzado el límite derecho del mapa! Intenta otro movimiento.");
            }
            break;
        default:
            System.out.println("Presione una opcion correcta");
    }

    verificarPosada();
    if (casillas[posicionJugadorV][posicionJugadorH].equals("Tienda")) {
        Tienda.mostrarTienda();
        tienda.verificarTienda();
    } else if (casillas[posicionJugadorV][posicionJugadorH].equals("Batalla")) {
        batalla.iniciarBatalla();
    }
}
        
         


     private void generarCiudades() {
        Random random = new Random();
        String[] nombresCiudades = {"Sotoba", "Konoha", "Xerxes", "Rostan", "Ryuta"};
        int ciudades = 3 + random.nextInt(3); // Genera 3, 4 o 5 ciudades aleatorias

        for (int i = 0; i < ciudades; i++) {
            int ciudadV;
            int ciudadH;
            do {
                ciudadV = random.nextInt(tamaño); // Generar coordenada vertical aleatoria
                ciudadH = random.nextInt(tamaño); // Generar coordenada horizontal aleatoria
            } while (!casillas[ciudadV][ciudadH].isEmpty()); // Repetir si la casilla no está vacía

            // Colocar la ciudad en el mapa
            int indiceCiudad = random.nextInt(nombresCiudades.length);
            String nombreCiudad = nombresCiudades[indiceCiudad];
            casillas[ciudadV][ciudadH] = nombreCiudad;

            // Eliminar el nombre de la ciudad seleccionada para evitar repeticiones
            nombresCiudades[indiceCiudad] = null;
            for (int j = indiceCiudad; j < nombresCiudades.length - 1; j++) {
                nombresCiudades[j] = nombresCiudades[j + 1];
            }
        }
    }
     
     
    public void mostrarMapa() {
        System.out.println("******MAPA DE ALEXANDRIA******");
        for (int i = 0; i < tamaño; i++) {
        System.out.print("|");
            for (int j = 0; j < tamaño; j++) {
                if (i == posicionJugadorV && j == posicionJugadorH) {
                System.out.print("   X   |");
            } else if (casillas[i][j] == null || casillas[i][j].isEmpty()) {
                System.out.print("       |");
            } else {
                String casilla = casillas[i][j];
                int anchoCasilla = 6;

                if (casilla.equals("Tienda") || casilla.equals("Posada")) {
                    anchoCasilla = 6;
                }

                System.out.printf(" %-6s|", casilla);
            }
        }
        System.out.println();
    
           


            if (i < tamaño - 1 && (tamaño == 7 || tamaño == 10 || tamaño == 12)) {
            if (tamaño == 7) {
                System.out.println("|-------|-------|-------|-------|-------|-------|-------|");
            } else if (tamaño == 10) {
                System.out.println("|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|");
            } else if (tamaño == 12) {
                System.out.println("|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|");
            }
         }
       }
     }

            
    private void verificarPosada(){
       if (posicionJugadorV >= 0 && posicionJugadorV < tamaño &&
            posicionJugadorH >= 0 && posicionJugadorH < tamaño) {
            // Verificar si la casilla es una tienda
                if (casillas[posicionJugadorV][posicionJugadorH].equals("Posada")) {
                    posada.mostrarPosada(); // Llama al método mostrarPosada () en la instancia de Posada
       } 
    }            
}
    

}

    

        

