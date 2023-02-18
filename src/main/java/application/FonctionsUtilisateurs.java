package application;

import application.exceptions.BadUserExecption;
import application.donneesPersistantes.ConnexionCourante;
import application.donneesPersistantes.Portee;
import application.donneesPersistantes.UtilisateurCourant;
import application.testeurs.TesteurTournoi;
import application.testeurs.date.PreDate;
import modele.BDInsert;
import modele.Jeu;

import java.util.List;

public class FonctionsUtilisateurs {
    private final ConnexionCourante con;
    private final int id;
    private int idLog;

    public FonctionsUtilisateurs(ConnexionCourante etatConnexion, int idLog) {
        this.con = etatConnexion;
        this.id = idLog;
    }



    public void launch() {
        switch (con) {
            case GESTIONNAIRE -> procedureCreerTournoi();
            case MANAGER -> procedureCreerEquipe();
        }
    }

    private void procedureCreerEquipe() {
        // Lancer formCreerEquipe
        // TODO Help shishi to launch the fenêtre please, il vous remercira gracieusement UwU
    }

    private void procedureCreerTournoi() {
        // Lancer formCreerTournoi
        // TODO Help shishi to launch the fenêtre please, il vous remercira gracieusement UwU

    }

    public static void insererTournoi(String nomTounoi, Portee porteeTournoi, PreDate dateFinInscription, PreDate dateDebutTournoi, PreDate dateFinTournoi, List<Jeu> jeux) throws IllegalArgumentException, BadUserExecption {
        if(UtilisateurCourant.getInstance().getEtatConnexion() != ConnexionCourante.GESTIONNAIRE) {
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
