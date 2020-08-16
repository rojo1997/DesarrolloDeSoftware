/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.factoriaabstracta;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ernesto Martínez del Pino
 */
public abstract class Carrera {
    // Lista de bicicletas que participan en la carrera
    private final ArrayList<Bicicleta> bicicletas;
    
    public Carrera(ArrayList<Bicicleta> bicicletas){
        this.bicicletas = bicicletas;
    }
    
    public void empezarCarrera(){
        // Lanzamiento de hebras
        for(int i=0; i<this.bicicletas.size(); ++i)
            bicicletas.get(i).start();
    }
    
    public void finalizarCarrera(){
        // Sincronización de hebras
        for(int i=0; i<this.bicicletas.size(); ++i)
            try {
                bicicletas.get(i).join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
