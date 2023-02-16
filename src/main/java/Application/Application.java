package Application;

import Application.Exceptions.BadUserExecption;
import Application.Modele.ConnexionState;
import Application.Modele.Portee;
import Application.Testeurs.Date.PreDate;
import Application.Testeurs.TesteurTournoi;
import NouveauModele.Jeu;

import java.util.Date;
import java.util.List;

import Modele.BDInsert;
public class Application {

    public static void insererTournoi(String nomTounoi, Portee porteeTournoi, PreDate dateFinInscription, PreDate dateDebutTournoi, PreDate dateFinTournoi, List<Jeu> jeux) throws IllegalArgumentException, BadUserExecption {
        if(UtilisateurCourant.getInstance().getEtatConnexion() != ConnexionState.GESTIONNAIRE) {
            throw new BadUserExecption("L'utilisateur connecté n'est pas un gérant");
        }
        try {
            TesteurTournoi.isValid(nomTounoi, dateFinInscription, dateDebutTournoi, dateFinTournoi);
        } catch (IllegalArgumentException e ) {
            throw e;
        }
        if (jeux.size() == 1) {
            BDInsert.insererTournoi(nomTounoi, porteeTournoi, dateFinInscription.toDate(), dateDebutTournoi.toDate(), dateFinTournoi.toDate(), jeux.get(0).getIdJeu(), UtilisateurCourant.getInstance().getIdLog());
        } else if (jeux.size() > 1) {
            for (Jeu j: jeux) {
                BDInsert.insererTournoi(nomTounoi + "-"+ j.getNomJeu(), porteeTournoi, dateFinInscription.toDate(), dateDebutTournoi.toDate(), dateFinTournoi.toDate(), j.getIdJeu(), UtilisateurCourant.getInstance().getIdLog());
            }
        }
    }
}
