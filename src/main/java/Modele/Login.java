package Modele;


public class Login {
    private final static String login = "ctq4266a";
    private final static String mdp = "toor";
    private final static String connectString = "jdbc:oracle:thin:@telline.univ-tlse3.fr:1521/ETUPRE";

    public static String getLogin() {
        return login;
    }

    public static String getMdp() {
        return mdp;
    }

    public static String getConnectString() {
        return connectString;
    }
}