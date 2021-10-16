package mysql;

import properties.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnector {
    private static Connection connection;

    public Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(PropertyReader.getProperties().getProperty("db"));
            }
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Statement getStatement() {
        try {
            return getConnection().createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
