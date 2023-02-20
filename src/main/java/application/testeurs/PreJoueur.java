package application.testeurs;

import application.testeurs.date.PreDate;
import oracle.jdbc.proxy.annotation.Pre;

import javax.persistence.Column;
import java.util.Date;

public class PreJoueur {
    private String nom;
    private String prenom;
    private PreDate dateDeNaissance;
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

    public PreDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(PreDate dateDeNaissance) {
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

