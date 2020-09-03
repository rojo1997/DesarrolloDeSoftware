/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.intercepcion;

import java.util.ArrayList;

/**
 *
 * @author Ernesto Martínez del Pino
 */
public class FilterManager {
    private FilterChain chain = new FilterChain();
    
    public void addFilter(Filter filter) {
        this.chain.addFilter(filter);
    }
    
    public void setTarget(Target target) {
    	this.chain.setTarget(target);
    }
    
    public double requestFilter(double revoluciones, EstadoMotor estadoMotor) {
        return this.chain.execute(revoluciones, estadoMotor);
    }
}
