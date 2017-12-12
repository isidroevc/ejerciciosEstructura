/* ArchiDatos.java
   por Cirino Silva Tovar
   Diciembre 8 del 2008
   Modificado el 10 de marzo del 2011 para que se comporte graficamente.
*/



import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ArchiDatosGUI{   // capa de persistencia 
    JOptionPane box;
  
    public static boolean isNum(String cad){
        try{
            Double.parseDouble(cad);
            return true;
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null,"Use datos numericos.");
            return false;
        }
    }

    public int datosIn(String file,double []A){ //entrada por archivo
        String s;
        int i = 0;
        Scanner in=null;

        try{
            File f = new File(file);

            if(f.exists() && f.canRead()){
                in=new Scanner(f); // abre el archivo de datos
                while(in.hasNextLine()){
                    s=in.nextLine();
                    A[i++]=Double.parseDouble(s);
                }
                box.showMessageDialog(null, "Se leyeron los datos de:"+file);
            }else box.showMessageDialog(null,"El archivo:"+file+" no existe");
        }catch(FileNotFoundException e){
            System.out.println("Aparentemente no existe el archivo:"+file);
            e.printStackTrace();
            return 0;
        }
        finally{ if(in != null) in.close(); } // cierra el archivo de entrada
        return i;
    }

    public void datosOut(String file, double[]A, int n){
        PrintStream out=null;

        try{
            out=new PrintStream(new FileOutputStream(file));
                                   // abre el archivo de salida
  
            for(int i=0; i < n /*& A[i] !=0.0*/ ; i++) out.println(A[i]);
            box.showMessageDialog(null,"Se escribieron los datos en:"+file);
        }catch(FileNotFoundException e){
            System.out.println("Error al dar salida en archivo:"+file);
            e.printStackTrace();
        }finally{ out.close(); } // cierra el archivo de salida
    }

    void listaFicheros(String path){
        File canal = new File(path);
        File []lista = canal.listFiles();
        String l="Archivos presentes en el subdirectori de trabajo actual\n\n";

        for(int i = 0; i < lista.length;i++) l = l + lista[i]+"\n";
        box.showMessageDialog(null,l);
    }
}




















