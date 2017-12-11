import java.awt.*;
import javax.swing.JFrame;
public class TorresFrame extends JFrame{
private Hanoi h;
private boolean resolver;

public TorresFrame(int ndiscos) {

getContentPane().setLayout(new FlowLayout()); 
h = new Hanoi(ndiscos); 
resolver = true;
}

public void paint(Graphics g) {

h.dibuja(g);
if(resolver) {
h.resuelve(g);
}
}

}