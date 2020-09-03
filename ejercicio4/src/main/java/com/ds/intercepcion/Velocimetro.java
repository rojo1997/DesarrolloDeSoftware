package com.ds.intercepcion;

import java.awt.Color;
import java.text.NumberFormat;

import javax.swing.BorderFactory;

/**
*
* @author Ernesto Martínez del Pino
*/
public class Velocimetro extends javax.swing.JPanel {
	private NumberFormat nf = NumberFormat.getNumberInstance();
	private javax.swing.JLabel EtiqMostrarVelocidad;
	
	public Velocimetro() {
		super();
		this.panelConfig();
		this.initComponents();
		this.nf.setMaximumFractionDigits(0);
	}
	
	private void panelConfig() {
		this.setSize(100, 100);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	private void initComponents() {
		this.EtiqMostrarVelocidad = new javax.swing.JLabel();
		
		//this.EtiqMostrarVelocidad.setSize(140, 40);
		
		this.EtiqMostrarVelocidad.setText("0 km/h");
		
		this.add(this.EtiqMostrarVelocidad);
	}
	
	public void updateVelocidad(double velocidad) {
		this.EtiqMostrarVelocidad.setText(this.nf.format(velocidad) + " km/h");
		this.updateUI();
	}
}