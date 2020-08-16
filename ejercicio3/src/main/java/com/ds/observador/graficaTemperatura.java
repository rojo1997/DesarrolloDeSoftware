/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.observador;
import java.util.Observable;
import java.util.Observer;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.*;
/**
 *
 * @author ernes
 */
public class graficaTemperatura extends javax.swing.JFrame implements Observer {
    private int tiempo = 0;
    private XYSeries series;
    private XYSeriesCollection collection;
    private JFreeChart chart;
    private ChartPanel chartPanel;
    
    /**
     * Creates new form grafica
     */
    public graficaTemperatura() {
        //initComponents();
        setTitle("Grafica temperatura");
        setSize(800,700);
        this.jPanel1 = new javax.swing.JPanel();
        getContentPane().add(this.jPanel1);
        this.series = new XYSeries("Temperatura");
        this.collection = new XYSeriesCollection(this.series);
        this.chart = ChartFactory.createXYLineChart(
                "Grafica Temperatura", 
                "Tiempo", 
                "Temperatura", 
                this.collection,
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );
        this.chartPanel = new ChartPanel(this.chart);
        this.jPanel1.add(this.chartPanel);
        java.awt.EventQueue.invokeLater(() -> {
            graficaTemperatura.this.setVisible(true);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /*@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>  */                      

    

    // Variables declaration - do not modify                     
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   

    @Override
    public void update(Observable o, Object arg) {
        this.series.add(
            this.tiempo,
            (int) ((ObservableTemperatura) o).getTemperatura()
        );
        this.tiempo += 1;
    }
}