package modele.dataRepresentation;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "RENCONTRE")
public class Rencontre {
    public Rencontre() {
    }
    @Id
    @Column(name = "ID_RENCONTRE")
    private int idRencontre;

    @ManyToOne()
    @JoinColumn(name = "ID_ARBITRE", nullable = false)
    private Arbitre arbitre;

    @ManyToOne()
    @JoinColumn(name = "ID_POULE", nullable = false)
    private Poule poule;

    @Column(name = "DATE_RENCONTRE")
    private LocalDate dateRencontre;
    public int getIdRencontre() {
        return idRencontre;
    }
    public void setIdRencontre(int idRencontre) {
        this.idRencontre = idRencontre;
    }
    public Arbitre getArbitre() {
        return arbitre;
    }
    public void setArbitre(Arbitre arbitre) {
        this.arbitre = arbitre;
    }
    public Poule getPoule() {
        return poule;
    }
    public void setPoule(Poule poule) {
        this.poule = poule;
    }
    public LocalDate getDateRencontre() {
        return dateRencontre;
    }
    public void setDateRencontre(LocalDate dateRencontre) {
        this.dateRencontre = dateRencontre;
    }

    @Override
    public String toString() {
        return "Rencontre{" +
                "idRencontre=" + idRencontre +
                ", arbitre=" + arbitre +
                ", poule=" + poule +
                ", dateRencontre=" + dateRencontre +
                '}';
    }
}