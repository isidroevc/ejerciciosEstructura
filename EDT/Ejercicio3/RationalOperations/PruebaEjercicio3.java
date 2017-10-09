
import java.util.Random;
import java.util.Scanner;
//import Ejercicio2.*;
public class PruebaEjercicio3 {

    Rational[] r;
    Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    String mensaje, sum, res, mul, div, exp, neg, men, igu, may, noi;
   
    public void inicio() {
        mensaje = "Prueba las prestaciones de la clase Rational\n";
        mensaje += "usando un arreglo de apuntadores a objetos";
        escribir(mensaje);
    }


    public void datos() {
        r = new Rational[3];
        for(int i = 0; i < 3; i++){
            r[i] = new Rational();
            r[i].setNumerator(aleatorio());
            r[i].setDenominator(aleatorio());
        }
    }

    public void calculosRational() {
        int aux;
        boolean result;
        String ri, rj;
        sum = "Sumas: \n";
        res = "Restas:  \n";
        mul = "Multiplicaciones: \n";
        div = "Divisiones: \n";
        exp = "Exponenciaciones: \n";
        for(int i =0; i < 3; i++){
            ri = r[i].toString();
            aux  = i+2;
            exp += r[i];
            exp += " ^ " + aux + " = " + r[i].exponentiation(aux);
            neg += "-" + r[i] + " = " + r[i].negation();
            for(int j = 0; j < 3; j++) {
                rj = r[j].toString();
                sum += ri + " + " + rj + " = " + r[i].addition(r[j]) + "\n";
                res += ri + " - " + rj + " = " + r[i].substraction(r[j]) + "\n";
                mul += ri + " * " + rj + " = " + r[i].multiplication(r[j]) + "\n";
                mul+=  "\n";
                div += ri + " / " + rj + " = " + r[i].division(r[j]) + "\n";
            } 
        }
    }

    public void calculosBoolean(){
        int aux;
        boolean result;
        String ri, rj;
        men = "Menores iguales: \n";
        igu = "Iguales: \n";
        may = "Mayores Iguales: \n";
        noi = "No iguales \n";
        for(int i =0; i < 3; i++){
            ri = r[i].toString();
            for(int j = 0; j < 3; j++) {
                rj = r[j].toString();
                result = r[i].lessEquals(r[j]);
                men += ri + " <= " + rj + " -> " + result + "\n";
                result = r[i].equals(r[j]);
                igu += ri + " == " + rj + " -> "+ result + "\n";
                result = r[i].greaterEquals(r[i]);
                may += ri + " >= " + " -> " + result + "\n";
                result = r[i].notEquals(r[j]);
                noi += ri + " != " + rj + " -> " + result + "\n";
            } 
        }
    }
    public void resultados(int opcion){
        switch(opcion) {
            case 1: resultadosRational(); break;
            case 2: resultadosBoolean();  break;
            case 3: resultadosString(); break;
            case 4: System.exit(0);
        }
    }

    public void resultadosRational() {
        mensaje = "Rational.addition()\n" + sum;
        mensaje += "Rational.substraction()\n" + res;
        mensaje += "Rational.multiplication()\n" + mul;
        mensaje += "Rational.division()\n" + div;
        mensaje += "Rational.negation()\n" + neg;
        escribir(mensaje);
        escribir("Presiona enter para continuar");
        leer();
        navegabilidad();
    }

    public void resultadosBoolean() {
        mensaje = "Rational.exponentiation()\n" + exp;
        mensaje += "Rational.lessEquals()\n" + men;
        mensaje += "Rational.equals()\n"  + igu;
        mensaje += "Rational.greaterEquals()\n" + may;
        mensaje += "Rational.notEquals()\n" + noi;
        escribir(mensaje);
        escribir("Presiona enter para continuar");
        leer();
        navegabilidad();
    }
    public void resultadosString() {
        mensaje = "Rational.toString()\n";
        for(int i = 0; i < 3; i++) {
            mensaje += "r[" + i + "].toString()" + r[i].toString(); 
        }
        escribir(mensaje);
        escribir("Presiona enter para continuar");
        leer();
        navegabilidad();
    }
    public int aleatorio() {
        int al = rand.nextInt() % 99 + 1;
        if(al % 2 == 0) {
            al *= -1;
        }
        return al;
    }

    public void navegabilidad() {
        int opcion = 0;
        mensaje = "1.-Prestaciones Rational\n";
        mensaje += "2.-Prestaciones boolean\n";
        mensaje += "3.-Prestaciones String\n";
        mensaje += "4.-Salir\n";
        mensaje += "Su eleccion: \n";
        escribir(mensaje);
        while(opcion < 1 || opcion > 4) {
            try{opcion = Integer.parseInt(leer());}
            catch(Exception ex) {
                escribir("la opcion debe estar entre 1 y 3");
            }
        }
        resultados(opcion);
    }

    public static void escribir(String s) {
        System.out.println(s);
    }

    public static String leer() {
        System.out.print(">>");
        return scan.nextLine();
    }
    public static void main(String[] args) {
        PruebaEjercicio3 prueba = new PruebaEjercicio3();
        prueba.inicio();
        prueba.datos();
        prueba.calculosRational();
        prueba.calculosBoolean();
        prueba.navegabilidad();

    }
}