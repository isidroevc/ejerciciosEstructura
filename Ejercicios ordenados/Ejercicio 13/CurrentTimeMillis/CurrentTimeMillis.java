/*
  29 Septiembre 2017
  Ejercicio 13: currentTimeMillis()
*/


public class CurrentTimeMillis{
    long inicio;
    long fin, totalM;
    String aux;
    
    public void inicio(){
        System.out.println("Tiempo de ejecución de un programa");
    }
    
    public void datos(){
        inicio=System.currentTimeMillis();
    }
    
    public void calculos(){
        fin=System.currentTimeMillis();
        totalM=fin-inicio;
    }
    
    public void resultados(){
        aux="Tiempo transcurrido: "+totalM+" milisegundos.";
        System.out.println(aux);
    }
    
    public static void main(String[] args){
        CurrentTimeMillis  ctm = new CurrentTimeMillis();
        
        ctm.inicio();
        ctm.datos();
        ctm.calculos();
        ctm.resultados();
    }
}
