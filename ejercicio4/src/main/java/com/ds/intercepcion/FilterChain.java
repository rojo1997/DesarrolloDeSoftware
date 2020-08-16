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
public class FilterChain {
    private final ArrayList<Filter> filters = new ArrayList<>();
    private Target target;
    
    public void addFilter(Filter filter){
        this.filters.add(filter);
    }
    
    public void execute(double revoluciones, EstadoMotor estadoMotor){
        this.filters.forEach((filter) -> {
            filter.execute(revoluciones, estadoMotor);
        });
        this.target.execute(revoluciones, estadoMotor);
    }
}
