package nouveauModele;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


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
    }
}
