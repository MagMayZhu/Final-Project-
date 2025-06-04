import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {

    

@Test
    public void testPasswordFieldIsNotEmpty() {
        assertTrue(InputValidator.validatePasswordField("Password123"));
        assertFalse(InputValidator.validatePasswordField(""));
        assertFalse(InputValidator.validatePasswordField(" "));
    }

@Test
    public void testvalidatelastNameField() {
      //True cases 
      assertTrue(InputValidator.validatelastNameField("García")); //Testing to make sure it takes Diacritic marks. 
      assertTrue(InputValidator.validatelastNameField("'Niyah'")); //testing for names beginning with "'"
      assertTrue(InputValidator.validatelastNameField("A Niyah")); //testing if it takes names with spaces
      //False cases 
      assertFalse(InputValidator.validatelastNameField("'  '")); //testing to ensure sure you cannot just input a " ' " 
      assertFalse(InputValidator.validatelastNameField("@&$")); //Makes sure that you cannot take a special character 
      assertFalse(InputValidator.validatelastNameField("A")); //Makes sure you have to have atleast 2 characters 
    }
    @Test
    public void testNameFieldIsNotEmpty() 
    {
        assertTrue(InputValidator.validateFirstNameField("John"));
        assertFalse (InputValidator.validateFirstNameField(""));
        assertFalse (InputValidator.validateFirstNameField(" "));
    }

    @Test
    public void testNameMinLength() {
        assertFalse(InputValidator.validateFirstNameField("A"));
        assertTrue(InputValidator.validateFirstNameField("Al"));
    }

    @Test
    public void testNameWithSpaces() {
        assertTrue(InputValidator.validateFirstNameField("Nailia Narynbek"));
    }

    @Test
    public void testNameWithDiacritics() {
        assertTrue(InputValidator.validateFirstNameField("Zoë"));
        assertTrue(InputValidator.validateFirstNameField("Björk"));
    }

    @Test
    public void testNameWithInvalidCharacters() {
        assertFalse(InputValidator.validateFirstNameField("John123"));
        assertFalse(InputValidator.validateFirstNameField("!@#"));
        assertFalse(InputValidator.validateFirstNameField("Anna*"));
    }

    @Test
    public void testNameNull() {
        assertFalse(InputValidator.validateFirstNameField(null));
    }
    @Test
    public void testValidImageFile() throws Exception {
        assertTrue(InputValidator.isValidImageFile("maggie.jpg"));
        assertTrue(InputValidator.isValidImageFile("Leo.jpg"));
        assertTrue(InputValidator.isValidImageFile("Edith.jpg"));
    }
    @Test
    public void testInvalidImageFile () throws Exception {
        assertFalse(InputValidator.isValidImageFile("test.pdf")); // Wrong file extension
        assertFalse(InputValidator.isValidImageFile("7")); // File exceeding size limit
    }
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

    @Test
    public void testValidEmail() {
        // Test valid email
        assertTrue(InputValidator.validEmail("edith.aviles23@kzoo.edu"));
        assertTrue(InputValidator.validEmail("maggie.zhu24@kzoo.edu"));
        assertTrue(InputValidator.validEmail("camila.benavidez21@kzoo.edu"));
        assertTrue(InputValidator.validEmail("paul.dinsmore22@kzoo.edu"));
}
@Test
    public void testInvalidEmail() {
        // Test invalid email
        assertFalse(InputValidator.validEmail("schooll@hotmail.com"));
        assertFalse(InputValidator.validEmail("avilesedith2005@gmail.com"));
        assertFalse(InputValidator.validEmail("goodness@att.net"));
        assertFalse(InputValidator.validEmail("edith.aviles23@go.edu"));
    }
    @Test
    public void testValidPass() {
        assertTrue(InputValidator.validPassword("Password12"));
        assertTrue(InputValidator.validPassword("Valid1234"));
        assertTrue(InputValidator.validPassword("goodness123"));
        assertTrue(InputValidator.validPassword("StrongPass1"));;
    }
    @Test
    public void testInvalidPass() {
        // Test invalid passwords
        assertFalse(InputValidator.validPassword("short"));
        assertFalse(InputValidator.validPassword("NoNumber"));
        assertFalse(InputValidator.validPassword("123456b"));
        assertFalse(InputValidator.validPassword(null));
    }

    @Test
    public void testConfirmPassword() {
        // Test Confirm Password
        assertTrue(InputValidator.ConfirmPassword("Password12", "Password12"));
        assertTrue(InputValidator.ConfirmPassword("Valid1234", "Valid1234"));
        assertTrue(InputValidator.ConfirmPassword("123456b", "123456b"));
        assertTrue(InputValidator.ConfirmPassword("StrongPass1", "StrongPass1"));
    }

    @Test
    public void testConfirmPasswordMismatch() {
        // Test Confirm Password mismatch
        assertFalse(InputValidator.ConfirmPassword("Password12", "DifferentPassword"));
        assertFalse(InputValidator.ConfirmPassword("Valid1234", "valid1234"));
        assertFalse(InputValidator.ConfirmPassword("123456b", "123456B"));
        assertFalse(InputValidator.ConfirmPassword("short", "shorter"));
    }

}
 