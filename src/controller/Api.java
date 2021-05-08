
package controller;

import modelo.modelo;
import vista.vista;
// en este caso creamos la clase principal la main 
public class Api {
      public static void main(String[] args) {
   
       // llamanos la clase controlador         

        modelo model= new modelo();
        vista v = new vista();
        
         controlador Control = new controlador(model, v);
        Control.iniciarAPP();
        v.setVisible(true);
  
    }  
}
