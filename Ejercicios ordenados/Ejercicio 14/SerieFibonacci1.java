/*
  29 Septiembre 2017
  Ejercicio 14
*/

import currentTimeMillis.currentTimeMillis;

public class SerieFibonacci1{
    int f[]=new int[10];
    String aux;
    currentTimeMillis ctm=new currentTimeMillis();
    
    void inicio(){
        System.out.println("Serie Fibonacci");
    }
    
    void datos(){
        f[0]=0;
        f[1]=1;
        aux=f[0]+","+f[1];
    }
    
    void calculos(){
        for(int i=2; i<f.length; i++){
            f[i]=f[i-1]+f[i-2];
            aux+=","+f[i];
        }
        ctm.calculos();
    }
    
    void resultados(){
        System.out.println(f.length+" términos: "+aux);
        ctm.resultados();
    }
    
    public static void main(String[] args){
        SerieFibonacci1 s1=new SerieFibonacci1();
        s1.inicio();
        s1.datos();
        s1.calculos();
        s1.resultados();
    }
}
