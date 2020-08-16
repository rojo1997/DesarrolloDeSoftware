/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.factoriaabstracta;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ernesto Martínez del Pino
 */
public abstract class Bicicleta extends Thread {
    // Número máximo de segundo que puede estar en una carrera
    private static final int MAX_SEC = 60;
    // Indentificador unico de la carrera
    private final int id;
    // Número de segundo en la carrera
    private final int s;
    
    public Bicicleta(double p, int id){
        Random r = new Random();
        if (r.nextDouble() < p){
            this.s = (int) (MAX_SEC * r.nextDouble());
        }
        else {
            this.s = MAX_SEC;
        }
        this.id = id;
    }
    
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(this.s);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bicicleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
