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
public class FiltroRepercutirRozamiento implements Filter {

    @Override
    public double execute(double revoluciones, EstadoMotor estadoMotor) {
    	if (revoluciones == 0.0) {
        	return revoluciones;
        }
    	else {
    		return revoluciones - 1;
    	}
    }

}
