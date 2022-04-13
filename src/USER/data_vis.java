package USER;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class data_vis extends JFrame{
    private JButton returnbutton;
    private JPanel panel;
    private JLabel picLabel1;


    public data_vis() {

        ImageIcon dt1 = new ImageIcon("src/data.jpeg");
        ImageIcon dt2 = new ImageIcon("src/rt2.png");
        ImageIcon back = new ImageIcon("src/back (1).png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        picLabel1.setIcon(dt1);
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
