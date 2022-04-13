package USER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class acceuil extends JFrame {
    private JButton mlButton;
    private JLabel logoLabel;
    private JLabel welcomeLabel;
    private JButton scrapingButton;
    private JLabel doneLabel;
    private JLabel expLabel1;
    private JLabel expLabel2;
    private JLabel choiceLabel;
    private JPanel panel;
    private JLabel nameLabel1;
    private JLabel nameLabel2;
    private JLabel nameLabel3;


    public acceuil(String titre) {
        super(titre);
        ImageIcon logo = new ImageIcon("src/logo.png");
        ImageIcon ml = new ImageIcon("src/machine-learning.png");
        ImageIcon scrp = new ImageIcon("src/search.png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        logoLabel.setIcon(logo);
        scrapingButton.setIcon(scrp);
        mlButton.setIcon(ml);
        scrapingButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        mlButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        choiceLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        welcomeLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
        expLabel1.setFont(new Font("Comic Sans", Font.BOLD, 25));
        expLabel2.setFont(new Font("Comic Sans", Font.BOLD, 25));
        nameLabel1.setFont(new Font("Comic Sans", Font.BOLD, 20));
        nameLabel2.setFont(new Font("Comic Sans", Font.BOLD, 20));
        nameLabel3.setFont(new Font("Comic Sans", Font.BOLD, 20));
        doneLabel.setFont(new Font("Comic Sans", Font.BOLD, 17));
        this.setBounds(100,100,1500,1000);
        this.setVisible(true);

        scrapingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new scraping_gui("SCRAPING");
                dispose();
            }
        });
        mlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ML();
                dispose();
            }
        });
    }
}
