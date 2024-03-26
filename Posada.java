/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegorpg;

import java.util.Scanner;

/**
 *
 * @author cristian
 */
public class Posada {
        public static void mostrarPosada(){
        
        Scanner scanner = new Scanner (System.in);
        System.out.println("Bienvenido a la Posada Aventurero");
        System.out.println("1. ¿Deseas Descansar?");
        System.out.println("2. Salir");
        
        int opcion = scanner.nextInt();
        
        switch (opcion){
            case 1:
                break;
             
            case 2:
                System.out.println("Saliendo de la Posada");
                break;
               
            default:
                System.out.println("Selecciona una opcion correcta");
        }
    }
}
