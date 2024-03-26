
package com.mycompany.juegorpg;

import java.util.Random;

/**
 *
 * @author cristian
 */
public class Enemigo {
    private String nombre;
    private String tipo;
    private String nivel;
    private int puntosDeVida;
    private int dañoFisico;
    private int dañoElemento;
    private String debilidadElemento;
    
    public Enemigo (){
        
    }
    
public Enemigo(String nombre, String tipo, int puntosDeVida, int dañoFisico, int dañoElemento, String debilidadElemento) {
    this.nombre = nombre;
    this.tipo = tipo;
    this.puntosDeVida = puntosDeVida;
    this.dañoFisico = dañoFisico;
    this.dañoElemento = dañoElemento;
    this.debilidadElemento = debilidadElemento;
}
    
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public void setPuntosDeVida(int puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }

    public int getDañoFisico() {
        return dañoFisico;
    }

    public int getDañoElemento() {
        return dañoElemento;
    }


    // Método para recibir daño elemental
    public void recibirDañoElemento(int dañoRecibido) {
        puntosDeVida -= dañoRecibido;
        if (puntosDeVida < 0) {
            puntosDeVida = 0;
        }
    }

    // Método para verificar si el enemigo está vivo
    public boolean estaConVida() {
        return puntosDeVida > 0;
    }
    
    public void recibirDañoElemento(int dañoRecibido, String elementoAtaque){
        if(elementoAtaque.equals(debilidadElemento)){
            dañoRecibido *= 1.2; //Aumenta el daño 20%
        }
        puntosDeVida -= dañoRecibido;
        if (puntosDeVida < 0){
            puntosDeVida = 0;
        }
    }
    
 
    public static Enemigo generarEnemigoFuego(){
        Random random = new Random();
        String [] nombres = {"Ignis", "Fenix", "Charmander"};
        String nombre = nombres [random.nextInt(nombres.length)];
        int puntosDeVida = 75 + random.nextInt(50);
        int dañoFisico = 10 + random.nextInt(10); //Daño fisico entre 10-20
        int dañoElemento = 15 + random.nextInt(10); //Daño de fuego entre 15-25
                                     
       return new Enemigo (nombre, "Fuego", puntosDeVida, dañoFisico, dañoElemento, "Hielo");        
    }
    
   public static Enemigo generarEnemigoHielo() {
        Random random = new Random();
        String[] nombres = {"Frost", "Glacier", "Blizzard"};
        String nombre = nombres[random.nextInt(nombres.length)];
        int puntosDeVida = 60 + random.nextInt(50); // Vida entre 60 y 110
        int danoFisico = 10 + random.nextInt(10); // Daño físico entre 10 y 20
        int danoElemento = 20 + random.nextInt(10); // Daño de hielo entre 20 y 30
        return new Enemigo(nombre, "Hielo", puntosDeVida, danoFisico, danoElemento, "Fuego");
    }
   
       public static Enemigo generarEnemigoNeutro() {
        Random random = new Random();
        String[] nombres = {"Golem", "Fantasma", "Ogro de la montaña"};
        String nombre = nombres[random.nextInt(nombres.length)];
        int puntosDeVida = 100 + random.nextInt(50); // Vida entre 100 y 150
        int dañoFisico = 10 + random.nextInt(15); // Daño físico entre 10 y 25
        int dañoElemento = 0; // No hay daño elemental
        return new Enemigo(nombre, "Neutro", puntosDeVida, dañoFisico, dañoElemento, "Nada");
    }
    
       public static Enemigo generarEnemigoAleatorio(){
           Random random = new Random ();
           int tipoEnemigo = random.nextInt(3);
           
           switch (tipoEnemigo){
               case 0:
                   return generarEnemigoFuego();
                
               case 1:
                   return generarEnemigoHielo();
                 
               default:
                   return generarEnemigoNeutro();
           }
       }
       
       public void recibirDañoFisico(int cantidad){
           puntosDeVida -= cantidad;
           if(puntosDeVida < 0){
               puntosDeVida = 0;
           }
       System.out.println(nombre + " recibió " + cantidad + " puntos de daño físico.");
            if (!estaConVida()) {
            System.out.println(nombre + " ha sido derrotado.");
        }
       }
       
       
       
    private String determinarNivel(int puntosDeVida) {
        if (puntosDeVida <= 40) {
            return "bajo";
        } else if (puntosDeVida <= 75) {
            return "medio";
        } else {
            return "alto";
        }
    }
    
}

    