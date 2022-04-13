package USER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ML extends JFrame {
    private JButton DECISIONTREEButton;
    private JButton NAIVEBAYESButton;
    private JButton RANDOMFORESTButton;
    private JButton RANDOMTREEButton;
    private JPanel panel;
    private JLabel chLabel;
    private JLabel logoLabel;
    private JPanel panel1;


    public ML() {
        ImageIcon dec = new ImageIcon("src/decision-tree.png");
        ImageIcon forest = new ImageIcon("src/forest.png");
        ImageIcon tree = new ImageIcon("src/donnees.png");
        ImageIcon nb = new ImageIcon("src/machine-learning (1).png");
        ImageIcon logo = new ImageIcon("src/logo.png");



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        DECISIONTREEButton.setIcon(dec);
        DECISIONTREEButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        NAIVEBAYESButton.setIcon(nb);
        NAIVEBAYESButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        RANDOMFORESTButton.setIcon(forest);
        RANDOMFORESTButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        RANDOMTREEButton.setIcon(tree);
        RANDOMTREEButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        chLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
        logoLabel.setIcon(logo);
        panel1.setPreferredSize(new Dimension(350, 50));

        this.setBounds(100,100,1500,1000);
        this.setVisible(true);

        DECISIONTREEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==DECISIONTREEButton)
                    new decision_tree();
                dispose();
            }
        });
        NAIVEBAYESButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==NAIVEBAYESButton)
                    new naive_bayes();
                dispose();
            }
        });
        RANDOMFORESTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==RANDOMFORESTButton)
                    new random_forest();
                dispose();
            }
        });
        RANDOMTREEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==RANDOMTREEButton)
                    new data_vis();
                dispose();
            }
        });
    }
}
