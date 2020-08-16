/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.observador;

import java.util.Random;

/**
 *
 * @author ernes
 */
public class Main {
    public static void main(String [] args){
        // Creamos la simulación real de temperaturas
        MonitorizacionTemperaturas monitor = new MonitorizacionTemperaturas((float)0.1, (float)2.0);
        
        // Creamos el objeto observable a partir del monitor
        ObservableTemperatura observable = new ObservableTemperatura(monitor);
        
        // Creamos los objetos observadores push
        graficaTemperatura grafica = new graficaTemperatura();
        botonCambio boton = new botonCambio(observable);
        // Creamos los objetos observadores pull
        pantallaTemperatura pantalla = new pantallaTemperatura(observable);
        
        
        // Añadimos los observadores
        observable.addObserver(grafica);
        observable.addObserver(boton);
        observable.addObserver(pantalla);
        
        // Iniciamos la simulación del monitor
        monitor.start();
        System.out.println("Minitor start");
        
        // Iniciamos el observador
        Thread observable_th = new Thread(observable); 
        observable_th.start(); 
        System.out.println("Observer start");
        
        while(true){
            //System.out.println(monitor.getTemperatura());
        }
    }
}
