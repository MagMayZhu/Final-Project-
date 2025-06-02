import org.junit.Test;
import static org.junit.Assert.*;

public class test {
    @Test
    public void testValidEmail() {
        // Test valid email
        assertTrue(Validator.validEmail("edith.aviles23@kzoo.edu"));
        assertTrue(Validator.validEmail("maggie.zhu24@kzoo.edu"));
        assertTrue(Validator.validEmail("camila.benavidez21@kzoo.edu"));
        assertTrue(Validator.validEmail("paul.dinsmore22@kzoo.edu"));
}
@Test
    public void testInvalidEmail() {
        // Test invalid email
        assertFalse(Validator.validEmail("schooll@hotmail.com"));
        assertFalse(Validator.validEmail("avilesedith2005@gmail.com"));
        assertFalse(Validator.validEmail("goodness@att.net"));
        assertFalse(Validator.validEmail("edith.aviles23@go.edu"));
    }
    @Test
    public void testValidPass() {
        assertTrue(Validator.validPassword("Password12"));
        assertTrue(Validator.validPassword("Valid1234"));
       assertTrue(Validator.validPassword("goodness123"));
        assertTrue(Validator.validPassword("StrongPass1"));;
    }
    @Test
    public void testInvalidPass() {
        // Test invalid passwords
        assertFalse(Validator.validPassword("short"));
        assertFalse(Validator.validPassword("NoNumber"));
        assertFalse(Validator.validPassword("123456b"));
        assertFalse(Validator.validPassword(null));
    }

    @Test
    public void testConfirmPassword() {
        // Test Confirm Password
        assertTrue(Validator.ConfirmPassword("Password12", "Password12"));
        assertTrue(Validator.ConfirmPassword("Valid1234", "Valid1234"));
        assertTrue(Validator.ConfirmPassword("123456b", "123456b"));
        assertTrue(Validator.ConfirmPassword("StrongPass1", "StrongPass1"));
    }

    @Test
    public void testConfirmPasswordMismatch() {
        // Test Confirm Password mismatch
        assertFalse(Validator.ConfirmPassword("Password12", "DifferentPassword"));
        assertFalse(Validator.ConfirmPassword("Valid1234", "valid1234"));
        assertFalse(Validator.ConfirmPassword("123456b", "123456B"));
        assertFalse(Validator.ConfirmPassword("short", "shorter"));
    }
}