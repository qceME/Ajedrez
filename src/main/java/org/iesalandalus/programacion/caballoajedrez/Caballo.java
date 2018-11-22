/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.caballoajedrez;

import java.util.Objects;
import javax.naming.OperationNotSupportedException;

/**
 *
 * @author usuario
 */
public class Caballo {                    
                                           //PREGUNTAR DUDA VALIDACIÓN SET/CONSTRUCTORES 
                                           //ENTRE DISTINTAS CLASES (EXCEPCION NULL SI YA SE VALIDA EN LA OTRA CLASE)
    
    private Color color;
    private Posicion posicion;
    
    
    public Caballo()
    {
        this.color=Color.NEGRO;
        this.posicion=new Posicion(8,'b');
    }

   
    public Caballo(Color color)
    {
        if (color==null) throw new IllegalArgumentException("ERROR: Has pasado un parametro nulo");
        
        if (color==Color.NEGRO)
        {
           this.color=color;
           this.posicion=new Posicion(8,'b');
        }
        if (color==Color.BLANCO)
        {
            this.color=color;
            this.posicion=new Posicion(1,'b');
        }
    }
    
    public Caballo(Color color, char columna)
    {
        if (columna=='b' && columna=='g')
        {
            if (color==Color.BLANCO)
            {    
               this.posicion=new Posicion(1,columna);
               this.color=color;
            }
            else
            {   
                this.posicion=new Posicion(8,columna);
                this.color=color;
            }    
                
        }    
        
        else throw new IllegalArgumentException("ERROR: Has pasado una columna errónea");
        
    }
    
    public Caballo(final Caballo caballoClon)
    {
        if (caballoClon==null) throw new IllegalArgumentException("ERROR: Has pasado un parametro nulo");
        this.color=caballoClon.color;
        this.posicion=caballoClon.posicion;
    }        

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
    
    public void Mover(Direccion nuevaDir) throws OperationNotSupportedException 
    {
        int fila=posicion.getFila(),nuevaFila;
        char columna= posicion.getColumna(),nuevaColumna;
                
        switch (nuevaDir)
        {
            case ARRIBA_IZQUIERDA:
                    nuevaFila=fila-1;
                    nuevaColumna=(char)(columna+2);
                    posicion.setColumna(nuevaColumna);
                    posicion.setFila(nuevaFila);
                    break;
                    
            case ARRIBA_DERECHA:
                    nuevaFila=fila+1;
                    nuevaColumna=(char)(columna+2);
                    posicion.setColumna(nuevaColumna);
                    posicion.setFila(nuevaFila);
                    break;
                    
            case DERECHA_ARRIBA:
                    nuevaFila=fila+2;
                    nuevaColumna=(char)(columna+1);
                    posicion.setColumna(nuevaColumna);
                    posicion.setFila(nuevaFila);
                    break;
                    
            case DERECHA_ABAJO:
                    nuevaFila=fila+2;
                    nuevaColumna=(char)(columna-1);
                    posicion.setColumna(nuevaColumna);
                    posicion.setFila(nuevaFila);
                    break;
                    
            case ABAJO_DERECHA:
                    nuevaFila=fila+1;
                    nuevaColumna=(char)(columna-2);
                    posicion.setColumna(nuevaColumna);
                    posicion.setFila(nuevaFila);
                    break;
                    
            case ABAJO_IZQUIERDA:
                    nuevaFila=fila-1;
                    nuevaColumna=(char)(columna-2);
                    posicion.setColumna(nuevaColumna);
                    posicion.setFila(nuevaFila);
                    break;
                    
            case IZQUIERDA_ARRIBA:
                    nuevaFila=fila-2;
                    nuevaColumna=(char)(columna+1);
                    posicion.setColumna(nuevaColumna);
                    posicion.setFila(nuevaFila);
                    break;
                    
            case IZQUIERDA_ABAJO:
                    nuevaFila=fila-2;
                    nuevaColumna=(char)(columna-1);
                    posicion.setColumna(nuevaColumna);
                    posicion.setFila(nuevaFila);
                    break;        
            }
    }    
    
      
    
    
}
