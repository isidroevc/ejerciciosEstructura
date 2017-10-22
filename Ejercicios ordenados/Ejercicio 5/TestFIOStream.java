/*TestFIOStream.java
  por Cirino Silva Tovar
  el dom 27 de agosto 2017
*/

import java.io.*;
import cstio.*;

/**
 *   Program TestFIOStream
 *
 * <p>
 *
 *    A test program to save data to a file using FileOutputStream
 * and recover information with FileInputStream
 */

class TestFIOStream {   // Prueba flujos de entrada/salida por archivo
   File outFile, inFile;
   FileOutputStream outStream;
   FileInputStream inStream;
   //data to output
   Pizarra p = new Pizarra(); 
   Dialog di = new Dialog();
   byte byteArray[] = {10, 20, 30, 40, 50, 60, 70, 80};
    
   void inicio() {
     p.out("crea un archivo binario con datos");
     p.out("lo guarda en disco con el nombre de sample1.data");
     p.out("lee el archivo recien creado abriendolo del disco");
     p.out("y lo despliega en una pizarra de información");
     p.setVisible(true);
   }
   
   String capArchName() {
     String aux;
     
     do aux = di.readString("Deme nombre del archivo de datos:");
     while (aux.length() <= 0);
     return aux;
   }
   
   public void openOut(String name) {  // salida por archivos
     //setup file and stream
     outFile   = new File( name );
     try {  outStream = new FileOutputStream( outFile );  }
     catch(FileNotFoundException fnfe) {  
       di.display("No se creo el archivo"+ name);
     }
   }
   
   public void openIn(String name) { // entrada por archivo
     //setup file and stream
     inFile = new File(name);
     try {  inStream = new FileInputStream(inFile);  }
     catch (FileNotFoundException fnfe) {  
       di.display("No existe el archivo"+ name);
     }
   }

   public void out (String arch) throws IOException {
     openOut(arch);
     //write data to the stream
     outStream.write(byteArray);
     //output done, so close the stream
     outStream.close();
   }
   
   public void in (String arch) throws IOException {
      //set up an array to read data in
      //int    fileSize  = (int)arch.length();   // depurar
      byte[] bytebuff= new byte[byteArray.length];

      openIn(arch);
      //read data in and display them
      inStream.read(bytebuff);
      for (int i = 0; i < bytebuff.length; i++) 
         p.out(bytebuff[i]+ " ");
      inStream.close();
   }
   
   public static void main(String args[]) {
     TestFIOStream tfios = new TestFIOStream();
     String archivo;
     
     tfios.inicio();
     archivo = tfios.capArchName();
     try {
       tfios.out(archivo);
       tfios.in(archivo);
     } catch (IOException ioe) {
         tfios.di.display("Error de entrada/salida");
       }  
   }
}

