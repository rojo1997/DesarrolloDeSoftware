/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.intercepcion;

/**
 *
 * @author ernes
 */
public class Client {
    private FilterManager manager;
    
    public void sendRequest(double revoluciones, EstadoMotor estadoMotor){
        this.manager.requestFilter(revoluciones, estadoMotor);
    }
}
