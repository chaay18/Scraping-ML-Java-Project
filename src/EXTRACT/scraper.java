package EXTRACT;
import DAO.Emploi;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class scraper {

    public Document getDoc(String path){
        try {
            Document doc = Jsoup.connect(path).get();
            return doc;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Emploi> scrape(Document document){
        try {
            ArrayList<Emploi> Emplois = new ArrayList<>();
            for(int i= 1 ; i<=31;i++) {
                String path = "https://www.rekrute.com/offres.html?s=3&p="+i+"&o=1";
                document = getDoc(path);
                for (Element row : document.select("li.post-id")){
                    Elements chemin_entrprise = row.select("div div a img.photo "); //se trouve dans le premier div de classe col-sm-2 col-xs-12
                    String entreprise = chemin_entrprise.attr("title"); //attribut title de l'image contient le nom de la société
                    Elements big_chemin = row.select("div div div.section");
                    String chemin_titre_ville = big_chemin.select("h2 a").text();  // text of link tag (big title of the job-offer: job | locatiion)
                    String titre = chemin_titre_ville.substring(0, chemin_titre_ville.indexOf("|")).replaceAll("\""," "); //title of job offer
                    String ville = chemin_titre_ville.substring(chemin_titre_ville.indexOf("|")+1, chemin_titre_ville.length()).replace("(Maroc)", "");
                    String urls = big_chemin.select("h2 a").attr("href");
                    String url = "https://www.rekrute.com/" + urls ; //link of single page job-offer
                    Elements nested_chemin_holder = big_chemin.select(".holder");
                    String date_pub = nested_chemin_holder.select("em.date span").first().text();
                    String date_fin = nested_chemin_holder.select("em.date span").get(1).text();
                    Element nested_chemin2_info3 = nested_chemin_holder.select(".info").get(2);
                    String secteur_act = nested_chemin2_info3.select("ul li").first().text().replace("Secteur d'activité :", "");
                    String fonction = nested_chemin2_info3.select("ul li").get(1).text().replace("Fonction :", "");
                    String experience = nested_chemin2_info3.select("ul li").get(2).text().replace("Expérience requise :", "");
                    String niv_etude = nested_chemin2_info3.select("ul li").get(3).text().replace("Niveau d’étude demandé :", "");
                    String contrat = nested_chemin2_info3.select("ul li").get(4).text().replace("Type de contrat proposé :", "");

                    Emploi emploi = new Emploi(titre, url, ville, entreprise, date_pub, date_fin, secteur_act, fonction, experience, niv_etude, contrat);
                    Emplois.add(emploi);
                    //System.out.println(contrat);
                }

            }
            return Emplois;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }



    }
/*
    public ArrayList<Emploi> scrape_key(Document document, String keyword){
        try {
            ArrayList<Emploi> Emplois = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                String path = "https://www.rekrute.com/offres.html?s=1&p=" + i + "&o=1&query=" + keyword + "&keyword=" + keyword + "";
                document = getDoc(path);
                for (Element row : document.select("li.post-id")) {
                    Elements chemin_entrprise = row.select("div div a img.photo "); //se trouve dans le premier div de classe col-sm-2 col-xs-12
                    String entreprise = chemin_entrprise.attr("title"); //attribut title de l'image contient le nom de la société
                    Elements big_chemin = row.select("div div div.section");
                    String chemin_titre_ville = big_chemin.select("h2 a").text();  // text of link tag (big title of the job-offer: job | locatiion)
                    String titre = chemin_titre_ville.substring(0, chemin_titre_ville.indexOf("|")).replaceAll("\"", " "); //title of job offer
                    String ville = chemin_titre_ville.substring(chemin_titre_ville.indexOf("|") + 1, chemin_titre_ville.length()).replace("(Maroc)", "");
                    String urls = big_chemin.select("h2 a").attr("href");
                    String url = "https://www.rekrute.com/" + urls; //link of single page job-offer
                    Elements nested_chemin_holder = big_chemin.select(".holder");
                    String date_pub = ""; //nested_chemin_holder.select("em.date span").first().text();
                    String date_fin = nested_chemin_holder.select("em.date span").get(1).text();
                    Element nested_chemin2_info3 = nested_chemin_holder.select(".info").get(2);
                    String secteur_act = ""; //nested_chemin2_info3.select("ul li").first().text().replace("Secteur d'activité :", "");
                    String fonction = nested_chemin2_info3.select("ul li").get(1).text().replace("Fonction :", "");
                    String experience = nested_chemin2_info3.select("ul li").get(2).text().replace("Expérience requise :", "");
                    String niv_etude = nested_chemin2_info3.select("ul li").get(3).text().replace("Niveau d’étude demandé :", "");
                    String contrat = nested_chemin2_info3.select("ul li").get(4).text().replace("Type de contrat proposé :", "");

                    Emploi emploi = new Emploi(titre, url, ville, entreprise, date_pub, date_fin, secteur_act, fonction, experience, niv_etude, contrat);
                    Emplois.add(emploi);
                    //System.out.println(secteur_act);
                }
            }
            return Emplois;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }*/
}

