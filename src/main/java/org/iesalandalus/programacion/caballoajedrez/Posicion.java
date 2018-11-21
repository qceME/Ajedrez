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

public class Posicion {
    private int fila;
    private char columna;
    
    
        /**
     * Constructor que inicializa todos los atributos a través de parámetros
     * @param fila fila del tablero 
     * @param columna columna del tablero
     */
    public Posicion (char columna, int fila)
    {
        setColumna(columna);
        setFila(fila);
    }        
    //no lanzamos excepciones ya que las validaciones se realizan en los set de ambos atributos que se piden
    //y de esta forma si le pasasemos un parámetro incorrecto saltaría las excepciones de los setters
    
    public Posicion(final Posicion clonaAtrib)
    {
        if (clonaAtrib==null) throw new IllegalArgumentException("ERROR: Has pasado un parametro nulo");
        
        this.fila=clonaAtrib.fila;
        this.columna=clonaAtrib.columna;
    }        
    
//métodos get y se
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if ((fila>=1) && (fila<=8))
          { 
            this.fila = fila;
          }
        else
          {throw new IllegalArgumentException("El número de fila pasado como parámetro no es válido");            
          }  
            
        
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        if (columna=='a' || columna=='b' || columna=='c' || 
            columna=='d' || columna=='e' || columna=='f' || columna=='g' || columna=='h')
          
            this.columna = columna;
          
        else
          throw new IllegalArgumentException("La columna pasada como parámetro no es válida");            
           
    }
}
