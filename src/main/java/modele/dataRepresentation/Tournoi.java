package modele.dataRepresentation;

import application.donneesPersistantes.Portee;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Tournoi", uniqueConstraints = {
        @UniqueConstraint(columnNames = "nom")
})
public class Tournoi {
    public Tournoi() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_Tournoi")
    @SequenceGenerator(name = "Seq_Tournoi", sequenceName = "Seq_Tournoi", allocationSize = 1)
    @Column(name = "Id_Tournoi")
    private int id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "Portee", nullable = false)
    private String portee;

    @Column(name = "DATEFININSRIPTIONS", nullable = false)
    private LocalDate dateFinInscriptions;

    @Column(name = "dateDebutTournoi", nullable = false)
    private LocalDate dateDebutTournoi;

    @Column(name = "dateFinTournoi", nullable = false)
    private LocalDate dateFinTournoi;

    @ManyToOne
    @JoinColumn(name = "Id_Jeu", nullable = false)
    private Jeu jeu;

    @ManyToOne
    @JoinColumn(name = "Id_Gerant")
    private Gerant gerant;

    public Tournoi(String nom, Portee portee, LocalDate dateFinInscriptions, LocalDate dateDebutTournoi, LocalDate dateFinTournoi, Jeu jeu, Gerant gerant) {
        this.nom = nom;
        this.portee = portee.getName();
        this.dateFinInscriptions = dateFinInscriptions;
        this.dateDebutTournoi = dateDebutTournoi;
        this.dateFinTournoi = dateFinTournoi;
        this.jeu = jeu;
        this.gerant = gerant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPortee() {
        return portee;
    }

    public void setPortee(String portee) {
        this.portee = portee;
    }

    public LocalDate getDateFinInscriptions() {
        return dateFinInscriptions;
    }

    public void setDateFinInscriptions(LocalDate dateFinInscriptions) {
        this.dateFinInscriptions = dateFinInscriptions;
    }

    public LocalDate getDateDebutTournoi() {
        return dateDebutTournoi;
    }

    public void setDateDebutTournoi(LocalDate dateDebutTournoi) {
        this.dateDebutTournoi = dateDebutTournoi;
    }

    public LocalDate getDateFinTournoi() {
        return dateFinTournoi;
    }

    public void setDateFinTournoi(LocalDate dateFinTournoi) {
        this.dateFinTournoi = dateFinTournoi;
    }


    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public Gerant getGerant() {
        return gerant;
    }
    public void setGerant(Gerant gerant) {
        this.gerant = gerant;
    }

    public boolean verifierJeuTournoi(int idJeu) {
        return idJeu == this.jeu.getIdJeu();
    }

    @Override
    public String toString() {
        return "Tournoi{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", portee='" + portee + '\'' +
                ", dateFinInscriptions=" + dateFinInscriptions +
                ", dateDebutTournoi=" + dateDebutTournoi +
                ", dateFinTournoi=" + dateFinTournoi +
                ", jeu=" + jeu +
                ", gerant=" + gerant +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournoi tournoi = (Tournoi) o;
        return id == tournoi.id && nom.equals(tournoi.nom) && portee.equals(tournoi.portee) && dateFinInscriptions.equals(tournoi.dateFinInscriptions) && dateDebutTournoi.equals(tournoi.dateDebutTournoi) && dateFinTournoi.equals(tournoi.dateFinTournoi) && jeu.equals(tournoi.jeu) && gerant.equals(tournoi.gerant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, portee, dateFinInscriptions, dateDebutTournoi, dateFinTournoi, jeu, gerant);
    }
}
