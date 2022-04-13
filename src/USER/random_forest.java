package USER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class random_forest extends JFrame {
    private JButton returnbutton;
    private JPanel panel;
    private JPanel panel1;
    private JLabel picLabel1;
    private JPanel panel2;
    private JLabel picLabel2;

    public random_forest() {

        ImageIcon nb1 = new ImageIcon("src/rf1.png");
        ImageIcon nb2 = new ImageIcon("src/rf2.png");
        ImageIcon back = new ImageIcon("src/back (1).png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        picLabel1.setIcon(nb1);
        picLabel2.setIcon(nb2);
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
