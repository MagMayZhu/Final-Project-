import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class DatabaseConnection
{
    private static String url;
    private static String user;
    private static String password;

    // Static block: Executes once when the class is loaded
    static {
        try {
            // Load properties from external private configuration file
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("config.properties");
            props.load(fis);

            // Extract DB configuration values
            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");
        }
        catch (IOException e)
        {
            // Handle error if properties file cannot be loaded
            System.err.println("Could not load database configuration.");
            e.printStackTrace();
        }
    }

    // Public method to get a database connection using stored credentials
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url, user, password);
    }

}
