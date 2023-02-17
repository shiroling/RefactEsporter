package nouveauModele;

import javax.persistence.*;
@Entity
@Table(name = "Gerant")
public class Gerant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_Gerant")
    @SequenceGenerator(name = "Seq_Gerant", sequenceName = "Seq_Gerant", allocationSize = 1)
    @Column(name = "Id_Gerant")
    private int idGerant;

    @Column(name = "Nom", nullable = false)
    private String nom;

    @Column(name = "mdp", nullable = false)
    private String mdp;

    public int getIdGerant() {
        return idGerant;
    }

    public void setIdGerant(int idGerant) {
        this.idGerant = idGerant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}