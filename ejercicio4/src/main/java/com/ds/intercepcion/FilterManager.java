/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.intercepcion;

import java.util.ArrayList;

/**
 *
 * @author ernes
 */
public class FilterManager {
    private FilterChain chain;
    
    public void addFilter(Filter filter){
        this.chain.addFilter(filter);
    }
    
    void requestFilter(double revoluciones, EstadoMotor estadoMotor) {
        this.chain.execute(revoluciones, estadoMotor);
    }
}
