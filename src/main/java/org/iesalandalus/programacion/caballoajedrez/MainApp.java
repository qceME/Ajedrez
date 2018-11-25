package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
    private static Caballo caballo;
	
    public static void main(String[] args) 
    {
        // TODO code application logic here
        int opcion;
        
        do
        {
            //Mostramos el menú con las distintas opciones del programa
            mostrarMenu();
            
            //Pedimos al usuario que elija una opción
            opcion=elegirOpcion();
            
            //En función de la opción elegida ejecutamos uno u otro método
            
            ejecutarOpcion(opcion);
        }while (opcion!=0);
        
        System.out.println("Muchas gracias por su trabajo");
        
        
    }
    
        
 private  static void mostrarMenu()
    {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Programa para la simulación del movimiento de un caballo en un tablero de ajedrez");
	System.out.println("--------------------------------------------------------------------------------------");
	System.out.println("");
	System.out.println("1.- Crear un caballo por defecto.");
	System.out.println("2.- Crear un caballo de un color.");
	System.out.println("3.- Crear un caballo de un color en una columna inicial válida.");      	
        System.out.println("4.- Mover el caballo");
        System.out.println("");
	System.out.println("0.- Salir.");
	System.out.println("");
    }
 
 
 private static int elegirOpcion()
    {
        int opcion;
        
        //Comprobamos que la opcion elegida es válida
        do
        {
            System.out.println("Elige una opción (0-4): ");
            opcion=Entrada.entero();
        }while(opcion<0 || opcion>5);
        
        return opcion;
    }
 
  private static void ejecutarOpcion(int opcion)
    {
        switch(opcion)
        {
            case 1: //Crear un caballo por defecto
                crearCaballoPorDefecto();
                break;
            case 2: //Crear caballo de un color                
                crearCaballoColor();
                break;
            case 3: //Crear un caballo de un color en una columna inicial válida
                crearCaballoColumna();
                break;
            case 4: //Mover el caballo
                moverCaballo();
                break;
            default:
                break;
        }
    }
      private static void crearCaballoPorDefecto()
    {
        caballo=new Caballo();
        System.out.println("Caballo creado correctamente");
        System.out.println(caballo);
        System.out.println("-------------------------------");
        System.out.println("");
        System.out.println("");
        
        
      
        
    }
      
      private static void crearCaballoColor()
    {
        Color color;
        color=elegirColor();
        
        try
        {                
            caballo=new Caballo(color);
            System.out.println(caballo);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("ERROR: El caballo no ha sido creado.");
            System.out.println(e.getMessage());                          
        }
        
    }
     
       private static Color elegirColor()
    {
        int elegirColor;
        Color color=Color.BLANCO;
        
        do
        {
            System.out.println("Introduzca el COLOR del caballo (0.BLANCO, 1.NEGRO): ");
            elegirColor=Entrada.entero();       
        }while (elegirColor!=0 && elegirColor!=1);
        
        switch (elegirColor)
        {
            case 0: //BLANCO
                color=Color.BLANCO;
                break;
            case 1: //NEGRO
                color=Color.NEGRO;
                break;
        }
        
        return color;
    }
        private static void crearCaballoColumna()
    {
        char columna;
        Color color;
        
        columna= elegirColumna();
        color=elegirColor();
       
        
        try
        {                
            caballo=new Caballo(color,columna);
            System.out.println(caballo);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("ERROR: El caballo no ha sido creado.");
            System.out.println(e.getMessage());                          
        }
        
        
    }
        public static char elegirColumna(){
        char columna;
          do{
            System.out.println("Intruduzca la columna g o b, por favor");
            columna=Entrada.caracter();
          }while (columna!='g' && columna!='b');
          return columna;
        }
        
        
        
        public static void moverCaballo(){

            if (caballo==null)
            {   
                System.out.println(" Debes crear un caballo. ");
             
            }
            else
            
        try {
            int mover;
            do{
                System.out.println(" Elija su movimiento ");
                System.out.println("------------------------------------");
                System.out.println("1. Arriba-Derecha");
                System.out.println("2. Arriba-Izquierda");
                System.out.println("3. Derecha-Abajo");
                System.out.println("4. Derecha-Arriba");
                System.out.println("5. Abajo-Izquierda");
                System.out.println("6. Abajo-Derecha");
                System.out.println("7. Izquierda-Arriba");
                System.out.println("8. Izquierda-Abajo");
                System.out.println("------------------------------------");
                 
               mover=Entrada.entero();
            } while( mover < 1 || mover>8);     
           
            switch(mover){
                case 1:
                    caballo.mover(Direccion.DERECHA_ARRIBA);
                    break;
                case 2:
                    caballo.mover(Direccion.ARRIBA_IZQUIERDA);
                    break;
                case 3:
                    caballo.mover(Direccion.DERECHA_ABAJO);
                    break;
                case 4:
                    caballo.mover(Direccion.DERECHA_ARRIBA);
                    break;
                case 5:
                    caballo.mover(Direccion.ABAJO_IZQUIERDA);
                    break;
                case 6:
                    caballo.mover(Direccion.ABAJO_DERECHA);
                    break;
                case 7:
                    caballo.mover(Direccion.IZQUIERDA_ARRIBA);
                    break;
                case 8:
                    caballo.mover(Direccion.IZQUIERDA_ABAJO);
                    break;
                default:
                    throw new OperationNotSupportedException("Movimiento erróneo");
            }
            System.out.println(caballo);
        } catch (IllegalArgumentException e)
        {
            System.out.println("ERROR: El caballo no ha sido creado.");
            System.out.println(e.getMessage()); 
        } catch (OperationNotSupportedException e)
        {
            System.out.println("ERROR: Movimiento incorrecto.");
            System.out.println(e.getMessage()); 
        }

        }
}


/*crear un caballo por defecto,
crear un caballo de un color,
crear un caballo de un color en una columna inicial válida,
mover el caballo
y salir.*/