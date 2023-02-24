package nouveauModele;

import javax.persistence.*;
@Entity
@Table(name = "Ecurie")
public class Ecurie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_Ecurie")
    @SequenceGenerator(name = "Seq_Ecurie", sequenceName = "Seq_Ecurie", allocationSize = 1)
    @Column(name = "Id_Ecurie")
    private int idEcurie;

    @Column(name = "Nom_Ecurie", nullable = false, unique = true)
    private String nomEcurie;

    @Column(name = "Nom_Manager", nullable = false)
    private String nomManager;

    @Column(name = "mdp_Manager", nullable = false)
    private String mdpManager;

    public int getIdEcurie() {
        return idEcurie;
    }

    public void setIdEcurie(int idEcurie) {
        this.idEcurie = idEcurie;
    }

    public String getNomEcurie() {
        return nomEcurie;
    }

    public void setNomEcurie(String nomEcurie) {
        this.nomEcurie = nomEcurie;
    }

    public String getNomManager() {
        return nomManager;
    }

    public void setNomManager(String nomManager) {
        this.nomManager = nomManager;
    }

    public String getMdpManager() {
        return mdpManager;
    }

    public void setMdpManager(String mdpManager) {
        this.mdpManager = mdpManager;
    }

    @Override
    public String toString() {
        return "Ecurie : " + nomEcurie + ", Manager='" + nomManager;
    }
}