/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.observador;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ernes
 */
public class ObservableTemperatura extends Observable implements Runnable{
    private final MonitorizacionTemperaturas monitor;
    private float temperatura;
    
    public ObservableTemperatura(MonitorizacionTemperaturas monitor){
        this.monitor = monitor;
    }

    @Override
    public void run() {
        float new_temperatura;
        while (true){
            new_temperatura = monitor.getTemperatura();
            if (new_temperatura != this.temperatura){
                this.temperatura = new_temperatura;
                // Método push and pull
                this.setChanged();
                this.notifyObservers();
            }
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(MonitorizacionTemperaturas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public float getTemperatura(){
        return this.temperatura;
    }
    
    public void setTemperatura(float temperatura){
        this.temperatura = temperatura;
        this.setChanged();
        this.notifyObservers();
    }
}
