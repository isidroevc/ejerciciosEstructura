

import java.awt.*;

public class Poste {
    private int n;
    private int x, y;
    private int anchodisco, basedisco;
    private int anchobase, anchoposte;
    private Disco disco[];

    public Poste(int n, int px) {
        this.n=n;
        x=px;
        y=500;
        anchodisco=20;
        basedisco=140;
        anchobase=150;
        anchoposte=10;
        disco=new Disco[10];
        for (int i=0; i<n; i++)
            disco[i]=new Disco((int)(basedisco*(1-0.1*i)), anchodisco);
    }

    public void ponDiscos(int n) {
        this.n=n;
        disco=new Disco[10];
        for (int i=0; i<n; i++)
            disco[i]=new Disco((int)(basedisco*(1-0.1*i)), anchodisco);
    }

    public void agregaDisco(Disco d) {
        disco[n] = d;
        n++;
    }

    public Disco quitaDisco() {
        if (n != 0) n--;
        Disco d = disco[n];
        disco[n] = null;
        return d;
    }

    public void dibuja(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x-anchobase/2,500-15*anchodisco,anchobase,15*anchodisco);
        g.setColor(Color.black);
        g.fillRect(x-anchobase/2,500-anchodisco,anchobase,anchodisco);
        g.setColor(Color.ORANGE);
        g.fillRect(x-anchoposte/2,500-15*anchodisco,anchoposte,14*anchodisco);
        
        for (int i=0; i<n; i++)
            if(disco[i]!=null) disco[i].dibuja(g,x,500-anchodisco-i*anchodisco);
    }
}
