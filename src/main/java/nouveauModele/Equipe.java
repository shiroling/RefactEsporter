package nouveauModele;

import javax.persistence.*;
@Entity
@Table(name = "Equipe")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_Equipe")
    @SequenceGenerator(name = "Seq_Equipe", sequenceName = "Seq_Equipe", allocationSize = 1)
    @Column(name = "Id_Equipe")
    private int idEquipe;

    @Column(name = "nom_Equipe", nullable = false, unique = true)
    private String nomEquipe;

    @ManyToOne
    @JoinColumn(name = "Id_Jeu", referencedColumnName = "Id_Jeu", nullable = false)
    private Jeu jeu;

    @ManyToOne
    @JoinColumn(name = "Id_Ecurie", referencedColumnName = "Id_Ecurie", nullable = false)
    private Ecurie ecurie;

    public int getIdEquipe() {
        return idEquipe;
    }
    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }
    public String getNomEquipe() {
        return nomEquipe;
    }
    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }
    public Jeu getJeu() {
        return jeu;
    }
    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }
    public Ecurie getEcurie() {
        return ecurie;
    }
    public void setEcurie(Ecurie ecurie) {
        this.ecurie = ecurie;
    }
    @Override
    public String toString() {
        return "Equipe {" +
                "idEquipe=" + idEquipe +
                ", nomEquipe='" + nomEquipe +
                '}';
    }
}