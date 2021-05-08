
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.modelo;
import vista.vista;


public class controlador implements ActionListener{
    // en esta clase vamos a unir la  vista con la clase modelo de nuestra appi
     private modelo model;
     private vista  v;

    public controlador(modelo model, vista v) {
        // se crea el controlador de esta clase 
        this.model = model;
        this.v = v;
        // obtenemos los eventod click 
        v.btnCargar.addActionListener(this);
        v.btnexaminar.addActionListener(this);
        v.btnsalir.addActionListener(this);
      
    }
     
    // metodo inicial de arranque de la app donde creamos el titulo, centralizamos la ventana y llamamos el metodo add combox
    //y desabilitamos al iniciar el boton cargar  modelo para que oblige al usuaro ingresar o cargar un archivo primero
    public void iniciarAPP(){
        v.setLocationRelativeTo(null);
        v.setTitle("PRUEBA EL ALGORITMO DE WEKA");
       this.addCombox();
       v.btnCargar.setEnabled(false);
        
    }
     // en esta parte llenamos el ComBox 
    public void addCombox(){
       v.ComboAlgoritmo.addItem("");
       v.ComboAlgoritmo.addItem("Neive Baye");
       v.ComboAlgoritmo.addItem("Arbol Desicion");
       v.ComboAlgoritmo.addItem("Regresion L"); 
        v.ComboAlgoritmo.addItem("MLP"); 
    }
    
    
    // llamanos los metodos de cada algoritmo atravez de la clase modelo 
    public void algoritmoArbol(){
            String url=v.textruta.getText();
        v.txtAreaResultado.setText(model.arbol(url));
    }
    
     public void algoritmoBayes(){
         String url=v.textruta.getText();
        v.txtAreaResultado.setText(model.bayes(url));
    }
    
       public void algoritmoLinelaR(){
             String url=v.textruta.getText();
        v.txtAreaResultado.setText(model.regresionL(url));
    }
       
       
      public void algoritmoLinelaMLP(){
              String url=v.textruta.getText();
        v.txtAreaResultado.setText(model.regresionMp(url));
    }
      
      
      // en este netodo validamos primero si hay un algoritmo seleccionado y despues miramos cual algorimo esta seleccionado 
      // y aplicamos ese algoritmo seleccionado para el archivo cargado 
    public void validarCombox(){
        if(v.ComboAlgoritmo.getSelectedItem()==""){
           JOptionPane.showMessageDialog(null,"EliGA EL ALGORITMO APREDECIR!!!!");    
        }else{
         
         if(v.ComboAlgoritmo.getSelectedItem()=="Neive Baye"){
             JOptionPane.showMessageDialog(null,"Modelo de Neive Bayes Ejecutando");  
             this.algoritmoBayes();
             
               // JOptionPane.showMessageDialog(null, v.ComboAlgoritmo.getSelectedItem());
            }else if(v.ComboAlgoritmo.getSelectedItem()=="Arbol Desicion"){
                   JOptionPane.showMessageDialog(null,"Modelo de Arbol Desicion Ejecutando");  
                this.algoritmoArbol();
            }else if(v.ComboAlgoritmo.getSelectedItem()=="Regresion L"){
                 JOptionPane.showMessageDialog(null,"Modelo de Regrecion Linel Ejecutando");  
               this.algoritmoLinelaR();
            }else{
                 JOptionPane.showMessageDialog(null,"Modelo de Regrecion Multi P Ejecutando"); 
                 this.algoritmoLinelaMLP();
            }
        }
    }
    
    // en este caso las condiciones de cada boton 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==v.btnCargar){
              validarCombox(); 
        }
        
        if(e.getSource()==v.btnexaminar){
            JFileChooser ar=new JFileChooser();
            ar.showOpenDialog(null);
            File archivo=ar.getSelectedFile();
            try{
                FileReader fr= new FileReader(archivo);
                BufferedReader br=new BufferedReader(fr);
                String ruta="";
           
                ruta=archivo.getAbsolutePath();
                v.textruta.setText(ruta);
                 v.btnCargar.setEnabled(true);
                 
               
            }catch(Exception ex){
                
            }
            
        }
       
      if(e.getSource()==v.btnsalir){
        System.exit(0);
      } 
    }
   
}
