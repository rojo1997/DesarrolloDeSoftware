package com.ds.intercepcion;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JToggleButton;

public class app extends javax.swing.JFrame implements Runnable {
	private Salpicadero salpicadero = new Salpicadero();
	private PanelBotones panelBotones;
	
	public app() {
		super("Ejercicio 4");
		FilterManager filterManager = new FilterManager();
		filterManager.addFilter(new FiltroCalcularVelocidad());
		filterManager.addFilter(new FiltroRepercutirRozamiento());
		filterManager.setTarget(new Target(this.salpicadero));
		this.panelBotones = new PanelBotones(new Client(filterManager));
		
		
		this.windowsConfig();
        this.initComponents();
    }
	
	private void windowsConfig() {
		// Localización de la ventana
        this.setSize(600,125);
        // Configuramos el layout
        GridLayout experimentLayout = new GridLayout(2,1);
        experimentLayout.addLayoutComponent("Salpicadero", this.salpicadero);
        experimentLayout.addLayoutComponent("PanelBotones", this.panelBotones);
        // Añadimos layout
        this.setLayout(experimentLayout);
        // Fijamos la dimensiones de la pantalla
        this.setResizable(false);
        // Comportamiento de cierre
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	}
	
	private void initComponents() {
		this.add(this.salpicadero);
		this.add(this.panelBotones);
	}
	
	public void run() {
		this.panelBotones.updateLoop();
	}
	
	public static void main(String args[]) {
		app my_app = new app();
		Thread th = new Thread(my_app);
		th.start();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	my_app.setVisible(true);
            }
        });
    }
}
