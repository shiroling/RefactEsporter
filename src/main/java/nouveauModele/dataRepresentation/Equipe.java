package nouveauModele.dataRepresentation;

import application.services.EquipeService;
import nouveauModele.repositories.EquipeRepository;

import javax.persistence.*;
// This stored procedure returns a result set and has one input parameter.
@NamedStoredProcedureQuery(
        name = "getPointsEquipe",
        resultClasses = Integer.class,
        procedureName = "GET_PTS_EQUIPE",
        parameters = {
                @StoredProcedureParameter(mode=javax.persistence.ParameterMode.IN, name="ID_EQ", type=Long.class)
        }
)
@Entity
@Table(name = "Equipe")
public class Equipe implements Comparable<Equipe> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Seq_Equipe")
    @SequenceGenerator(name = "Seq_Equipe", sequenceName = "Seq_Equipe", allocationSize = 1)
    @Column(name = "ID_EQUIPE", insertable = false, updatable = false)
    private int idEquipe;

    @Column(name = "nom_Equipe", nullable = false, unique = true)
    private String nomEquipe;

    @ManyToOne
    @JoinColumn(name = "Id_Jeu", referencedColumnName = "Id_Jeu", nullable = false)
    private Jeu jeu;

    @ManyToOne
    @JoinColumn(name = "Id_Ecurie", referencedColumnName = "Id_Ecurie", nullable = false)
    private Ecurie ecurie;

    public Equipe() {

    }

    public Equipe(String nomEquipe, Ecurie ecurieEnCharge, Jeu jeuJoue) {
        this.nomEquipe = nomEquipe;
        this.ecurie = ecurieEnCharge;
        this.jeu = jeuJoue;
    }

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

    @Override
    public int compareTo(Equipe o) {
        EquipeService service = EquipeService.getInstance();
        if(!(o instanceof Equipe)) {
            throw new IllegalArgumentException("l'objet en entrée n'est pas une instance d'équipe");
        }
        Equipe e = (Equipe) o;

        if(this.getIdEquipe() == (e).getIdEquipe()) {
            return 0;
        }

        float diffPoints = EquipeRepository.getInstance().getPoints(this) - EquipeRepository.getInstance().getPoints(e);
        if(diffPoints != 0) {
            if (diffPoints < 0) {
                return -1;
            } else {
                return 1;
            }
        }

        float diffAge = service.getAgeMoyen(this) - service.getAgeMoyen(e);
        if(diffAge != 0) {
            if (diffAge < 0) {
                return -1;
            } else {
                return 1;
            }
        }

        return this.getNomEquipe().compareTo(e.getNomEquipe());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipe equipe = (Equipe) o;

        if (idEquipe != equipe.idEquipe) return false;
        return nomEquipe.equals(equipe.nomEquipe);
    }

    @Override
    public int hashCode() {
        int result = idEquipe;
        result = 31 * result + nomEquipe.hashCode();
        return result;
    }


}