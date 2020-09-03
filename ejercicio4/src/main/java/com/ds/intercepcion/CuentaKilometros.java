package com.ds.intercepcion;

import java.awt.Color;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.swing.BorderFactory;

/**
*
* @author Ernesto Martínez del Pino
*/
public class CuentaKilometros extends javax.swing.JPanel {
	private double accKilometros = 0.0;
	private LocalDateTime tiempoAnterior = LocalDateTime.now();
	private NumberFormat nf = NumberFormat.getNumberInstance();
	private javax.swing.JLabel EtiqMostrarKilometros;

	public CuentaKilometros() {
		super();
		this.panelConfig();
		this.initComponents();
		this.nf.setMaximumFractionDigits(3);
	}
	
	private void panelConfig() {
		this.setSize(100, 100);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	private void initComponents() {
		this.EtiqMostrarKilometros = new javax.swing.JLabel();
		this.EtiqMostrarKilometros.setText("0 km");
		this.add(this.EtiqMostrarKilometros);
	}
	
	public void updateKilometros(double velocidad) {
		LocalDateTime tiempoAhora = LocalDateTime.now();
		Duration diff = Duration.between(this.tiempoAnterior, tiempoAhora);
		System.out.println("CuentaKilometros: " + diff.getSeconds());
		this.accKilometros += velocidad * (diff.getSeconds() / (60.0 * 60.0));
		this.EtiqMostrarKilometros.setText(this.nf.format(this.accKilometros) + " km");
		this.tiempoAnterior = tiempoAhora;
		this.updateUI();
	}
}
