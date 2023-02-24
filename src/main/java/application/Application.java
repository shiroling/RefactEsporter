package application;

import application.donneesPersistantes.ModeleGlobal;
import application.donneesPersistantes.Selection;
import presentation.accueil.VueAccueil;
import application.donneesPersistantes.UtilisateurCourant;
import modele.*;
import presentation.Popup.PopupEcurie.PopupEcurie;
import presentation.Popup.PopupEquipe.PopupEquipe;
import presentation.Popup.PopupIndiquerVainqueur.PopupIndiquerVainqueur;
import presentation.Popup.PopupJeu.PopupJeu;
import presentation.Popup.PopupJoueur.PopupJoueur;
import presentation.Popup.PopupRencontre.PopupRencontre;
import modele.Ecurie;
import modele.Equipe;
import modele.Rencontre;
import modele.Tournoi;
import presentation.Popup.PopupEcurie.PopupEcurie;
import presentation.Popup.PopupTournoi.PopupTournoi;
import presentation.Popup.PopupInscrireEquipe.PopupInscrireEquipe;

public class Application {

    private static Application instance;
    private VueAccueil vueAccueil;
    public static void main(String[] args) {
        (new  Application()).runApp();
    }

    public static Application getinstance() {
        if(instance == null) {
            instance = new Application();
        }
        return instance;
    }

    public void runApp() {
        vueAccueil =  new VueAccueil();
        vueAccueil.setVisible(true);
    }

    public void changerEtatAffichage(Selection select) {
        ModeleGlobal.getInstance().updateListeCourante(select);
        this.vueAccueil.updateToState(select);
    }

    public static void procedureInitierInscrireEquipe(Tournoi tournoi) {
        PopupInscrireEquipe popupInscrireEquipe = new PopupInscrireEquipe(new Ecurie(UtilisateurCourant.getInstance().getIdLog()), tournoi);
        popupInscrireEquipe.setVisible(true);
    }

    public static void procedureInscrireEquipe(Equipe equipeAInscrire, Tournoi tournoi) {
        //AppTournoi.getInstance().inscrireEquipe();
        tournoi.inscrireEquipe(equipeAInscrire);
        afficherPopupTournoi(tournoi);
    }

    public static void afficherPopupIndiquerVainqueurRencontre(Rencontre rencontre) {
        PopupIndiquerVainqueur indiquerVainqueur = new PopupIndiquerVainqueur(rencontre);
        indiquerVainqueur.setVisible(true);
    }


    // Regarder si votre truc a mettre ici ne convient pas déjà à FonctionUtilisateurs
    // si il sagit d'un validateur (priére de le mettre dans le paquer du méme nom)
    // si il sagit d'un Filtre (priére de le mettre dans le paquer du méme nom)
    // si il sagit d'un truc en rapport avec la connexion checkez dans donneesPersistantes


    // sinon
    // fourrez tout ici, je ferais le tri

}
