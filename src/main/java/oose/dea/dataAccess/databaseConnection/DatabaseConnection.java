package oose.dea.dataAccess.databaseConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    public Connection getConnection(){
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        InputStream resourceAsStream = contextClassLoader.getResourceAsStream("JDBC.properties");

        Properties props = new Properties();
        Connection conn = null;

        try {
            props.load(resourceAsStream);

            String connectionString = props.getProperty("DB_URL") + ";user=" + props.getProperty("DB_USERNAME") + ";password=" + props.getProperty("DB_PASSWORD") + ";";
            Class.forName(props.getProperty("DB_DRIVER_CLASS"));
            conn = DriverManager.getConnection(connectionString);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        DatabaseConnection connection = new DatabaseConnection();
        if(connection.getConnection() == null){
            System.out.println("no connection");
        } else {
            System.out.println("Connected");
        }
    }
}
