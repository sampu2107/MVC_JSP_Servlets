package onlineRetailStore.utility;

import java.sql.*;

/**
 *
 * @author Sampath Kumar Gunasekaran ConnectionPool Utility class to get the RDS
 * database connection.
 */
public class ConnectionPool {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String dbName = "onlineRetailStore";
        String userName = "awssgunase2";
        String password = "sampu143";
        String hostname = "onlineretailstore.c49lo9vbp5fw.us-east-1.rds.amazonaws.com";
        String port = "3306";
        String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
        return DriverManager.getConnection(jdbcUrl);
    }
}
