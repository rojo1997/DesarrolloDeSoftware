package com.ds.intercepcion;

import java.awt.Color;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.swing.BorderFactory;

public class CuentaRevoluciones extends javax.swing.JPanel {
	private double accRevoluciones = 0.0;
	private LocalDateTime tiempoAnterior = LocalDateTime.now();
	private NumberFormat nf = NumberFormat.getNumberInstance();
	
	public CuentaRevoluciones() {
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
		this.EtiqMostrarRevoluciones = new javax.swing.JLabel();
		
		//this.EtiqMostrarRevoluciones.setSize(140, 40);
		
		this.EtiqMostrarRevoluciones.setText("0 revoluciones");
		
		this.add(this.EtiqMostrarRevoluciones);
	}
	
	private javax.swing.JLabel EtiqMostrarRevoluciones;
	
	public void updateRevoluciones(double revoluciones) {
		LocalDateTime tiempoAhora = LocalDateTime.now();
		Duration diff = Duration.between(this.tiempoAnterior, tiempoAhora);
		this.accRevoluciones += revoluciones * (diff.getSeconds() / (60.0));
		this.EtiqMostrarRevoluciones.setText(this.nf.format(this.accRevoluciones) + " revoluciones");
		this.tiempoAnterior = tiempoAhora;
		this.updateUI();
	}
}
