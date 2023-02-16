package Application;

import Application.Modele.Portee;
import Application.Modele.User;
import NouveauModele.Jeu;

import java.util.Date;
import java.util.List;

import static Modele.Tournoi.isValidNom;

public class Application {

    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Application.user = user;
        //REFRESH ACCUEIL : accueil doit cacher btn Connexion
    }

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



    public static void afficherBtnConnexionAccueil() {
    }

    public static boolean isArbitre(String username, String password) {
    }

    public static boolean isManager(String username, String password) {
    }

    public static boolean isGestionnaire(String username, String password) {
    }

    public static void cacherBtnConnexionAccueil() {
    }

    public static int getIdArbitreFromLogs(String username, String password) {
    }


    public static int getIdManagerFromLogs(String username, String password) {
    }

    public static int getIdGerantFromLogs(String username, String password) {
    }
}
