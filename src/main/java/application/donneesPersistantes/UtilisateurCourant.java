package application.donneesPersistantes;

import modele.BDSelect;
import presentation.connexion.VueConnexion;

public class UtilisateurCourant {
    private static UtilisateurCourant utilisateurCourant;
    private int idLog;
    private ConnexionCourante etatConnexion;

    private UtilisateurCourant() {
        this.idLog = -1;
        this.etatConnexion = ConnexionCourante.ANNONYME;
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

    public ConnexionCourante getEtatConnexion() {
        return etatConnexion;
    }
    public static boolean tryConnect(String username, String password) {
        if(UtilisateurCourant.tryConnectManager(username, password) || UtilisateurCourant.tryConnectGestionnaire( username, password) || UtilisateurCourant.tryConnectArbitre(username, password)) {
            return true;
        }
        UtilisateurCourant.getInstance().setAnnonymous();
        return false;
    }

    private void setAnnonymous() {
        this.idLog = -1;
        this.etatConnexion = ConnexionCourante.ANNONYME;
    }


    protected static boolean tryConnectManager(String username, String password) {
        int id = BDSelect.getIdManagerFromLogs(username, password);
        if (id > -1) {
            UtilisateurCourant that = UtilisateurCourant.getInstance();
            that.idLog = id;
            that.etatConnexion = ConnexionCourante.MANAGER;
            return true;
        }
        return false;
    }
    protected static boolean tryConnectGestionnaire(String username, String password) {
        int id = BDSelect.getIdGestionnaireFromLogs(username, password);

        if (id > -1) {
            UtilisateurCourant that = UtilisateurCourant.getInstance();
            that.idLog = id;
            that.etatConnexion = ConnexionCourante.GESTIONNAIRE;
            return true;
        }
        return false;
    }
    protected static boolean tryConnectArbitre(String username, String password) {
        int id = BDSelect.getIdArbitreFromLogs(username, password);
        if (id > -1) {
            UtilisateurCourant that = UtilisateurCourant.getInstance();
            that.idLog = id;
            that.etatConnexion = ConnexionCourante.ARBITRE;
            return true;
        }
        return false;
    }
    public ConnexionCourante switchConnexion() {
        // le cas ou on est connecté, on déconnecte
        if (utilisateurCourant.getEtatConnexion() != ConnexionCourante.ANNONYME) {
            utilisateurCourant.setAnnonymous();
            return ConnexionCourante.ANNONYME;
        }
        new VueConnexion();
        return utilisateurCourant.getEtatConnexion();
    }
    public void deconnexion() {
        utilisateurCourant.setAnnonymous();
    }
}
