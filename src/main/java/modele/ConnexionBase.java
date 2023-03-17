package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBase {
    private static Connection instance;

    private static Connection instanceBuilder() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            throw new RuntimeException("Impossible d'initialiser le driver");
        }

        try {
            return DriverManager.getConnection(Login.getConnectString(), Login.getLogin(), Login.getMdp());
        } catch (SQLException e) {
            throw new RuntimeException("Impossible de se connecter à la base de données");
        }
    }

    private ConnexionBase() {
    }

    public static Connection getConnectionBase() {
        if(ConnexionBase.instance == null) {
            instance = ConnexionBase.instanceBuilder();
        }
        return instance;
    }


}
