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
    public Posicion (int fila, char columna)
    {
        setFila(fila);
        setColumna(columna);
       
    }        
    //no lanzamos excepciones ya que las validaciones se realizan en los set de ambos atributos que se piden
    //y de esta forma si le pasasemos un parámetro incorrecto saltaría las excepciones de los setters
    
    public Posicion(final Posicion clonaAtrib)
    {
        if (clonaAtrib==null) throw new IllegalArgumentException("ERROR: No es posible copiar una posición nula.");
        
        this.fila=clonaAtrib.fila;
        this.columna=clonaAtrib.columna;
    }        
    
//métodos get y set
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        if ((fila>=1) && (fila<=8))
          { 
            this.fila = fila;
          }
        else
          {throw new IllegalArgumentException("ERROR: Fila no válida.");            
          }  
            
        
    }

    public char getColumna() {
        return columna;
    }

    public void setColumna(char columna) {
        if (columna=='a' || columna=='b' || columna=='c' || 
            columna=='d' || columna=='e' || columna=='f' || columna=='g' || columna=='h')
          
            this.columna = columna;
          
        else{
          throw new IllegalArgumentException("ERROR: Columna no válida.");           
        }
    }

  //método equals

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Posicion other = (Posicion) obj;
        if (this.fila != other.fila) {
            return false;
        }
        if (this.columna != other.columna) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[fila=" + fila + ", columna=" + columna+"]";
    }

    
    
}
