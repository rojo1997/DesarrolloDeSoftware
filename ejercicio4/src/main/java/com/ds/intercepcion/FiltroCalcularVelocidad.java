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
public class FiltroCalcularVelocidad implements Filter {
    private double incrementoVelocidad = 0.0;
    private static double MAX_REVOLUCIONES = 5000.0;
    private static double MIN_REVOLUCIONES = 0.0;
    
    @Override
    public double execute(double revoluciones, EstadoMotor estadoMotor){
    	System.out.println("FiltroCalcularVelocidad: " + estadoMotor);
        if (estadoMotor.equals(EstadoMotor.APAGADO) || estadoMotor.equals(EstadoMotor.ENCENDIDO)){
            this.incrementoVelocidad = 0;
        } else if (estadoMotor.equals(EstadoMotor.FRENADO)) {
            this.incrementoVelocidad -= 100;
        } else if (estadoMotor.equals(EstadoMotor.ACELERANDO)) {
            this.incrementoVelocidad += 100;
        }
        revoluciones = revoluciones + this.incrementoVelocidad;
        if (revoluciones > FiltroCalcularVelocidad.MAX_REVOLUCIONES) {
        	revoluciones = FiltroCalcularVelocidad.MAX_REVOLUCIONES;
        }
        if (revoluciones < FiltroCalcularVelocidad.MIN_REVOLUCIONES) {
        	revoluciones = FiltroCalcularVelocidad.MIN_REVOLUCIONES;
        }
        System.out.println("FiltroCalcularVelocidad: " + revoluciones);
        return  revoluciones;
    }
    
}
