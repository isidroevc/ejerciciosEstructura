

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Principal extends JApplet {
    JTextField ndiscos;
    JButton VerSolucion;
    JLabel l;

    public void init() {
        JPanel p=new JPanel();
        l=new JLabel("Numero de Discos");
        ndiscos=new JTextField(6);
        VerSolucion=new JButton("Ver Solucion");
        VerSolucion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                TorresFrame tf;
                tf=new TorresFrame(Integer.parseInt(ndiscos.getText()));
                tf.setVisible(true);
                tf.setBounds(0, 0, 510, 550);
                tf.setLocationRelativeTo(null);
                tf.setTitle("Solucion Torres de Hanoi");
            }
        });
        p.add(l);
        p.add(ndiscos);
        p.add(VerSolucion);
        add(p);
    }
}
