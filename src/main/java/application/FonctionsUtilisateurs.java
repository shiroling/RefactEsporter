package application;

import application.donneesPersistantes.UtilisateurCourant;

public class FonctionsUtilisateurs {

    public FonctionsUtilisateurs() {

    }



    public static void launch() {
        UtilisateurCourant ut = UtilisateurCourant.getInstance();
        switch (ut.getEtatConnexion()) {
            case GESTIONNAIRE -> procedureCreerTournoi(ut.getIdLog());
            case MANAGER -> procedureCreerEquipe(ut.getIdLog());
        }
    }

    private static void procedureCreerEquipe(int idLog) {
        // Lancer formCreerEquipe
        // TODO Help shishi to launch the fenêtre please, il vous remercira gracieusement UwU
    }

    private static void procedureCreerTournoi(int idLog) {
        // Lancer formCreerTournoi
        // TODO Help shishi to launch the fenêtre please, il vous remercira gracieusement UwU
    }
/*
    public static void insererTournoi(String nomTounoi, Portee porteeTournoi, Date dateFinInscription, LocalDate dateDebutTournoi, LocalDate dateFinTournoi, List<Jeu> jeux) throws IllegalArgumentException, BadUserExecption {
        if(UtilisateurCourant.getInstance().getEtatConnexion() != ConnexionCourante.GESTIONNAIRE) {
            throw new BadUserExecption("L'utilisateur connecté n'est pas un gérant");
        }
        try {
            TesteurTournoi.isValid(nomTounoi, dateFinInscription, dateDebutTournoi, dateFinTournoi);
        } catch (IllegalArgumentException e ) {
            throw e;
        }
        if (jeux.size() == 1) {
            BDInsert.insererTournoi(nomTounoi, porteeTournoi, dateFinInscription, dateDebutTournoi, dateFinTournoi, jeux.get(0).getId(), UtilisateurCourant.getInstance().getIdLog());
        } else if (jeux.size() > 1) {
            for (Jeu j: jeux) {
                BDInsert.insererTournoi(nomTounoi + "-"+ j.getNom(), porteeTournoi, dateFinInscription.toDate(), dateDebutTournoi.toDate(), dateFinTournoi.toDate(), j.getId(), UtilisateurCourant.getInstance().getIdLog());
            }
        }

    }

 */

}
