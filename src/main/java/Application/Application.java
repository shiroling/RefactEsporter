package Application;

import Modele.Jeu;

import java.util.Date;
import java.util.List;

public class Application {

    public static void insererTournoi(String nomTounoi, Portee porteeTournoi, Date dateFinInscription, Date dateDebutTournoi, Date dateFinTournoi, Jeu j, int idGerant) throws IllegalArgumentException {
        if(!isValidNom(nomTounoi)) {
            throw new IllegalArgumentException("Le nom donné au tournoi est déjà pris");
        }

        if(!isValidDates(dateFinInscription, dateDebutTournoi, dateFinTournoi)) {
            throw new IllegalArgumentException("Les dates données ne corélent pas");
        }
        if(!isvalidGerant(idGerant)) {
            throw new IllegalArgumentException("Le gérant"+ idGerant +" n'existe pas");
        }

        BDInsert.insererTournoi(nomTounoi, porteeTournoi, dateFinInscription, dateDebutTournoi, dateFinTournoi, j.getId(), idGerant);

        //FenMessage dialog = new FenMessage("Le tournoi '" + this.vue.getTextFieldNom().getText() + "' à bien été créé");
        //dialog.setVisible(true);
    }

    public static void insererTournoisMultigaming(String nomTournoi, Portee porteeTournoi, Date dateFinInscription, Date dateDebutTournoi, Date dateFinTournoi, List<Jeu> jeux, int idGerant) {
        for (Jeu j :jeux) {
            insererTournoi(nomTournoi + " - " + j.getNom(), porteeTournoi, dateFinInscription, dateDebutTournoi, dateFinTournoi, j, idGerant);
        }
    }

}
