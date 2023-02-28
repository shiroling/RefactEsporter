package nouveauModele;

import javax.persistence.*;
import java.util.Date;

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
    private Date dateRencontre;
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
    public Date getDateRencontre() {
        return dateRencontre;
    }
    public void setDateRencontre(Date dateRencontre) {
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