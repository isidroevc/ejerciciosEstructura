import java.io.RandomAccessFile;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Prueba {
    RandomAccessFile raf;
    FileOutputStream fos;
    int k;
    Conjunto[] c;
    Scanner sc = new Scanner(System.in);
    String uni, dif, in, dis, ent;
    void escribir(String s){
        System.out.println(s);
    }
    String leer(){
        System.out.print(">>");
        return sc.nextLine();
    }
    void abrirArchivoEntrada() throws IOException {
        raf = new RandomAccessFile("Conjuntos.txt", "r");
    }
    void abrirFlujoSalida()  throws IOException {
        fos = new FileOutputStream("ReporteConjuntos.txt");
    }
    void inicio() {
        String mensaje = "Este programa prueba las prestaciones";
        mensaje += " del ADT Conjunto y pone los resultados en un archivo";
        escribir(mensaje);
    }
    void datos() throws IOException {
        ArrayList<Object> lista;
        String[] elementos; 
        abrirArchivoEntrada();
        while(raf.readLine() != null)
            k++;
        c = new Conjunto[k];
        raf.seek(0);
        for(int i = 0; i < k; i++){
            elementos = raf.readLine().split(",");
            lista = new ArrayList<>();
            for(int j = 0, l = elementos.length; j < l; j++)
                lista.add(elementos[j]);
            c[i] = new Conjunto(lista);
        }
        raf.close();
    }
    void calculos() {
        ent = "Resultados de tipo entero " + c[0].getCardinalidad() + "\n";
        ent += "Resultados de tipo Conjunto\n";
        uni = "Retorna la union del Conjunto actual con otro\n";
        dif = "Retorna la diferencia del Conjunto actual con otro\n";
        in = "Retorna la interseccion del Conjunto actual con otro\n";
        dis = "Retorna la diferencia simetrica del conjunto actual con otro\n";
        for(int i= 0; i < k; i++){
            uni += c[0] + " U " + c[i] + " -> " + c[0].union(c[i]) + "\n";
            dif += c[0] + " - " + c[i] + " ->" + c[0].diferencia(c[i]) + "\n";
            in += c[0] + " intersec " + c[i] +" -> " + c[0].interseccion(c[i]);
            in += "\n";
            dis+= c[0] + " dif.sim. " + c[i] +" -> ";
            dis += c[0].diferenciaSimetrica(c[i]) + "\n" ;
        }
    }
    void resultados() throws IOException {
        String resultado;
        resultado = ent +"\n" + "\n" + uni + "\n" + dif + "\n" + in + "\n";
        resultado += dis;
        abrirFlujoSalida();
        escribir(resultado);
        fos.write(resultado.getBytes());
        fos.close();
        escribir("Listo puede revisar el archivo ReporteConjuntos.txt");
    }
    public static void main(String[] args) {
        Prueba demo = new Prueba();
        demo.inicio();
        try{
            demo.datos();
            demo.calculos();
            demo.resultados();
        }catch(Exception ex){
            ex.printStackTrace();
            System.exit(0);
        }
    }
}