/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.factoriaabstracta;

/**
 *
 * @author Ernesto Martínez del Pino
 */
public class BicicletaMontaña extends Bicicleta {
    // Probabilidad de retirarse
    private static final double P = 0.2;
    
    public BicicletaMontaña(int id) {
        super(BicicletaMontaña.P,id);
    }
    
}
