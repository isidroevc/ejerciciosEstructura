

import java.awt.*;

public class Disco {
    private int base, altura;

    public Disco(int b, int h) {
        this.base=b;
        this.altura=h;
    }

    public void dibuja(Graphics g, int x, int y) {
        g.setColor(Color.red);
        g.fillRoundRect(x-base/2, y-altura, base, altura, 10, 10);
        g.setColor(Color.black);
        g.drawRoundRect(x-base/2, y-altura, base, altura, 10, 10);
    }
}
