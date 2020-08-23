/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.intercepcion;

import java.awt.Color;

/**
 *
 * @author ernes
 */
public class PanelBotones extends javax.swing.JFrame {

    public PanelBotones() {
        initComponents();
    }

    private void initComponents() {
    	// Declaramos los objetos de visualización
    	this.BotonAcelerar = new javax.swing.JToggleButton();
    	this.BotonEncender = new javax.swing.JToggleButton(); 
    	this.BotonFrenar = new javax.swing.JToggleButton();
    	this.EtiqMostrarEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        this.BotonAcelerar.setBounds(5, 5, 140, 40);
        this.BotonEncender.setBounds(5 + 140, 5, 140, 40);
        this.BotonFrenar.setBounds(5 + 140 * 2, 5, 140, 40);
        this.EtiqMostrarEstado.setBounds(5, 45, 140, 40);
        
        // Localización del frame
        this.setBounds(2, 2, 500, 150);
        
        // Añadir botones y texto
        this.add(this.BotonAcelerar);
        this.add(this.BotonEncender);
        this.add(this.BotonFrenar);
        this.add(this.EtiqMostrarEstado);
        
        this.setLayout(null);
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelBotones().setVisible(true);
            }
        });
    }

    private javax.swing.JToggleButton BotonAcelerar, BotonEncender, BotonFrenar;
    private javax.swing.JLabel EtiqMostrarEstado;
    
    synchronized private void BotonAcelerarActionPerformed(java.awt.event.ActionEvent evt) {
    	System.out.println("Acelerar");
    	if (this.BotonEncender.isSelected() && !this.BotonFrenar.isSelected()) {
    		if (this.BotonAcelerar.isSelected()) {
    			this.EtiqMostrarEstado.setText("ACELERANDO");
        		this.BotonAcelerar.setText("Soltar acelerador");
    		}
    		else {
    			this.BotonAcelerar.setText("Acelerar");
    			this.EtiqMostrarEstado.setText("ENCENDIDO");
    		}
    	}
    	else {
    		this.BotonAcelerar.setSelected(false);
    	}
    }
    
    synchronized private void BotonEncenderActionPerformed(java.awt.event.ActionEvent evt) {
    	System.out.println("Encender");
    	if (this.BotonEncender.isSelected()) {
    		this.BotonEncender.setText("Apagar");
    		this.BotonEncender.setForeground(Color.RED);
    		this.EtiqMostrarEstado.setText("ENCENDIDO");
    	}
    	else {
    		this.EtiqMostrarEstado.setText("APAGADO");
    		this.BotonEncender.setText("Encender");
    		this.BotonEncender.setForeground(Color.GREEN);
    	}
    }
    
    synchronized private void BotonFrenarActionPerformed(java.awt.event.ActionEvent evt) {
    	System.out.println("Frenar");
    	if (this.BotonEncender.isSelected() && !this.BotonAcelerar.isSelected()) {
    		if (this.BotonFrenar.isSelected()) {
    			this.EtiqMostrarEstado.setText("FRENANDO");
        		this.BotonFrenar.setText("Soltar freno");
    		}
    		else {
    			this.BotonFrenar.setText("Frenar");
    			this.EtiqMostrarEstado.setText("ENCENDIDO");
    		}
    	}
    	else {
    		this.BotonFrenar.setSelected(false);
    	}
    }
}
