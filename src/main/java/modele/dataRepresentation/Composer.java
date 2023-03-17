package modele.dataRepresentation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "COMPOSER")
public class Composer {
    public Composer() {
    }

    @EmbeddedId
    private ComposerId id;

    @Embeddable
    public static class ComposerId implements Serializable {
        @ManyToOne
        @JoinColumn(name = "ID_Equipe")
        Equipe equipe;

        @ManyToOne
        @JoinColumn(name = "ID_POULE")
        Poule poule;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ComposerId that = (ComposerId) o;
            return Objects.equals(equipe, that.equipe) && Objects.equals(poule, that.poule);
        }

        @Override
        public int hashCode() {
            return Objects.hash(equipe, poule);
        }
    }
}
