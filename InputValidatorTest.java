import org.junit.Test;
import static org.junit.Assert.*;

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
        assertTrue(InputValidator.validateNameField("John"));
        assertFalse (InputValidator.validateNameField(""));
        assertFalse (InputValidator.validateNameField(" "));
    }

    @Test
    public void testNameMinLength() {
        assertFalse(InputValidator.validateNameField("A"));
        assertTrue(InputValidator.validateNameField("Al"));
    }

    @Test
    public void testNameWithSpaces() {
        assertTrue(InputValidator.validateNameField("Nailia Narynbek"));
    }

    @Test
    public void testNameWithDiacritics() {
        assertTrue(InputValidator.validateNameField("Zoë"));
        assertTrue(InputValidator.validateNameField("Björk"));
    }

    @Test
    public void testNameWithInvalidCharacters() {
        assertFalse(InputValidator.validateNameField("John123"));
        assertFalse(InputValidator.validateNameField("!@#"));
        assertFalse(InputValidator.validateNameField("Anna*"));
    }

    @Test
    public void testNameNull() {
        assertFalse(InputValidator.validateNameField(null));
    }
}
 