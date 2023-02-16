package Application;

import Application.Modele.ConnexionState;
import Modele.BDSelect;

public class UtilisateurCourant {
    private static UtilisateurCourant utilisateurCourant;
    private int idLog;
    private ConnexionState etatConnexion;

    private UtilisateurCourant() {
        this.idLog = -1;
        this.etatConnexion = ConnexionState.ANNONYME;
    }

    public static UtilisateurCourant getInstance() {
        if (utilisateurCourant == null) {
            utilisateurCourant = new UtilisateurCourant();
        }
        return utilisateurCourant;
    }

    public int getIdLog() {
        return idLog;
    }

    public ConnexionState getEtatConnexion() {
        return etatConnexion;
    }
    public static boolean connexion(String username, String password) {
        if(UtilisateurCourant.tryConnectManager(username, password) || UtilisateurCourant.tryConnectGestionnaire( username, password) || UtilisateurCourant.tryConnectArbitre(username, password)) {
            return true;
        }
        UtilisateurCourant.getInstance().setAnnonymous();
        return false;
    }

    private void setAnnonymous() {
        this.idLog = -1;
        this.etatConnexion = ConnexionState.ANNONYME;
    }


    protected static boolean tryConnectManager(String username, String password) {
        int id = BDSelect.getIdManagerFromLogs(username, password);
        if (id > -1) {
            UtilisateurCourant that = UtilisateurCourant.getInstance();
            that.idLog = id;
            that.etatConnexion = ConnexionState.MANAGER;
            return true;
        }
        return false;
    }
    protected static boolean tryConnectGestionnaire(String username, String password) {
        int id = BDSelect.getIdGestionnaireFromLogs(username, password);

        if (id > -1) {
            UtilisateurCourant that = UtilisateurCourant.getInstance();
            that.idLog = id;
            that.etatConnexion = ConnexionState.GESTIONNAIRE;
            return true;
        }
        return false;
    }
    protected static boolean tryConnectArbitre(String username, String password) {
        int id = BDSelect.getIdArbitreFromLogs(username, password);
        if (id > -1) {
            UtilisateurCourant that = UtilisateurCourant.getInstance();
            that.idLog = id;
            that.etatConnexion = ConnexionState.ARBITRE;
            return true;
        }
        return false;
    }

    public static void deconnexion() {
        utilisateurCourant.setAnnonymous();
    }
}
