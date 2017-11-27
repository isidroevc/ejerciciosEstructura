import java.util.Scanner;
import java.io.StringWriter;
import java.io.PrintWriter;
public class Prueba {
    private static Scanner sc = new Scanner(System.in);
    private String operadores = "^/*+-";
    private String[] operadoresA = {"\\^", "/", "\\*", "\\+", "-", "\\)", "\\("};
    
    public static void escribir(String s) {
        System.out.println(s);
    }

    public static String leer() {
        System.out.print(">>");
        return sc.nextLine();
    }

    public int prioridad(String operador) {
       if(operador.equals("(") || operador.equals(")"))
            return 4;
        if(operador.equals("^"))
            return 3;
        if(operador.equals("*") || operador.equals("/"))
            return 2;
        if(operador.equals("+") || operador.equals("-"))
            return 1;
        return -1;
    }

    public boolean esOperador(String op) {
        return operadores.contains(op);
    }

    public String preparar(String s) {
        //reeemplazar cada uno de los operadores correctamente.
        for(int i = 0; i < 7; i++)
            s = s.replaceAll(operadoresA[i]," " + operadoresA[i] + " ");
        return s;
    }

    public int precedencia(String operador) {
        if(operador.equals("^"))
            return 3;
        if(operador.equals("*")  || operador.equals("/"))
            return 2;
        if(operador.equals("+")  || operador.equals("-"))
            return 1;
        return 10;
    }

    public String postFijo(String infijo) throws Exception {
        Pila<String> entrada; 
        Pila<String> operadores = new Pila<>();
        Pila<String> salida = new Pila<>();
        String actual = "", resultado = "";
        String[] arr ;
        infijo = preparar(infijo);
        
        entrada = new Pila<>(infijo.split(" "));
        while(!entrada.esVacia()) {
            escribir(operadores.toString());
            actual = entrada.cima();
            if(actual.equals("(")) {
                entrada.quitar();
                continue;
            } else if(actual.equals(")") || entrada.longitud() == 1) {
                entrada.quitar();
                salida.insertar(operadores.quitar());
                continue;
            } else if(esOperador(actual)) {
                if(operadores.esVacia()) {
                    operadores.insertar(entrada.quitar());
                    continue;
                } else if( precedencia(actual) == precedencia(operadores.cima()) ) {
                    salida.insertar(operadores.quitar());
                    operadores.insertar(entrada.quitar());
                    continue;
                } else {
                    operadores.insertar(entrada.quitar());
                    continue;
                }
            } else {
                salida.insertar(entrada.quitar());
            }
                
        }

        while(!salida.esVacia()) 
            resultado += salida.quitar() + " ";
        return resultado;
    }

    public static void main(String[] args) {
        Prueba p = new Prueba();
        System.out.println(p.precedencia("+"));
        System.out.println(p.precedencia("-"));
        System.out.println(p.precedencia("*"));
        System.out.println(p.precedencia("/"));
        System.out.println(p.precedencia("^"));
        try { 
            while(true)
            escribir("Result: " + p.postFijo(leer()));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}