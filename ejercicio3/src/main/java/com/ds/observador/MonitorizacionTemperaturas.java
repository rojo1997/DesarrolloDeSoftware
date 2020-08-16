/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.observador;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/** 
 *
 * @author ernes
 */
public class MonitorizacionTemperaturas extends Thread {
    private float temperatura = (float) 100.0;
    private final Random random;
    private final float min;
    private final float max;
    
    public MonitorizacionTemperaturas(float min, float max) {
        this.random = new Random();
        this.min = min;
        this.max = max;
    }
    
    private void update(){
        this.temperatura +=  (((float) random.nextInt(2) - 0.5) * 2.0) * (this.min + this.random.nextDouble() * (this.max - this.min));
        if (this.temperatura < 0.0){
            this.temperatura = (float) 0.0;
        }
    }
    
    public float getTemperatura() {
        return this.temperatura;
    }
    
    @Override
    public void run() 
    { 
        while (true){
            this.update();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(MonitorizacionTemperaturas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}
