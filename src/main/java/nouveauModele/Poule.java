package nouveauModele;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POULE", schema = "CTQ4266A")
public class Poule {
    @Id
    @Column(name = "ID_POULE")
    private int idPoule;
    @Column(name = "FINALE")
    private int finale;
    @Column(name = "ID_TOURNOI")
    private int idTournoi;

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
    public int getIdTournoi() {
        return idTournoi;
    }
    public void setIdTournoi(int idTournoi) {
        this.idTournoi = idTournoi;
    }

    @Override
    public String toString() {
        return "Poule{" +
                "idPoule=" + idPoule +
                ", finale=" + finale +
                ", idTournoi=" + idTournoi +
                '}';
    }
}

