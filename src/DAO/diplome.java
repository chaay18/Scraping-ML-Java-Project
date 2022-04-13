package DAO;

public class diplome extends user {
    private String diplome;


    public diplome(String nom, String prenom, String email, String password, String profil, String diplome) {
        super(nom, prenom, email, password, profil);
        this.diplome=diplome;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    @Override
    public String toString() {
        return "diplome{" +
                "diplome='" + diplome + '\'' +
                '}';
    }
}
