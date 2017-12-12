

import java.awt.*;

public class TorresFrame extends Frame {
    private Hanoi h;
    private boolean resolver;

    public TorresFrame(int ndiscos) {
        setLayout(new FlowLayout());
        h = new Hanoi(ndiscos);
        resolver = true;
    }

    public void paint(Graphics g) {
        h.dibuja(g);
        if (resolver) h.resuelve(g);
    }
}
