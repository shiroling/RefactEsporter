package nouveauModele;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "INSCRIT")
public class Inscrit {

    @EmbeddedId
    private InscritId id;

    @Column(name = "DATEINSCRIPTION")
    private Date dateInscription;

    public Inscrit(Equipe equipeAInscrire, Tournoi tournoiHote, Date now) {
        setTournoi(tournoiHote);
        setEquipe(equipeAInscrire);
        setDateInscription(now);
    }

    @Embeddable
    public static class InscritId implements Serializable {
        @ManyToOne
        @JoinColumn(name = "ID_Equipe")
        Equipe equipe;

        @ManyToOne
        @JoinColumn(name = "ID_TOURNOI")
        Tournoi tournoi;
    }

    public Equipe getEquipe() {
        return id.equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.id.equipe = equipe;
    }
    public Tournoi getTournoi() {
        return id.tournoi;
    }

    public void setTournoi(Tournoi tournoi) {
        this.id.tournoi = tournoi;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }
}
