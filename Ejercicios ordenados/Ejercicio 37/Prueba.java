import java.io.RandomAccessFile;
import java.util.Scanner;
public class Prueba {
    private Cola<String> cola;
    private static Scanner entrada = new Scanner(System.in);

    public static void escribir(String s) { System.out.println(s); }

    public static String leer() {
        System.out.print(">> ");
        return entrada.nextLine();
    }

    public void inicio() {
        escribir("Este programa prueba las prestaciones del TDA cola");
    }

    public void datos() throws Exception{
        String arch = "", texto = "", aux = "";
        RandomAccessFile raf;
        while(arch.length() == 0) {
            escribir("Escriba el nombre del archivo a leer");
            arch = leer();
        }
        raf = new RandomAccessFile(arch, "r");
        aux = raf.readLine();
        while(aux != null){
            texto += aux;
            aux = raf.readLine();
        }
        raf.close();
        cola = new Cola<>(texto.split(","));
        escribir("Hey aqui");
        resultados();
    }

    public void resultados() throws Exception {
        String mensaje = "Cola inicial: " + cola.toString() + "\n";
        mensaje += "insertar() inserta un elemento en la cola insertar(A)\n";
        cola.insertar("A");
        mensaje += cola.toString() + "\n" ;
        mensaje += "quitar(i) quita el i-esimo elemento de la cola\n";
        cola.quitar(0);
        mensaje += cola.toString() + "\n";
        mensaje += "esVacia() retorna true si la cola esta vacia\n";
        mensaje += cola.esVacia() + "\n";
        mensaje += "frente() accede al frente de la cola\n";
        mensaje += cola.frente() + "\n" ;
        mensaje += "fin() accede al final de la cola\n";
        mensaje += cola.fin() + "\n";
        escribir(mensaje);
        escribir("Presiona enter para continuar\n");
        leer();
        menu();
    }

    public void menu() throws Exception {
        int op = 0;
        String mensaje = "", aux = "";
        mensaje = "Escriba su opción\n";
        mensaje += "1.- Probar Con otro archivo\n";
        mensaje += "2.- Salir";
        escribir(mensaje);
        while(op > 3 || op  < 1) {
            escribir("Escriba su opcion");
            aux = leer();
            try { op = Integer.parseInt(aux);} 
            catch(Exception ex) {} 
        }
        if(op == 1) datos();
        else System.exit(0);
    }

    public static void main(String[] args) {
        Prueba prueba  =  new Prueba();
        prueba.inicio();
        try {
            prueba.datos();
        } catch(Exception ex) { escribir(ex.getMessage()); }
    }
}