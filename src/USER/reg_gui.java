package USER;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import DAO.user;
import LOAD.loader;

public class reg_gui extends JFrame{
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField prenomField;
    private JTextField nomField;
    private JButton SIGNUPButton;
    private JPanel panel1;
    private JPanel panel;
    private JLabel logoLabel;
    private JComboBox statusBox;
    private JLabel nomLabel;
    private JLabel prenomLabel;
    private JLabel emailLabel;
    private JLabel statusLabel;
    private JLabel passwordLabel;
    private JButton LOGINButton;

    public reg_gui(String title) {
        super(title);
        ImageIcon icon = new ImageIcon("src/check.png");
        ImageIcon icon5 = new ImageIcon("src/login.png");
        ImageIcon icon3 = new ImageIcon("src/register (1).png");
        ImageIcon icon4 = new ImageIcon("src/logo.png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        SIGNUPButton.setIcon(icon3);
        LOGINButton.setIcon(icon5);
        logoLabel.setIcon(icon4);
        passwordField.setPreferredSize(new Dimension(250,50));
        passwordField.setFont(new Font("Comic Sans", Font.PLAIN, 17));
        emailField.setPreferredSize(new Dimension(250,50));
        emailField.setFont(new Font("Comic Sans", Font.PLAIN, 17));
        nomField.setPreferredSize(new Dimension(250,50));
        nomField.setFont(new Font("Comic Sans", Font.PLAIN, 17));
        prenomField.setPreferredSize(new Dimension(250,50));
        prenomField.setFont(new Font("Comic Sans", Font.PLAIN, 17));
        statusBox.setPreferredSize(new Dimension(250,50));
        statusBox.setFont(new Font("Comic Sans", Font.PLAIN, 17));
        nomLabel.setFont(new Font("Comic Sans", Font.BOLD, 17));
        prenomLabel.setFont(new Font("Comic Sans", Font.BOLD, 17));
        emailLabel.setFont(new Font("Comic Sans", Font.BOLD, 17));
        passwordLabel.setFont(new Font("Comic Sans", Font.BOLD, 17));
        statusLabel.setFont(new Font("Comic Sans", Font.BOLD, 17));
        SIGNUPButton.setFont(new Font("Comic Sans", Font.BOLD, 18));
        LOGINButton.setFont(new Font("Comic Sans", Font.BOLD, 18));
        panel1.setPreferredSize(new Dimension(350, 50));
        this.setBounds(100,100,800,600);
        this.setVisible(true);
        SIGNUPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    if (e.getSource()==SIGNUPButton){
                        String prenom = prenomField.getText();
                        String nom = nomField.getText();
                        String email = emailField.getText();
                        String password = passwordField.getText();
                        String profil =statusBox.getSelectedItem() .toString();

                        user user = new user(nom,prenom,email,password,profil);

                        loader load = new loader();
                        Connection con = load.connection1();
                        try {
                            load.Insertion(con,user);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        new acceuil("HOMEPAGE");
                    }
                    dispose();
                }
        });
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new auth_gui("AUTHENTIFICATION");
                dispose();
            }
        });
    }
}
