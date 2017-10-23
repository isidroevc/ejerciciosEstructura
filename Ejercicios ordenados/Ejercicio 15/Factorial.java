/**
    Instituto Tecnológico de León.
    Ingenieria En Sistemas Computacionales.
    Estructura de datos.
    Maestro: Ing. Cirino Silva Tovar.
    Alumno Vásquez Cortés Isidro Emmanuel
    Ejercicio 15.
    Fecha de elaboración 22/10/2017
 */
import java.util.Scanner;
public class Factorial{
    int fi, fr, n;
    Scanner sc = new Scanner(System.in);
    void inicio(){
        System.out.println("Calcular factorial de n");
    }
    
    void datos(){
        n = -1;
        while(n < 0){
            System.out.println("Ingrese el valor n");
            try{n = Integer.parseInt(sc.nextLine());}
            catch(Exception e){
                System.out.println("Ingrese el valor n");
                n = -1;
            }
        }
        fi=1;
        fr=1;
    }
    
    void calculos(){
        factI(n);
        factR(n);
    }
    
    public int factI(int n){
        if(n==0)
            fi=1;
        else
            for(int i=1; i<(n+1); i++)
                fi=fi*i;
        return fi;
    }
    
    public int factR(int n){
        if(n==0)
            fr=1;
        else
            fr=n*factR(n-1);
        return fr;
    }
    
    void resultados(){
        System.out.println("Iterativamente: "+fi);
        System.out.println("Recursivamente: "+fr);
    }
    
    public static void main(String[] args){
        Factorial f=new Factorial();
        f.inicio();
        f.datos();
        f.calculos();
        f.resultados();
    }
}
