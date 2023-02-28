package nouveauModele;

import javax.persistence.*;
import java.io.Serializable;

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
    }

    @Override
    public String toString() {
        return "Jouer{" +
                "id=" + id +
                ", aGagne=" + aGagne +
                '}';
    }
}
