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
class Target {
	private static double R = 0.15;
	private Salpicadero salpicadero;
	
	public Target (Salpicadero salpicadero) {
		this.salpicadero = salpicadero;
	}
	
    public double execute(double revoluciones, EstadoMotor estadoMotor){
    	double velocidad =  2 * Math.PI * this.R * revoluciones * (60.0 / 1000.0);
    	this.salpicadero.updateKilometros(velocidad);
    	this.salpicadero.updateRevoluciones(revoluciones);
    	this.salpicadero.updateVelocidad(velocidad);
    	return revoluciones;
    }
    
    public void addWindowListener() {
    	
    }
}
