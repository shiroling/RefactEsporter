package application.testeurs;

import java.time.LocalDate;

public class PreJoueur {
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String pseudo;

    public PreJoueur() {
        this.nom = null;
        this.prenom = null;
        this.dateDeNaissance = null;
        this.pseudo = null;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @Override
    public String toString() {
        return "PreJoueur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateDeNaissance=" + dateDeNaissance +
                ", pseudo='" + pseudo + '\'' +
                '}';
    }
}

