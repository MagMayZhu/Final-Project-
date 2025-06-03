import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    /*
     * Simple test to check DB connection
     */
    @Test
    public void testConnectionIsValid() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            assertNotNull(conn, "Connection should not be null");
            assertFalse(conn.isClosed(), "Connection should be open");
            System.out.println("Database connection is valid.");
        } catch (SQLException e) {
            fail("Exception occurred while connecting to the database: " + e.getMessage());
        }
    }
}
