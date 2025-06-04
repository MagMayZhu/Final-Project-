import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {

    @Test
    public void testBioField_ValidCases() {
        //Empty string (should be valid based on requirements).
        assertTrue(InputValidator.validateBioField(""));
        
        //String with exactly 199 characters.
        assertTrue(InputValidator.validateBioField("a".repeat(199)));
        
        //String with special characters.
        assertTrue(InputValidator.validateBioField("Valid! @#$%^&*()_+=- desc"));
        
        //String with newlines.
        assertTrue(InputValidator.validateBioField("Line1\nLine2"));
    }

    @Test
    public void testBioField_InvalidCases() {
        //Null input
        assertFalse(InputValidator.validateBioField(null));
        
        //String with exactly 200 characters (should be invalid based on '< 200' check)
        assertFalse(InputValidator.validateBioField("a".repeat(200)));
        
        //String with 201 characters
        assertFalse(InputValidator.validateBioField("a".repeat(201)));
    }

    @Test
    public void testBioField_BoundaryCases() {
        //Minimum valid case (empty string)
        assertTrue(InputValidator.validateBioField(""));
        
        //Maximum valid case (199 characters)
        assertTrue(InputValidator.validateBioField("a".repeat(199)));
        
        //Boundary invalid case (200 characters)
        assertFalse(InputValidator.validateBioField("a".repeat(200)));
    }
}