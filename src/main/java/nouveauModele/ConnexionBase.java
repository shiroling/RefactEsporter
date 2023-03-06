package nouveauModele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBase {
    private final static String login = Login.getLogin();
    private final static String mdp = Login.getMdp();
    private final static String connectString = Login.getConnectString();

    private static Connection instance;

    private static Connection instanceBuilder() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            return DriverManager.getConnection(connectString, login, mdp);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getConnectionBase() {
        if(ConnexionBase.instance == null) {
            instance = ConnexionBase.instanceBuilder();
        }
        return instance;
    }


}