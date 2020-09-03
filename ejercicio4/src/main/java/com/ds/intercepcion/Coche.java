package com.ds.intercepcion;

/**
*
* @author Ernesto Martínez del Pino
*/
public class Coche {
	private double revoluciones = 0.0;
	private EstadoMotor estadoMotor = EstadoMotor.APAGADO;
	
	public void setRevoluciones(double revoluciones) {
		this.revoluciones = revoluciones;
	}
	
	public void setEstadoMotor(EstadoMotor estadoMotor) {
		this.estadoMotor = estadoMotor;
	}
	
	public double getRevoluciones() {
		return this.revoluciones;
	}
	
	public EstadoMotor getEstadoMotor() {
		return this.estadoMotor;
	}
}
