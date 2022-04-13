package USER;

import DAO.Emploi;
import EXTRACT.scraper;
import LOAD.loader;
import org.jsoup.nodes.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class scraping_gui extends JFrame{

    private JButton SCRAPERButton;
    private JButton DELETEButton;
    private JTable table1;
    private JPanel panel;
    private JLabel keyLabel;
    private JButton returnbutton;
    private JComboBox comboBox1;
    private JButton nextbutton;
    loader ld = new loader();
    Connection con = ld.connection();

    public scraping_gui(String titre) {
        super(titre);
        ImageIcon ic = new ImageIcon("src/statistics.png");
        ImageIcon ic1 = new ImageIcon("src/search.png");
        ImageIcon ic2 = new ImageIcon("src/trash.png");
        ImageIcon key = new ImageIcon("src/keywords.png");
        ImageIcon back = new ImageIcon("src/back (1).png");
        ImageIcon next = new ImageIcon("src/next.png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);
        this.setSize(1200, 1000);

        table1.setVisible(false);
        table1.setFont(new Font("Comic Sans", Font.ITALIC, 12));
        table1.getTableHeader().setFont(new Font("Sans Serif", Font.BOLD, 15));
        table1.setRowHeight(30);
        SCRAPERButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        SCRAPERButton.setPreferredSize(new Dimension(200, 50));
        SCRAPERButton.setIcon(ic);
        //SCRAPERButton.setForeground(Color.orange);
        DELETEButton.setForeground(Color.red);
        DELETEButton.setFont(new Font("Comic Sans", Font.BOLD, 25));
        DELETEButton.setPreferredSize(new Dimension(200, 50));
        comboBox1.setFont(new Font("Comic Sans", Font.BOLD, 15));
        DELETEButton.setIcon(ic2);
        keyLabel.setFont(new Font("Comic Sans", Font.BOLD, 25));
        keyLabel.setIcon(key);
        returnbutton.setIcon(back);
        nextbutton.setIcon(next);

        SCRAPERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == SCRAPERButton ){
                    try {
                        loader load = new loader();
                        Connection con = load.connection();
                        Document doc = null;
                        scraper scrap = new scraper();
                        ArrayList<Emploi> Emplois = new ArrayList<>();
                        Emplois=scrap.scrape(doc);
                        for (int i = 0; i < Emplois.size(); i++){
                            load.insertion(con, Emplois.get(i));
                        }
                        table1.setVisible(true);
                        updateTable();
                    }
                    catch (Exception excep){
                        excep.printStackTrace();
                    }

                }
            }
        });

        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == DELETEButton ) {
                    try {
                        String sql = "delete from emploi";
                        Statement stmt = con.createStatement();
                        int rs = stmt.executeUpdate(sql);
                        updateTable();
                    }
                    catch (Exception exp){
                        exp.printStackTrace();
                    }

                }
            }
        });
        returnbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==returnbutton){
                    new acceuil("HOMEPAGE");
                }
                dispose();
            }
        });
        nextbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ML();
                dispose();
            }
        });
    }

    public void updateTable (){

        try {
            String sql = "select * from emploi";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            DefaultTableModel model = new DefaultTableModel(null, new String[]{"ID", " Titre", "URL", "Ville", "Entreprise", "date_pub", "date_fin", "secteur_act", "fonction", "experience", "niv_etude", "contrat"});
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)});
            }
            table1.setModel(model);

        }catch (SQLException ex){
            System.out.println("SQL ERROR : " +ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new scraping_gui("scraping");
    }

}
