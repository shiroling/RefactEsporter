package nouveauModele.dataRepresentation;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Joueur")
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_Joueur")
    @SequenceGenerator(name = "Seq_Joueur", sequenceName = "Seq_Joueur", allocationSize = 1)
    @Column(name = "Id_Joueur")
    private int idJoueur;

    @Column(name = "Nom", nullable = false)
    private String nom;

    @Column(name = "Prenom", nullable = false)
    private String prenom;

    @Column(name = "Date_De_Naissance", nullable = false)
    private LocalDate dateDeNaissance;

    @Column(name = "Pseudo", nullable = false)
    private String pseudo;

    @ManyToOne
    @JoinColumn(name = "Id_Equipe", referencedColumnName = "Id_Equipe", nullable = false)
    private Equipe equipe;

    public Joueur() {

    }
    public Joueur(String nom, String prenom, String pseudo, LocalDate dateDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.dateDeNaissance = dateDeNaissance;
        this.equipe = equipe;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
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

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "idJoueur=" + idJoueur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateDeNaissance=" + dateDeNaissance +
                ", pseudo='" + pseudo + '\'' +
                ", equipe=" + equipe +
                '}';
    }
}
