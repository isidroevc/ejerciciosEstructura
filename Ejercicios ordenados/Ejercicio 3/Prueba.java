import java.util.Random;
import java.util.Scanner;
//import Rational;
public class Prueba {
    private Scanner sc = new Scanner(System.in);
    String sum, res, mul, div, exp, neg;
    String leq, eq, geq;
    String mensaje;
    Rational[] r;
    void escribir(String s){
        System.out.println(s);
    }
    String leer() {
        System.out.print(">>");
        return sc.nextLine();
    }
    void inicio(){
        escribir("Este programa prueba las prestaciones de la clase rational");
    }
    void datos() {
        Random rand = new Random();
        int numerator, denominator;
        r = new Rational[3];
        for(int i = 0; i < 3; i++){
            numerator = rand.nextInt() % 98;
            denominator = rand.nextInt() % 98;
            r[i] = new Rational(numerator, denominator);
        }
    }
    void calculosRational() {
        sum = "Suma el rational actual con otro y retorna la suma\n";
        res = "Resta el rational actual con otro y retorna la resta\n";
        mul = "Multiplica el rational actual con otro y retorna resultado\n";
        div = "Divide el rational actual con otro y retorna el resultado\n";
        neg = "Retorna el negativo del rational actual\n";
        exp = "Eleva el rational actual a la n \n";
        for(int i = 1; i < 3; i++){
            sum += r[0] + " + "  + r[i] + " = " + r[0].addition(r[i]) + "\n";
            res += r[0] + " - "  + r[i] + " = " + r[0].substraction(r[i]) + "\n";
            mul += r[0] + " * "  + r[i] + " = " + r[0].multiplication(r[i]);
            mul  += "\n";
            div += r[0] + " / "  + r[i] + " = " + r[0].division(r[i]) + "\n";
            neg += "negation " + r[i] + " = "  + r[i].negation() + "\n";
            exp += r[i] + " ^ " + (i + 2) + " = " + r[i].exponentiation(i + 2);
            exp += "\n";
        }
    }

    void calculosBoolean(){
        leq = "Retorna true si el Rational actual es menor igual al otro\n";
        eq = "Retorna true si el Rational actual es exactamente igual al otro\n";
        geq = "Retorna true si el Rational actual es mayor o igual al otro\n";
        for(int i = 1; i < 3; i++) {
            leq += r[0] + " <= " + r[i] + " -> " + r[0].lessEquals(r[i])+ "\n";
            eq += r[0] + " == " + r[i] + " -> " + r[0].equals(r[i]) + "\n";
            geq += r[0] + " >= " + r[i] + " -> " + r[0].greaterEquals(r[i])+ "\n";
        }
    }

    void resultadosRational(){
        mensaje = sum + res + mul + div + neg + exp;
        escribir("Resultados de tipo Rational\n");
        escribir(mensaje);
        escribir("Presione enter para continuar al menu");
        leer();
        menu();
    }
    void resultadosBoolean() {
        mensaje = leq + eq + geq;
        escribir("Resultados de tipo Boolean");
        escribir(mensaje);
        escribir("Presione enter para continuar al menu");
        leer();
        menu();
    }
    void menu(){
        int op = 0;
        mensaje = "Que resultados va a desplegar?\n";
        mensaje += "1.- Resultados Rational\n";
        mensaje += "2.-Resultados Boolean\n";
        mensaje += "3.-Salir\n";
        escribir(mensaje);
        while(op < 1 || op > 3){
            try {op = Integer.parseInt(leer());}
            catch(Exception ex) {
                escribir("Elija una opcion del 1 al 3");
            }
        }
        switch(op){
            case 1: calculosRational(); 
                    resultadosRational();
            break;
            case 2: calculosBoolean();
                    resultadosBoolean();
            break;
            case 3: System.exit(0); break;
        }
    }

    public static void main(String[] args) {
        Prueba demo = new Prueba();
        demo.inicio();
        demo.datos();
        demo.menu();
    }

}