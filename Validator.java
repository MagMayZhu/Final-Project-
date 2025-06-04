//import java.util.regex.Pattern;

public class Validator {
    
     /**
     * Validates an email adress
     * 
     * @param email The email string to validate
     * @return true if the email is valid (not empty and matches standard email format)
     * , other false
     * 
     */
   public static boolean validEmail (String email) 
    {
        //Chech for null or empty input
        if (email == null || email.trim().isEmpty())
        { 
            return false;
        }
        // Validate against email regex pattern
        return email.matches("^[A-Za-z0-9+_.-]+@kzoo+\\.edu");
    }    

    /**
     * Validates a password
     * 
     * @param password The password string to validate
     * @return true if the password is valid (not empty and at least 8 characters long)
     * , other false
     */
   public static boolean validPassword(String password)
    {
        // Check for null or empty input
        if (password == null || password.trim().isEmpty())
        {
            return false;
        }
        // Validate password length, letter, and number
        return password.matches("^(?=.*[a-zA-Z])(?=.*[0-9]).{8,}$");
    }

     /**
     * Validates a password
     * 
     * @param password The password string to validate
     * @param confirmPassword The confirmation password string to validate
     * @return true if the password matches the confirmation password
     * , other false
     */

    public static boolean ConfirmPassword(String password, String confirmPassword) {
        // Check if both passwords are not null and match
        if (password == null || confirmPassword == null) {
            return false;
        }
        return password.equals(confirmPassword);
    }
}

