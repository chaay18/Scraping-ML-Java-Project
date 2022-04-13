package DAO;

public class etudiant extends user {
    private String filiere;


    public etudiant(String nom, String prenom, String email, String password, String profil, String filiere) {
        super(nom, prenom, email, password, profil);
        this.filiere = filiere;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    @Override
    public String toString() {
        return "etudiant{" +
                "filiere='" + filiere + '\'' +
                '}';
    }
}
