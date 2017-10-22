

import javax.swing.*;

public class Hilbert {
    private Turtle turtle;
    int n;
    String aux;

    void meta(){
        aux="Modelar un algoritmo capaz de dibujar los ";
        aux+="primeros n patrones de la curva de Hilbert";
        JOptionPane.showMessageDialog(null,aux);
    }

    void datos() {
        String aux = "Cuantos patrones se van a desplegar?";
        n = 0;
        
        while(n == 0){
            try{
                n = Integer.parseInt(JOptionPane.showInputDialog(null,aux));
            }catch(Exception ex) {
                n = 0;
                JOptionPane.showMessageDialog(null,"Debe elejirse un numero mayor a 0");
            }
        }

    }

    public Hilbert() {}
    

    public void hilbert(int n) {
        if (n == 0) return;
        turtle.turnLeft(90);
        treblih(n-1);
        turtle.goForward(1.0);
        turtle.turnLeft(-90);
        hilbert(n-1);
        turtle.goForward(1.0);
        hilbert(n-1);
        turtle.turnLeft(-90);
        turtle.goForward(1.0);
        treblih(n-1);
        turtle.turnLeft(90);
    }


    public void treblih(int n) {
        if (n == 0) return;
        turtle.turnLeft(-90);
        hilbert(n-1);
        turtle.goForward(1.0);
        turtle.turnLeft(90);
        treblih(n-1);
        turtle.goForward(1.0);
        treblih(n-1);
        turtle.turnLeft(90);
        turtle.goForward(1.0);
        hilbert(n-1);
        turtle.turnLeft(-90);
    }

    public void iniciar(){
        turtle = new Turtle(0.5, 0.5, 0.0);
        double max = Math.pow(2, n);
        turtle.setXscale(0, max);
        turtle.setYscale(0, max);
        this.hilbert(n);
    }


    public static void main(String[] args) {
      Hilbert hil = new Hilbert();
      hil.meta();
      hil.datos();
      hil.iniciar();
    }
}
