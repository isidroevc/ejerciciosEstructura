/**
    Instituto Tecnológico de León.
    Ingenieria En Sistemas Computacionales.
    Estructura de datos.
    Maestro: Ing. Cirino Silva Tovar.
    Alumno Vásquez Cortés Isidro Emmanuel
    Ejercicio 15 y 16.
    Fecha de elaboración 22/10/2017
 */

public class SerieFibonacci{
    int c, f0, f1, fn, fr;
    long tInicioR, tInicioI, tFinR, tFinI, tR, tI;
    String aux, aux1;
    
    void inicio(){
        System.out.println("Serie Fibonacci");
    }
    
    void datos(){
        f0=0;
        f1=1;
        c=30;
        aux="Iterativamente: "+f0;
        fr=0;
        aux1="Recursivamente: 0";
    }
    
    void calculos(){
        iterativo(c);
        tInicioR = System.currentTimeMillis();
        recursivo(c);
        tFinR = System.currentTimeMillis();
        tR = tFinR - tInicioR;
    }
    
    public String iterativo(int n){
        tInicioI = System.currentTimeMillis();
        for(int i=2; i<c; i++){
            fn=f0+f1;
            aux+=","+fn;
            f0=f1;
            f1=fn;
        }
        tFinI = System.currentTimeMillis();
        tI = tFinI - tInicioI;
        return aux;
    }
    
    public int recursivo(int n){
        if(n<=1)
            fr=n;
        else{
            fr=recursivo(n-1)+recursivo(n-2);
        }
        return fr;
    }
    
    public String recursivoP(){
        for(int i=1; i<c; i++){
            aux1+=","+recursivo(i);
        }
        return aux1;
    }
    
    void resultados(){
        System.out.println(c+" términos");
        System.out.println(aux);
        System.out.println(recursivoP());
        System.out.println("Tiempo recursivo: " + tR);
        System.out.println("Tiempo iterativo: " + tI);
    }
    
    public static void main(String[] args){
        SerieFibonacci s=new SerieFibonacci();
        s.inicio();
        s.datos();
        s.calculos();
        s.resultados();
    }
}
