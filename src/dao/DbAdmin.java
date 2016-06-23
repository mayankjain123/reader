package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

// This class sets up the database
public class DbAdmin {

    private static String dbURL = "jdbc:mysql://localhost:3306/";
    private static String schemaName = "thereader";
    private static String dbUsername = "root";
    private static String dbPassword = "root";
    private static Connection connection;

    // openshift config
    /*private static String dbURL = "jdbc:mysql://127.6.217.130:3306/";
    private static String schemaName = "reader";
    private static String dbUsername = "admingmhKtV7";
    private static String dbPassword = "5QX5Qm_XaQPP";
    */
    public DbAdmin() {
        try {
            // load the DB driver
            Class.forName("com.mysql.jdbc.Driver");
            // get a DB connection
            connection = DriverManager.getConnection(dbURL + schemaName, dbUsername, dbPassword);
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR: Driver not found");
            connection = null;

        } catch (SQLException ex) {
            System.out.println("ERROR: Could not create DB connection");
        }

    }

    public static Statement getNewStatement() {
        Statement statement;
        try {
            if (connection == null) {
                new DbAdmin();
            }
            /* Creating a statement object that we can use for running
             * SQL statements commands against the database.*/
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("ERROR: Could not create SQL statement object: " + e);
            statement = null;
        }
        return statement;
    }

    public static Connection getConnection() {
        if (connection == null) {
            new DbAdmin();
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
