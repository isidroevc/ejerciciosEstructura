import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Principal  {




public static void main(String[] args) {
    JTextField ndiscos;
    JButton VerSolucion;
    JLabel l;
    JPanel p=new JPanel();
    l=new JLabel("Numero de Discos");
    ndiscos=new JTextField("6");
    VerSolucion = new JButton("Ver Solucion");
    TorresFrame tf=new TorresFrame(Integer.parseInt(ndiscos.getText()));
    tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    tf.setVisible(true);
    tf.setBounds(0,0,510,550);
    tf.setLocationRelativeTo(null);
    tf.setTitle("Solucion Torres de Hanoi");
    tf.add(l);
    tf.add(ndiscos);
    tf.add(VerSolucion);
}

/*public void init(){
JPanel p=new JPanel();
l=new JLabel("Numero de Discos");
ndiscos=new JTextField(6);
VerSolucion=new JButton("Ver Solucion");
VerSolucion.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent arg0) {
// TODO Auto-generated method stub
TorresFrame tf=new TorresFrame(Integer.parseInt(ndiscos.getText()));
tf.setVisible(true);
tf.setBounds(0,0,510,550);
tf.setLocationRelativeTo(null);
tf.setTitle("Solucion Torres de Hanoi");
}
});
p.add(l);
p.add(ndiscos);
p.add(VerSolucion);
add(p);
}*/

}