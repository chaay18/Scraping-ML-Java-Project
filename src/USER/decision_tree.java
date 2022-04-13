package USER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class decision_tree extends  JFrame {
    private JPanel panel;
    private JLabel picLabel1;
    private JLabel picLabel2;
    private JPanel panel1;
    private JPanel panel2;
    private JButton returnbutton;

    public decision_tree(){
        ImageIcon dt1 = new ImageIcon("src/dec1.png");
        ImageIcon dt2 = new ImageIcon("src/dec3.png");
        ImageIcon back = new ImageIcon("src/back (1).png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        picLabel1.setIcon(dt1);
        picLabel2.setIcon(dt2);
        picLabel2.setPreferredSize(new Dimension(10,10));
        returnbutton.setIcon(back);
        this.setBounds(100,100,1000,1500);
        this.setVisible(true);

        returnbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==returnbutton)
                    new ML();
                dispose();
            }

        });
    }
}
