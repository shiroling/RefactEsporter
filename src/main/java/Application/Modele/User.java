package Application.Modele;

import Application.Application;

public class User {
    private final int
            idLog;
    private final ConnexionState etatConnexion;

    public User(String username, String password) {
        if(Application.isManager(username, password)){
            this.idLog = Application.getIdGerantFromLogs(username, password);
            this.etatConnexion = ConnexionState.MANAGER;
        } else if(Application.isGestionnaire(username, password)) {
            this.idLog = Application.getIdGerantFromLogs(username, password);
            this.etatConnexion = ConnexionState.GESTIONNAIRE;
        }else if(Application.isArbitre(username, password)) {
            this.idLog = Application.getIdArbitreFromLogs(username, password);
            this.etatConnexion = ConnexionState.ARBITRE;
        } else {
            this.idLog = -1;
            this.etatConnexion = ConnexionState.INCONNU;
        }
    }

    public boolean existe() {
        return !(etatConnexion == ConnexionState.INCONNU);
    }

    public int getIdLog() {
        return idLog;
    }

    public ConnexionState getEtatConnexion() {
        return etatConnexion;
    }
}
