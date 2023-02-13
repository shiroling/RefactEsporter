package Model;

import javax.persistence.*;
@Entity
@Table(name = "Arbitre")
public class Arbitre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_Arbitre")
    @SequenceGenerator(name = "Seq_Arbitre", sequenceName = "Seq_Arbitre", allocationSize = 1)
    @Column(name = "Id_Arbitre")
    private int idArbitre;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "mdp")
    private String mdp;

    public int getIdArbitre() {
        return idArbitre;
    }

    public void setIdArbitre(int idArbitre) {
        this.idArbitre = idArbitre;
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