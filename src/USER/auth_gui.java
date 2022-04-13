package USER;

import LOAD.loader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class auth_gui extends JFrame  {
    private JTextField loginField;
    private JButton LOGINButton;
    private JButton SIGNUPButton;
    private JPasswordField passwordField;
    private JPanel panel;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JPanel panel1;
    private JLabel logoLabel;
    ImageIcon icon1 = new ImageIcon("src/cancel.png");

    public auth_gui(String titre) {
        super(titre);
        ImageIcon icon = new ImageIcon("src/check.png");
        ImageIcon icon5 = new ImageIcon("src/login.png");
        ImageIcon icon3 = new ImageIcon("src/register (1).png");
        ImageIcon icon4 = new ImageIcon("src/logo.png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
        logoLabel.setIcon(icon4);
        LOGINButton.setIcon(icon5);
        SIGNUPButton.setIcon(icon3);
        LOGINButton.setFont(new Font("Comic Sans", Font.BOLD, 18));
        SIGNUPButton.setFont(new Font("Comic Sans", Font.BOLD, 18));
        loginLabel.setFont(new Font("Comic Sans", Font.BOLD, 17));
        passwordLabel.setFont(new Font("Comic Sans", Font.BOLD, 17));
        loginField.setFont(new Font("Comic Sans", Font.PLAIN, 17));
        passwordField.setFont(new Font("Comic Sans", Font.PLAIN, 17));
        loginField.setPreferredSize(new Dimension(250,50));
        passwordField.setPreferredSize(new Dimension(250,50));
        panel1.setPreferredSize(new Dimension(350, 50));
        this.setBounds(100,100,800,600);
        this.setVisible(true);


        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==LOGINButton ) {
                    String login = loginField.getText();
                    String password = passwordField.getText();

                    loader load = new loader();
                    Connection con = load.connection1();

                    try {
                        String sql = "select * from User";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next())
                        {
                            String PASSWD = rs.getString("psswd");
                            String LOGIN = rs.getString("email");

                            if (PASSWD.equals(password) && LOGIN.equals(login))
                            {
                                new acceuil("HOMEPAGE");
                                break;
                            }
                            if (!PASSWD.equals(password) && !LOGIN.equals(login))
                            {
                                JOptionPane.showMessageDialog(null, "Connection Failed", "Message", JOptionPane.PLAIN_MESSAGE, icon1);
                                new auth_gui("AUTHENTIFICATION");
                                break;

                            }
                        }
                    } catch (Exception e1) {
                        //gestion des exceptions
                        e1.printStackTrace();
                    }
                }
                dispose();


            }
        });
        SIGNUPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==SIGNUPButton){
                    new reg_gui("SIGN UP PAGE");
                }
                dispose();

            }
        });
    }
}
