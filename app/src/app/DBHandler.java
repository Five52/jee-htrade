package app;

import persons.IPersonDB;
import persons.PersonDBStub;

import habitations.IHabitationDB;
import habitations.HabitationDBStub;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * Class to handle databases for the application.
 * It is a factory simulating singletons.
 */
public class DBHandler {
    
    /**
     * Location of the dbConfig.properties file
     */
    private static final String DB_CONFIG_FILE = "/dbConfig.properties";

    /**
     * Connection to the MySQL database
     */
    private static Connection connection;

    /**
     * The person database
     */
    private static IPersonDB personDB;

    /**
     * The habitation database
     */
    private static IHabitationDB habitationDB;

    /**
     * Create the person database if it haven't been created before and returns it
     * @return IPersonDB the person database
     */
    public static IPersonDB getPersonDB() {
        if (personDB == null) {
            personDB = new PersonDBStub();
        }
        return personDB;
    }

    /**
     * Create the habitation database if it haven't been created before and returns it
     * @return IHabitationDB the person database
     */
    public static IHabitationDB getHabitationDB() {
        if (habitationDB == null) {
            habitationDB = new HabitationDBStub();
        }
        return habitationDB;
    }

    protected static Connection getConnection() throws SQLException {
        Properties dbConfig = getDBConfig();

        if (connection == null) {
            MysqlDataSource ds = new MysqlDataSource();
            ds.setServerName(dbConfig.getProperty("host"));
            ds.setDatabaseName(dbConfig.getProperty("database"));
            connection = ds.getConnection(dbConfig.getProperty("username"), dbConfig.getProperty("password"));
        }
        if (!connection.isValid(0)) {
            throw new SQLException("Failed to initialize a valide connection to the database.");
        }
        return connection; 

    }
    protected static Properties getDBConfig() {
        Properties properties = new Properties();
        InputStream input = null;

        try {
            input = properties.getClass().getResourceAsStream(DB_CONFIG_FILE);
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Property loading exception raised: " + e);
            return null;
        }

        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                System.out.println("Exception raised during file closure: " + e);
                return null;
            }
        }

        return properties;
    }
}
