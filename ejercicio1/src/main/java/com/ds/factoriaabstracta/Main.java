package com.ds.factoriaabstracta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Ernesto Martínez del Pino
 */
public class Main {
    public static void main( String[] args ) {
        FactoriaCarreraYBicicleta factoria;
        Carrera carreraMontaña;
        Carrera carreraCarretera;
        int n;
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Introduce el nº de bicicletas: ");
            n = sc.nextInt();
        }
        
        
        System.out.println("Creando carreras");
        factoria = new FactoriaCarretera();
        carreraMontaña = factoria.crearCarrera(n);
        factoria = new FactoriaMontaña();
        carreraCarretera = factoria.crearCarrera(n);
        
        System.out.println("Empezando carreras");
        carreraMontaña.empezarCarrera();
        carreraCarretera.empezarCarrera();
        
        // Espera bloqueante para todas la bicicletas
        carreraMontaña.finalizarCarrera();
        carreraCarretera.finalizarCarrera();
        System.out.println("Carreras terminadas");
    }
}
