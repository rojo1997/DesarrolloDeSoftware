package com.ds.intercepcion;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;

/**
*
* @author Ernesto Martínez del Pino
*/
public class Salpicadero extends javax.swing.JPanel {
	private Velocimetro velocimetro = new Velocimetro();
	private CuentaKilometros cuentaKilometros = new CuentaKilometros();
	private CuentaRevoluciones cuentaRevoluciones = new CuentaRevoluciones();
	
	public Salpicadero() {
		super();
		this.panelConfig();
        this.initComponents();
    }
	
	private void panelConfig() {
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		GridLayout experimentLayout = new GridLayout(1,4);
    	experimentLayout.addLayoutComponent("BotonAcelerar", this.velocimetro);
    	experimentLayout.addLayoutComponent("BotonEncender", this.cuentaKilometros);
    	experimentLayout.addLayoutComponent("BotonFrenar", this.cuentaRevoluciones);
    	this.setLayout(experimentLayout);
	}

    private void initComponents() {
    	this.add(this.velocimetro);
    	this.add(this.cuentaKilometros);
    	this.add(this.cuentaRevoluciones);
    }
    
    public void updateVelocidad(double velocidad) {
    	this.velocimetro.updateVelocidad(velocidad);
    }
    
    public void updateKilometros(double kilometros) {
    	this.cuentaKilometros.updateKilometros(kilometros);
    }
    
    public void updateRevoluciones(double revoluciones) {
    	this.cuentaRevoluciones.updateRevoluciones(revoluciones);
    }
}
