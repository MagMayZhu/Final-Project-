import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDatabaseTest {

    @BeforeAll
    public static void testInsertUser()
    {
        String insertSQL = """
            INSERT INTO "Users" (firstname, lastname, email, password, display_name)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(insertSQL))
        {
            String first = "Jane";
            String last = "Doe";

            stmt.setString(1, first);
            stmt.setString(2, last);
            stmt.setString(3, "Jane.Doe22@kzoo.edu");
            stmt.setString(4, "StrongPassword123!");
            stmt.setString(5, first); // display_name defaults to firstname

            int rowsInserted = stmt.executeUpdate();
            assertEquals(1, rowsInserted, "One row should be inserted into Users");

        }
        catch (SQLException e)
        {
            fail("Insert failed: " + e.getMessage());
        }
    }

    @Test
    public void testQueryUserByEmailAndPassword() {
        String querySQL = """
            SELECT * FROM "Users" WHERE email = ? AND password = ?
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(querySQL)) {

            stmt.setString(1, "Jane.Doe22@kzoo.edu");
            stmt.setString(2, "StrongPassword123!");

            ResultSet rs = stmt.executeQuery();

            assertTrue(rs.next(), "User with matching email and password should exist");
            assertEquals("Jane", rs.getString("firstname"));
            assertEquals("Doe", rs.getString("lastname"));

        } catch (SQLException e) {
            fail("Query failed: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteUser()
    {
        String deleteSQL = """
            DELETE FROM "Users" WHERE email = ?
        """;

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(deleteSQL))
        {
            stmt.setString(1, "Jane.Doe22@kzoo.edu");
            int rowsDeleted = stmt.executeUpdate();
            System.out.println("Deleted rows: " + rowsDeleted);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
