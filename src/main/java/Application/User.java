package Application;

public class User {

    private String username;
    private String password;
    private int idLog;
    private ConnexionState etatConnexion;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.connectUser();
    }

    private void connectUser() {
        if(Application.isManager(this.username, this.password)){
            this.idLog = Application.getIdGerantFromLogs(this.username, this.password);
            this.etatConnexion = ConnexionState.MANAGER;
        } else if(Application.isGestionnaire(this.username, this.password)) {
            this.idLog = Application.getIdGerantFromLogs(this.username, this.password);
            this.etatConnexion = ConnexionState.GESTIONNAIRE;
        }else if(Application.isArbitre(this.username, this.password)) {
            this.idLog = Application.getIdArbitreFromLogs(this.username, this.password);
            this.etatConnexion = ConnexionState.GESTIONNAIRE;
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
