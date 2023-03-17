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
            e.printStackTrace();
        }

        try {
            return DriverManager.getConnection(Login.getConnectString(), Login.getLogin(), Login.getMdp());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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
