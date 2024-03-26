
package com.mycompany.juegorpg;

/**
 *
 * @author cristian
 */
public class Jugador {
    private int nivel;
    private int puntosExp;
    private int puntosVida;
    private int fuerza;
    private int defensa;
    private int concentracion;
    private int espiritu;
    private int velocidad;
    private int oro;
    
    //Constructor
    public Jugador(){
        
        this.puntosVida = 100;
        this.fuerza = 1;
        this.defensa = 1;
        this.concentracion = 1;
        this.espiritu = 1;
        this.velocidad = 0;
        this.nivel = 1;
        this.puntosExp = 0;
        this.oro = 0;
    }


    public int getNivel() {
        return nivel;
    }

    public int getPuntosDeExp() {
        return puntosExp;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getConcentracion() {
        return concentracion;
    }

    public int getEspiritu() {
        return espiritu;
    }

    public int getVelocidad() {
        return velocidad;
    }
    
    public int getOro() {
        return oro;
    }

    public void ganarExperiencia(int expGanada){
        puntosExp += expGanada;
        // Comprueba si alcanzó la experiencia ganada para subir de nivel
        int expSubirSiguienteNivel = calcularExpSiguienteNivel();
        while (puntosExp >= expSubirSiguienteNivel){
            puntosExp -= expSubirSiguienteNivel;
            expSubirSiguienteNivel = calcularExpSiguienteNivel();
            subirNivel();
        }
    }

    private int calcularExpSiguienteNivel() {
        return nivel * 100;
    }
    
    private void subirNivel(){
        nivel++;
    }
    
    public void recibirDañoFisico(int daño){
        puntosVida -= daño;
        if (puntosVida < 0){
            puntosVida = 0;
        }
    }
    
    public void recibirDañoElemento(int daño){
        // Implementa la lógica para recibir daño de un elemento (si es necesario)
    }
    
    public void aumentarOro(int cantidad){
        oro += cantidad;
        System.out.println("Has ganado " + cantidad + " de oro.");
    }
        
    public void recibirExperiencia(int cantidad){
        puntosExp += cantidad;
        System.out.println("Has ganado " + cantidad + " puntos de experiencia.");    
    }
    
    public void recuperarPuntosVida(){
        puntosVida = 1;
        System.out.println("Recuperaste puntos de vida");
    }
    
    public boolean estaConVida(){
        return puntosVida > 0;
    }

    boolean estaMuerto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
