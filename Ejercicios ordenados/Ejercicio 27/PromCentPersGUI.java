/*PromCentPersGUI.java
  Instituto Tecnológico de León
  Ingeniería en Sistemas Computacionales
  Topicos avanzados de programaciòn.
  Alumno (a):
  Foto Digital del alumno (a)
  Tarea #: _____-__
  Fecha de entrega: Febrero 5 del 2010
  Modificado 22 de febrero 2011
  Terminado el 25 de febrero 2011 muestra la interaccion entre objetos
  Modificado el 10 de Marzo del 2011 para que se comporte graficamente
  capa de negocios aqui estan los metodos necesarios para el promedio 
  y la suma
*/

package AplicacionPorCapas;

import javax.swing.JOptionPane;

class PromCentPersGUI{
    public static final String CENTINELA = "fin";
    double datos[] = new double[100];
    double prom, suma;
    JOptionPane box;
  
    void inicio(){
        String l="";

        l+="\nPara calcular el promedio de n datos.";
        l+="\nManipulando un arreglo y usando centinela";
        l+="\npara terminar la captura, se muestran los";
        l+="\ndatos capturados\n";
        box.showMessageDialog(null,l);
    }

    int nuevo(){
        datos = new double[100];
        return 0;
    }

    String capDato(int cont){
        String d;

        do d = box.showInputDialog("Deme el dato: "+cont+
                " o \"fin\" para terminar:");
        while(!ArchiDatosGUI.isNum(d) && !d.equals(CENTINELA)); 
        return d;
    }

    int datos(){
        int cont = 0;
        String dato = capDato(cont).toLowerCase();

        while(!dato.equals(CENTINELA) && cont < datos.length){
            datos[cont++] = Double.parseDouble(dato);
            dato = capDato(cont).toLowerCase();
        }
        return cont;
    }

    void calculos(int cont){
        String l= "No es posible calcular el promedio de 0 datos";

        suma = prom = 0.0;
        for(int i=0; i < cont; i++) suma=suma+datos[i];
        if(cont!=0) prom=suma/(cont);
        else box.showMessageDialog(null,l);
    }

    void resultados(int cont){
        String l;

        l="\nFueron "+ cont +" Datos capturados: { ";
        for(int i=0; i<cont; i++) l=l+datos[i]+", ";
        l= l +"} \n\nLa suma es:"+suma;
        l= l +"\nY el promedio es:"+prom;
        box.showMessageDialog(null,l);
    }
}
