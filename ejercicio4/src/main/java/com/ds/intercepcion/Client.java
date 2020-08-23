/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.intercepcion;

/**
 *
 * @author Ernesto Martínez del Pino
 */
public class Client {
    private FilterManager manager;
    
    public Client(FilterManager manager) {
    	this.manager = manager;
    }
    
    public double sendRequest(double revoluciones, EstadoMotor estadoMotor){
        return this.manager.requestFilter(revoluciones, estadoMotor);
    }
}
