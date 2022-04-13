package LOAD;

import DAO.Emploi;

import java.sql.*;
import DAO.user;

public class loader {
    public Connection connection() {
        Connection con = null;
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver pilote = (Driver) c.newInstance();
            //enregistrement du pilote aupres du driverManager
            DriverManager.registerDriver(pilote);

            //protocol de connexion
            String protocole = "jdbc:mysql:";
            //adresse IP de l'hote de la base et port
            String ip = "localhost"; //depend du contexte
            String port = "8889"; //port mysql par defaut
            //nom de la base
            String nomBase = "emploi";
            //chaine de connexion
            String conString = protocole + "//" + ip + ":" + port + "/" + nomBase;
            //identifiants de connexion et mot de passe
            String nomConnexion = "root";
            String motDePasse = "root";
            //connexion
            con = DriverManager.getConnection(conString, nomConnexion, motDePasse);
        } catch (Exception e) {
            //gestion des exceptions
            e.printStackTrace();

        }
        return con;
    }

    public Connection connection1() {
        Connection con = null;
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver pilote = (Driver) c.newInstance();
            //enregistrement du pilote aupres du driverManager
            DriverManager.registerDriver(pilote);

            //protocol de connexion
            String protocole = "jdbc:mysql:";
            //adresse IP de l'hote de la base et port
            String ip = "localhost"; //depend du contexte
            String port = "8889"; //port mysql par defaut
            //nom de la base
            String nomBase = "emploi";
            //chaine de connexion
            String conString = protocole + "//" + ip + ":" + port + "/" + nomBase;
            //identifiants de connexion et mot de passe
            String nomConnexion = "root";
            String motDePasse = "root";
            //connexion
            con = DriverManager.getConnection(conString, nomConnexion, motDePasse);
        } catch (Exception e) {
            //gestion des exceptions
            e.printStackTrace();

        }
        return con;
    }

    public void insertion(Connection con , Emploi emploi ) throws SQLException {
        String sql1 = "insert into emploi (titre,url,ville,entreprise,date_pub, date_fin, secteur_act, fonction, experience, niv_etude, contrat) values (\""+emploi.getTitre()+"\" , \""+emploi.getUrl()+"\" , \""+ emploi.getVille()+"\" , \""+ emploi.getEntreprise()+"\" , \""+ emploi.getDate_pub()+"\" , \""+emploi.getDate_fin()+"\" , \""+ emploi.getSecteur_act()+"\" , \""+ emploi.getFonction()+"\" , \""+ emploi.getExperience()+"\" , \""+ emploi.getNiv_etude()+"\" , \""+ emploi.getContrat()+"\");";
        Statement stmt = con.createStatement();
        int rs = stmt.executeUpdate(sql1);

    }

    public void Insertion(Connection con , user user ) throws SQLException {
        String sql1 = "insert into User ( `psswd`, `nom`, `prenom`, `email`, `profil`) values (\""+user.getPassword()+"\" , \""+user.getNom()+"\" , \""+ user.getPrenom()+"\" , \""+ user.getEmail()+"\" , \""+ user.getProfil()+"\");";
        Statement stmt = con.createStatement();
        int rs = stmt.executeUpdate(sql1);

    }

   /* public void insertion_key(Connection con , Emploi emploi ) throws SQLException {
        String sql1 = "insert into emploi_key (titre,url,ville,entreprise,date_pub, date_fin, secteur_act, fonction, experience, niv_etude, contrat) values (\""+emploi.getTitre()+"\" , \""+emploi.getUrl()+"\" , \""+ emploi.getVille()+"\" , \""+ emploi.getEntreprise()+"\" , \""+ emploi.getDate_pub()+"\" , \""+emploi.getDate_fin()+"\" , \""+ emploi.getSecteur_act()+"\" , \""+ emploi.getFonction()+"\" , \""+ emploi.getExperience()+"\" , \""+ emploi.getNiv_etude()+"\" , \""+ emploi.getContrat()+"\");";
        Statement stmt = con.createStatement();
        int rs = stmt.executeUpdate(sql1);

    }

    */

    public void selection(Connection con){
        try {
            String sql = "select * from emploi";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("**********************");
                System.out.println("EMPLOI ID : " +rs.getString(  1 ));
                System.out.println("titre : " +rs.getString(  2 ));
                System.out.println("URL : " +rs.getString(3 ));
                System.out.println("ville :" +rs.getString(4 ));
                System.out.println( "entreprise :" +rs.getString(5 ));
                System.out.println( "date pub :" +rs.getString(6 ));
                System.out.println( "date fin :" +rs.getString(7 ));
                System.out.println( "secteurs d'activite :" +rs.getString(8 ));
                System.out.println( "fonctions :" +rs.getString(9 ));
                System.out.println( "experience :" +rs.getString(10 ));
                System.out.println( "niveau etude :" +rs.getString(11 ));
                System.out.println( "contrat :" +rs.getString(12 ));

            }
        }
        catch (Exception e1){
            //gestion des exceptions
            e1.printStackTrace();
        }
    }

 /*   public void selection_key(Connection con){
        try {
            String sql = "select * from emploi_key";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("**********************");
                System.out.println("EMPLOI ID : " +rs.getString(  1 ));
                System.out.println("titre : " +rs.getString(  2 ));
                System.out.println("URL : " +rs.getString(3 ));
                System.out.println("ville :" +rs.getString(4 ));
                System.out.println( "entreprise :" +rs.getString(5 ));
                System.out.println( "date pub :" +rs.getString(6 ));
                System.out.println( "date fin :" +rs.getString(7 ));
                System.out.println( "secteurs d'activite :" +rs.getString(8 ));
                System.out.println( "fonctions :" +rs.getString(9 ));
                System.out.println( "experience :" +rs.getString(10 ));
                System.out.println( "niveau etude :" +rs.getString(11 ));
                System.out.println( "contrat :" +rs.getString(12 ));

            }
        }
        catch (Exception e1){
            //gestion des exceptions
            e1.printStackTrace();
        }
    }

  */
}
