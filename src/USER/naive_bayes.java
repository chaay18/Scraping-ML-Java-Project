package USER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class naive_bayes extends JFrame {
    private JButton returnButton;
    private JLabel picLabel1;
    private JLabel picLabel2;
    private JPanel panel;
    private JPanel panel1;
    private JPanel panel2;

    public naive_bayes() {
        ImageIcon nb1 = new ImageIcon("src/nb1.png");
        ImageIcon nb2 = new ImageIcon("src/nb2.png");
        ImageIcon back = new ImageIcon("src/back (1).png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        picLabel1.setIcon(nb1);
        picLabel2.setIcon(nb2);
        picLabel2.setPreferredSize(new Dimension(10,10));
        returnButton.setIcon(back);
        this.setBounds(100,100,1000,1500);
        this.setVisible(true);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==returnButton)
                    new ML();
                dispose();
            }
        });
    }
}
