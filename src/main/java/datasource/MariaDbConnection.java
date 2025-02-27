package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/currency_converter";
        String user = "zahra";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }
}
