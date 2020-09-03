/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.intercepcion;

import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;


/**
 *
 * @author Ernesto Martínez del Pino
 */
public class PanelBotones extends javax.swing.JPanel {
	private javax.swing.JToggleButton BotonAcelerar, BotonEncender, BotonFrenar;
    private javax.swing.JLabel EtiqMostrarEstado;
    private Client cliente;
    private Coche coche = new Coche();
    private static int UPDATE_TIME = 1;

    public PanelBotones(Client cliente) {
    	super();
    	this.panelConfig();
        this.initComponents();
        this.cliente = cliente;
    }
    
    private void panelConfig() {
    	this.setBorder(BorderFactory.createLineBorder(Color.black));
    	GridLayout experimentLayout = new GridLayout(1,4);
    	experimentLayout.addLayoutComponent("BotonAcelerar", this.BotonAcelerar);
    	experimentLayout.addLayoutComponent("BotonEncender", this.BotonEncender);
    	experimentLayout.addLayoutComponent("BotonFrenar", this.BotonFrenar);
    	experimentLayout.addLayoutComponent("EtiqMostrarEstado", this.EtiqMostrarEstado);
    	this.setLayout(experimentLayout);
    }

    private void initComponents() {
    	// Declaramos los objetos de visualización
    	this.BotonAcelerar = new javax.swing.JToggleButton();
    	this.BotonEncender = new javax.swing.JToggleButton(); 
    	this.BotonFrenar = new javax.swing.JToggleButton();
    	this.EtiqMostrarEstado = new javax.swing.JLabel();

        // Agregamos la etiquetas a los botones
        this.BotonAcelerar.setText("Acelerar");
        this.BotonEncender.setText("Encender");
        this.BotonFrenar.setText("Frenar");
        this.BotonEncender.setForeground(Color.GREEN);
        this.EtiqMostrarEstado.setText("APAGADO");
        
        // Agregamos los disparadores
        this.BotonAcelerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	BotonAcelerarActionPerformed(evt);
            }
        });
        
        this.BotonEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	BotonEncenderActionPerformed(evt);
            }
        });
        
        this.BotonFrenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	BotonFrenarActionPerformed(evt);
            }
        });
        
        // Localización de los botones y texto
        this.BotonAcelerar.setSize(140, 40);
        this.BotonEncender.setSize(140, 40);
        this.BotonFrenar.setSize(140, 40);
        this.EtiqMostrarEstado.setSize(140, 40);
        
        
        // Añadir botones y texto
        this.add(this.BotonAcelerar);
        this.add(this.BotonEncender);
        this.add(this.BotonFrenar);
        this.add(this.EtiqMostrarEstado);
        
    }
	
    synchronized private void BotonAcelerarActionPerformed(java.awt.event.ActionEvent evt) {
    	System.out.println("Acelerar");
    	if (this.BotonEncender.isSelected() && !this.BotonFrenar.isSelected()) {
    		if (this.BotonAcelerar.isSelected()) {
    			this.EtiqMostrarEstado.setText("ACELERANDO");
        		this.BotonAcelerar.setText("Soltar acelerador");
        		this.coche.setEstadoMotor(EstadoMotor.ACELERANDO);
    		}
    		else {
    			this.BotonAcelerar.setText("Acelerar");
    			this.EtiqMostrarEstado.setText("ENCENDIDO");
    			this.coche.setEstadoMotor(EstadoMotor.ENCENDIDO);
    		}
    	}
    	else {
    		this.BotonAcelerar.setSelected(false);
    	}
    	this.coche.setRevoluciones(this.cliente.sendRequest(this.coche.getRevoluciones(), this.coche.getEstadoMotor()));
    }
    
    synchronized private void BotonEncenderActionPerformed(java.awt.event.ActionEvent evt) {
    	System.out.println("Encender");
    	if (this.BotonEncender.isSelected()) {
    		this.BotonEncender.setText("Apagar");
    		this.BotonEncender.setForeground(Color.RED);
    		this.EtiqMostrarEstado.setText("ENCENDIDO");
    		this.coche.setEstadoMotor(EstadoMotor.ENCENDIDO);
    	}
    	else {
    		this.EtiqMostrarEstado.setText("APAGADO");
    		this.BotonEncender.setText("Encender");
    		this.BotonEncender.setForeground(Color.GREEN);
    		this.BotonAcelerar.setSelected(false);
    		this.BotonFrenar.setSelected(false);
    		this.BotonAcelerar.setText("Acelerar");
    		this.BotonFrenar.setText("Frenar");
    		this.coche.setEstadoMotor(EstadoMotor.APAGADO);
    	}
    	this.coche.setRevoluciones(this.cliente.sendRequest(this.coche.getRevoluciones(), this.coche.getEstadoMotor()));
    }
    
    synchronized private void BotonFrenarActionPerformed(java.awt.event.ActionEvent evt) {
    	System.out.println("Frenar");
    	if (this.BotonEncender.isSelected() && !this.BotonAcelerar.isSelected()) {
    		if (this.BotonFrenar.isSelected()) {
    			this.EtiqMostrarEstado.setText("FRENANDO");
        		this.BotonFrenar.setText("Soltar freno");
        		this.coche.setEstadoMotor(EstadoMotor.FRENADO);
    		}
    		else {
    			this.BotonFrenar.setText("Frenar");
    			this.EtiqMostrarEstado.setText("ENCENDIDO");
    			this.coche.setEstadoMotor(EstadoMotor.ENCENDIDO);
    		}
    	}
    	else {
    		this.BotonFrenar.setSelected(false);
    	}
    	this.coche.setRevoluciones(this.cliente.sendRequest(this.coche.getRevoluciones(), this.coche.getEstadoMotor()));
    	
    }

    public void updateLoop() {
    	while (true) {
    		try {
                TimeUnit.SECONDS.sleep(PanelBotones.UPDATE_TIME);
            } catch (InterruptedException ex) {
                Logger.getLogger(PanelBotones.class.getName()).log(Level.SEVERE, null, ex);
            }
    		this.coche.setRevoluciones(this.cliente.sendRequest(this.coche.getRevoluciones(), this.coche.getEstadoMotor()));
    		System.out.println("Revoluciones: " + this.coche.getRevoluciones());
    	}
    }
}
