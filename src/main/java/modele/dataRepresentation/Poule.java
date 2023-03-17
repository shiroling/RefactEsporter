package modele.dataRepresentation;


import javax.persistence.*;


@Entity
@Table(name = "POULE", schema = "CTQ4266A")
public class Poule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_POULE")
    @SequenceGenerator(name = "SEQ_POULE", sequenceName = "SEQ_POULE", allocationSize = 1)
    @Column(name = "ID_POULE")
    private int idPoule;
    @Column(name = "FINALE")
    private int finale;
    @ManyToOne
    @JoinColumn(name = "ID_TOURNOI")
    private Tournoi tournoi;

    public Poule() {}
    public Poule(int finale, Tournoi tournoi) {
        this.finale = finale;
        this.tournoi = tournoi;
    }

    public int getIdPoule() {
        return idPoule;
    }
    public void setIdPoule(int idPoule) {
        this.idPoule = idPoule;
    }
    public int getFinale() {
        return finale;
    }
    public void setFinale(int finale) {
        this.finale = finale;
    }
    public Tournoi getTournoi() {
        return tournoi;
    }
    public void setIdTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }

    @Override
    public String toString() {
        return "Poule{" +
                "idPoule=" + idPoule +
                ", finale=" + finale +
                ", Tournoi=" + tournoi +
                '}';
    }
}

