/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.intercepcion;

/**
 *
 * @author ernes
 */
class Target {
	private double r = 0.15;
	
    public double execute(double revoluciones, EstadoMotor estadoMotor){
    	return 2 * Math.PI * this.r * revoluciones * (60.0 / 1000.0);
    }
}
