/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds.factoriaabstracta;

import java.util.ArrayList;

/**
 *
 * @author ernes
 */
public class FactoriaMontaña implements FactoriaCarreraYBicicleta {

    @Override
    public Carrera crearCarrera(int n) {
        ArrayList<Bicicleta> bicicletas;
        bicicletas = new ArrayList<Bicicleta>(n);
        for (int i=0;i<n;i++){
            bicicletas.add(this.crearBicicleta(i));
        }
        return new CarreraCarretera(bicicletas);
    }

    @Override
    public Bicicleta crearBicicleta(int i) {
        return new BicicletaMontaña(i);
    }
}
