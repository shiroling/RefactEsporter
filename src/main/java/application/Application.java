package application;

import application.donneesPersistantes.UtilisateurCourant;
import modele.Ecurie;
import modele.Equipe;
import modele.Tournoi;
import presentation.Popup.PopupTournoi.PopupTournoi;
import presentation.Popup.PopupInscrireEquipe.PopupInscrireEquipe;

public class Application {

    public static void main(String[] args) { //TEST
        afficherPopupTournoi(new Tournoi(2556502));

    }

    public static void afficherPopupTournoi(Tournoi tournoi) {
        PopupTournoi popupTournoi = new PopupTournoi(tournoi);
        popupTournoi.setVisible(true);
    }
    public static void procedureInitierInscrireEquipe(Tournoi tournoi) {
        PopupInscrireEquipe popupInscrireEquipe = new PopupInscrireEquipe(new Ecurie(UtilisateurCourant.getInstance().getIdLog()), tournoi);
        popupInscrireEquipe.setVisible(true);
    }

    public static void procedureInscrireEquipe(Equipe equipeAInscrire, Tournoi tournoi) {
        //AppTournoi.getInstance().inscrireEquipe();
        tournoi.inscrireEquipe(equipeAInscrire);
        PopupTournoi popupTournoi = new PopupTournoi(tournoi);
        popupTournoi.setVisible(true);
    }

    // Regarder si votre truc a mettre ici ne convient pas déjà à FonctionUtilisateurs
    // si il sagit d'un validateur (priére de le mettre dans le paquer du méme nom)
    // si il sagit d'un Filtre (priére de le mettre dans le paquer du méme nom)
    // si il sagit d'un truc en rapport avec la connexion checkez dans donneesPersistantes


    // sinon
    // fourrez tout ici, je ferais le tri

}
