
package modelo;
// nuestro modelo importamos la api de wekw 
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.adtree.PredictionNode;

// creamos la clase modelo es donde van ha estar todos los metodas requeridos 
public class modelo {
    
   public modelo(){
       
   }
   
   // creamos el metod para el algoritmo bayes 
   public String bayes(String url){
         String resultado="";
       try {
            DataSource ds= new DataSource(url);
            Instances ins= ds.getDataSet();
            ins.setClassIndex(3);
            PredictionNode pre=new PredictionNode(3);
            NaiveBayes nb=new NaiveBayes();
            nb.buildClassifier(ins);
           resultado=nb.toString();
           return resultado;
        } catch (Exception ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
            return resultado="error, Archivo no adecuando para este argoritmo";
        } 
   }
   
   
   //cremos el metodo para el algoritmo de arbol de desicion 
   public String  arbol(String url){
       
       String resultado = "";
              try {
            DataSource ds= new DataSource(url);
            Instances ins= ds.getDataSet();
            ins.setClassIndex(3);
             PredictionNode pre=new PredictionNode(3);
            J48 arbol=new J48();
            arbol.buildClassifier(ins);
               arbol.globalInfo();
               resultado=arbol.toString();
             return resultado;
        } catch (Exception ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
              return resultado="error, Archivo no adecuando para este argoritmo"; 
        }
           
   }
   
    //cremos el metodo para el algoritmo de regresion lineal 
   public String  regresionL(String url){
       
       String resultado = "";
              try {
            DataSource ds= new DataSource(url);
              Instances ins= ds.getDataSet();
             ins.setClassIndex(3);
             PredictionNode pre=new PredictionNode(3);
             LinearRegression lr=new LinearRegression();
            lr.buildClassifier(ins);
             resultado=lr.toString();
             return resultado;
        } catch (Exception ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
              return resultado="error, Archivo no adecuando para este argoritmo"; 
        }
           
   }
   
   
   public String  regresionMp(String url){
       
       String resultado = "";
              try {
            DataSource ds= new DataSource(url);
              Instances ins= ds.getDataSet();
             ins.setClassIndex(3);
             PredictionNode pre=new PredictionNode(3);
             MultilayerPerceptron mlp=new MultilayerPerceptron();
              mlp.buildClassifier(ins);
             resultado=mlp.toString();
             return resultado;
        } catch (Exception ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
              return resultado="error, Archivo no adecuando para este argoritmo"; 
        }
           
   }
}
