package modele.dataRepresentation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "INSCRIT")
public class Inscrit {

    public Inscrit() {

    }

    @EmbeddedId
    private InscritId id;

    @Column(name = "DATEINSCRIPTION")
    private Date dateInscription;

    public Inscrit(Equipe equipeAInscrire, Tournoi tournoiHote, Date now) {
        this.id = new InscritId();
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InscritId inscritId = (InscritId) o;
            return Objects.equals(equipe, inscritId.equipe) && Objects.equals(tournoi, inscritId.tournoi);
        }

        @Override
        public int hashCode() {
            return Objects.hash(equipe, tournoi);
        }
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
