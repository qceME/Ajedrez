/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.caballoajedrez;

/**
 *
 * @author usuario
 */
public class Caballo {                    
                                           //PREGUNTAR DUDA VALIDACIÓN SET/CONSTRUCTORES 
                                           //ENTRE DISTINTAS CLASES (EXCEPCION NULL SI YA SE VALIDA EN LA OTRA CLASE)
    
    private Color color;
    private Posicion posicion;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color==null) throw new IllegalArgumentException("ERROR: No es posible asignar un color nulo.");

        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        if (posicion==null) throw new IllegalArgumentException("ERROR: No es posible asignar una posición nula.");

        this.posicion = posicion;
    }
    
    
    
}
