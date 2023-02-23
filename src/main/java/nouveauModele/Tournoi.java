package nouveauModele;

import java.util.Date;
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
    private String name;

    @Column(name = "Portee", nullable = false)
    private String scope;

    @Column(name = "dateFinInscriptions", nullable = false)
    private Date endRegistrationDate;

    @Column(name = "dateDebutTournoi", nullable = false)
    private Date startTournamentDate;

    @Column(name = "dateFinTournoi", nullable = false)
    private Date endTournamentDate;

    @ManyToOne
    @JoinColumn(name = "Id_Jeu", nullable = false)
    private Jeu game;

    @ManyToOne
    @JoinColumn(name = "Id_Gerant", nullable = false)
    private Gerant manager;

    public boolean verifierJeuTournoi(int idJeu) {
        return idJeu == this.game.getIdJeu();
    }

    // Getters and setters
}
