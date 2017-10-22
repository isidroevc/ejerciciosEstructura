import java.io.FileOutputStream;
import java.util.Random;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.io.IOException;
//import Rational;
public class Prueba {

    private Scanner sc = new Scanner(System.in);
    String sum, res, mul, div, exp, neg;
    String leq, eq, geq;
    String mensaje;
    Rational[] r;
    RandomAccessFile raf;
    FileOutputStream fos;
    int c = 0;
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
    void abrirArchivoEntrada() throws IOException {
        raf = new RandomAccessFile("RationalsData.txt", "r");
    }
    void abrirFlujoSalida() throws IOException {
        fos = new FileOutputStream("Reporte.txt");
    }
    void datos() throws IOException, Exception{
        String line;
        abrirArchivoEntrada();
        while(raf.readLine() != null)
            c++;
        raf.seek(0);
        r = new Rational[c];
        for(int i = 0; i < c; i++) 
            r[i] = Rational.parse(raf.readLine());
        raf.close();
    }
    void calculosRational() {
        sum = "Suma el rational actual con otro y retorna la suma\n";
        res = "Resta el rational actual con otro y retorna la resta\n";
        mul = "Multiplica el rational actual con otro y retorna resultado\n";
        div = "Divide el rational actual con otro y retorna el resultado\n";
        neg = "Retorna el negativo del rational actual\n";
        exp = "Eleva el rational actual a la n \n";
        for(int i = 1; i < c; i++){
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
    void resultados() throws IOException {
        mensaje = "Resultados Tipo Rational\n";
        mensaje += sum + res + mul + div + neg + exp;
        mensaje += "Resultdos Tipo Boolean\n";
        mensaje += leq + eq + geq;
        abrirFlujoSalida();
        fos.write(mensaje.getBytes());
        fos.close();
        escribir("Listo, puede revisar el archivo Reporte.txt");
    }
    public static void main(String[] args) {
        Prueba demo = new Prueba();
        demo.inicio();
        try {
            demo.datos();
            demo.calculosRational();
            demo.calculosBoolean();
            demo.resultados();
        } catch(Exception e){
            demo.escribir("Ha ocurrido un error: " + e.getMessage());
            System.exit(0);
        }
    }
}