package NouveauModele;

import javax.persistence.*;

@Entity
@Table(name = "Jeu")
public class Jeu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_Jeu")
    @SequenceGenerator(name = "Seq_Jeu", sequenceName = "Seq_Jeu", allocationSize = 1)
    @Column(name = "Id_Jeu")
    private int idJeu;

    @Column(name = "Nom_jeu", nullable = false, unique = true)
    private String nomJeu;

    @Column(name = "PATH_LOGO", nullable = false)
    private String logo;

    public static Jeu getJeuFromName(String toString) {
    }

    public int getIdJeu() {
        return idJeu;
    }

    public void setIdJeu(int idJeu) {
        this.idJeu = idJeu;
    }

    public String getNomJeu() {
        return nomJeu;
    }

    public void setNomJeu(String nomJeu) {
        this.nomJeu = nomJeu;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}