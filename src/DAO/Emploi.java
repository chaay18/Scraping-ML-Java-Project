package DAO;

public class Emploi {
    String titre;
    String url;
    String ville;
    String entreprise;
    String date_pub;
    String date_fin;
    String secteur_act;
    String fonction;
    String experience;
    String niv_etude;
    String contrat;

    public Emploi(String titre, String url, String ville, String entreprise, String date_pub, String date_fin, String secteur_act, String fonction, String experience, String niv_etude, String contrat) {
        this.titre = titre;
        this.url = url;
        this.ville = ville;
        this.entreprise = entreprise;
        this.date_pub = date_pub;
        this.date_fin = date_fin;
        this.secteur_act = secteur_act;
        this.fonction = fonction;
        this.experience = experience;
        this.niv_etude = niv_etude;
        this.contrat = contrat;
    }



    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getDate_pub() {
        return date_pub;
    }

    public void setDate_pub(String date_pub) {
        this.date_pub = date_pub;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getSecteur_act() {
        return secteur_act;
    }

    public void setSecteur_act(String secteur_act) {
        this.secteur_act = secteur_act;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getNiv_etude() {
        return niv_etude;
    }

    public void setNiv_etude(String niv_etude) {
        this.niv_etude = niv_etude;
    }

    public String getContrat() {
        return contrat;
    }

    public void setContrat(String contrat) {
        this.contrat = contrat;
    }

    @Override
    public String toString() {
        return "Emploi{" +
                "titre='" + titre + '\'' +
                ", ville='" + ville + '\'' +
                ", entreprise='" + entreprise + '\'' +
                ", date_pub='" + date_pub + '\'' +
                ", date_fin='" + date_fin + '\'' +
                ", secteur_act='" + secteur_act + '\'' +
                ", fonction='" + fonction + '\'' +
                ", experience='" + experience + '\'' +
                ", niv_etude='" + niv_etude + '\'' +
                ", contrat='" + contrat + '\'' +
                '}';
    }

    public void affiche(){
        System.out.println(this.toString());
    }
}
