

import java.awt.*;

public class Hanoi {

    private int n;
    private Poste izq, cen, der;

    public Hanoi(int n) {
        this.n = n;
        izq=new Poste(n, 80);
        cen=new Poste(0, 250);
        der=new Poste(0, 420);
    }

    public void resuelve(Graphics g) { solucion(n, izq, der, cen, g); }

    public void dibuja(Graphics g) {
        izq.dibuja(g);
        cen.dibuja(g);
        der.dibuja(g);
    }

    public void reinicia() {
        izq.ponDiscos(n);
        der.ponDiscos(0);
        cen.ponDiscos(0);
    }

    public void solucion(int n, Poste f, Poste d, Poste a, Graphics g) {
        if (n==0) return;
        else {
            solucion(n-1, f, a, d, g);
            mover(f, a, g);
            solucion(n-1, d, f, a, g);
        }
    }

    public void mover(Poste a, Poste b, Graphics g) {
        try{ Thread.sleep(1000); }
        catch(InterruptedException e){ g.drawString("Error en sleep",100,100); }

        Disco d=a.quitaDisco();
        b.agregaDisco(d);
        a.dibuja(g);
        b.dibuja(g);
    }
}
