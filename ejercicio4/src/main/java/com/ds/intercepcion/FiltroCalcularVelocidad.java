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
public class CalcularVelocidad implements Filter {
    private double incrementoVelocidad = 0.0;
    
    @Override
    public double execute(double revoluciones, EstadoMotor estadoMotor){
        if (estadoMotor == EstadoMotor.APAGADO){
            this.incrementoVelocidad = 0;
        } else if (estadoMotor == EstadoMotor.FRENADO && estadoMotor == EstadoMotor.ENCENDIDO) {
            this.incrementoVelocidad -= 100;
        } else if (estadoMotor == EstadoMotor.ACELERANDO  && estadoMotor == EstadoMotor.ENCENDIDO) {
            this.incrementoVelocidad += 100;
        }
        return  revoluciones + this.incrementoVelocidad;
    }
    
}
