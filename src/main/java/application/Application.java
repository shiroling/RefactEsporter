package application;

import application.exceptions.BadUserExecption;
import application.modele.ConnexionState;
import application.modele.Portee;
import application.testeurs.date.PreDate;
import application.testeurs.TesteurTournoi;
import modele.Jeu;

import java.util.List;

import modele.BDInsert;
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
            BDInsert.insererTournoi(nomTounoi, porteeTournoi, dateFinInscription.toDate(), dateDebutTournoi.toDate(), dateFinTournoi.toDate(), jeux.get(0).getId(), UtilisateurCourant.getInstance().getIdLog());
        } else if (jeux.size() > 1) {
            for (Jeu j: jeux) {
                BDInsert.insererTournoi(nomTounoi + "-"+ j.getNom(), porteeTournoi, dateFinInscription.toDate(), dateDebutTournoi.toDate(), dateFinTournoi.toDate(), j.getId(), UtilisateurCourant.getInstance().getIdLog());
            }
        }
    }
}
