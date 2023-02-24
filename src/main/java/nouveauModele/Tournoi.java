package nouveauModele;

import java.time.LocalDate;
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
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_Tournoi")
//    @SequenceGenerator(name = "Seq_Tournoi", sequenceName = "Seq_Tournoi", allocationSize = 1)
    @Column(name = "Id_Tournoi")
    private int id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "Portee", nullable = false)
    private String portee;

    @Column(name = "dateFinInscriptions", nullable = false)
    private LocalDate dateFinInscriptions;

    @Column(name = "dateDebutTournoi", nullable = false)
    private LocalDate dateDebutTournoi;

    @Column(name = "dateFinTournoi", nullable = false)
    private LocalDate dateFinTournoi;

    @ManyToOne
    @JoinColumn(name = "Id_Jeu", nullable = false)
    private int idJeu;

    @ManyToOne
    @JoinColumn(name = "Id_Gerant", nullable = false)
    private int idGerant;

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

    public int getIdJeu() {
        return idJeu;
    }

    public void setIdJeu(int idJeu) {
        this.idJeu = idJeu;
    }

    public int getIdGerant() {
        return idGerant;
    }

    public void setIdGerant(int idGerant) {
        this.idGerant = idGerant;
    }

    public boolean verifierJeuTournoi(int idJeu) {
        return idJeu == this.idJeu;
    }


}
