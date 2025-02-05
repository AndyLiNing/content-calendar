package dev.ningli.content_calendar.Database.PureJDBC;


import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.util.Properties;


public class CustomDataSource {

    private static final Connection connection1;

    private static final Connection connection2;

    static {
        String DB_URL= "jdbc:mysql://localhost:3306/my_db";
        String dbUsername = System.getenv("DB_USER");
        String dbPassword = System.getenv("DB_PASSWORD");

        try {
            // Get non-pooled connection
            connection1 = DriverManager.getConnection(DB_URL, dbUsername, dbPassword);

            // Get pooled connection
            MysqlDataSource dataSource = new MysqlDataSource();
            loadDataSource(dataSource);
            connection2 = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection1;
    }

    public static Connection getPooledConnection() {
        return connection2;
    }

    private static void loadDataSource(MysqlDataSource dataSource) {

        Properties properties = LoadDatabaseProperties.getDatabaseProperties();

        dataSource.setServerName(properties.getProperty("databaseServerName"));
        dataSource.setDatabaseName(properties.getProperty("databaseName"));
        dataSource.setPort(Integer.parseInt(properties.getProperty("databasePort")));
        dataSource.setUser(properties.getProperty("databaseUser"));
        dataSource.setPassword(System.getenv("DATABASE_PASSWORD"));
    }

}
