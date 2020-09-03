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
public class FilterChain {
    private final ArrayList<Filter> filters = new ArrayList<>();
    private Target target;
    
    public void addFilter(Filter filter){
        this.filters.add(filter);
    }
    
    public double execute(double revoluciones, EstadoMotor estadoMotor){
    	for (Filter filter: this.filters) {
    		revoluciones = filter.execute(revoluciones, estadoMotor);
    	}
        return this.target.execute(revoluciones, estadoMotor);
    }

	public void setTarget(Target target) {
		this.target = target;
	}
}
