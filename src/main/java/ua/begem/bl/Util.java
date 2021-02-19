package ua.begem.bl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "some url";
    private static final String DB_USERNAME = "";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection has been established!");
        }
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection ERROR!");
            e.printStackTrace();
        }

        return connection;
    }

}
