import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import src.main.java.InputValidator;

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

}
 