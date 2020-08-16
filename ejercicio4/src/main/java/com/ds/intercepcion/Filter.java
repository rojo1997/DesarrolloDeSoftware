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
public interface Filter {
    public double execute(double revoluciones, EstadoMotor estadoMotor);
}
