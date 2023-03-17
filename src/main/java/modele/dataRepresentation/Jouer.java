package modele.dataRepresentation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "JOUER", schema = "CTQ4266A")
public class Jouer {
    @EmbeddedId
    private JouerId id;

    @Column(name = "A_GAGNE")
    private int aGagne;


    @Embeddable
    public static class JouerId implements Serializable {
        @ManyToOne
        @JoinColumn(name = "ID_EQUIPE")
        private Equipe equipe;

        @ManyToOne
        @JoinColumn(name = "ID_RENCONTRE")
        private Rencontre rencontre;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            JouerId jouerId = (JouerId) o;
            return Objects.equals(equipe, jouerId.equipe) && Objects.equals(rencontre, jouerId.rencontre);
        }

        @Override
        public int hashCode() {
            return Objects.hash(equipe, rencontre);
        }
    }

    @Override
    public String toString() {
        return "Jouer{" +
                "id=" + id +
                ", aGagne=" + aGagne +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jouer jouer = (Jouer) o;
        return aGagne == jouer.aGagne && Objects.equals(id, jouer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aGagne);
    }

    public void setAGagne(boolean aGagne) {
        if(aGagne) {
            this.aGagne = 1;
        }else {
            this.aGagne = 0;
        }
    }
}
