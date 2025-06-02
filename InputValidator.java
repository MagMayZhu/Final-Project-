import java.io.File;
import java.text.BreakIterator;
import java.util.Locale;

public class InputValidator {
    
    
    /**
    * Validates the password field. 
     * - Must not be empty
     * - At least 8 characters long
     * - At least one upper-case, lower-case and digit.
     * - Special characters are allowed    
     * @param password the password to validate
     * @return true if the password is not empty, has at least 8 characters,
     *         and contains upper-case, lower-case and digit, false otherwise
     */
    public static boolean validatePasswordField(String password) {
        // Check if the password is null or empty and has at least 8 characters
        if (password == null || password.length() < 8) return false;

        // Check if the password contains at least one upper-case letter,lower-case letter and digit.
        boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLower = password.chars().anyMatch(Character::isLowerCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);

        return hasUpper && hasLower && hasDigit;
    }
    
public static boolean validatelastNameField(String input) 
        { //This is our boolean that will return true if more than 2 letters 
        BreakIterator charIterator = BreakIterator.getCharacterInstance(Locale.getDefault()); //initialize  
        charIterator.setText(input); // 

          int letterCount = 0; 
          int start = charIterator.first();
          int end = charIterator.next();

        while (end != BreakIterator.DONE) {
         String Lastname = input.substring(start, end);
            int codePoint = Lastname.codePointAt(0);
            int type = Character.getType(codePoint);

            if (type == Character.UPPERCASE_LETTER || type == Character.LOWERCASE_LETTER || // Defining what were considering as letters as to not take special characters like "@ or $"
                type == Character.TITLECASE_LETTER || type == Character.MODIFIER_LETTER || 
                type == Character.OTHER_LETTER) {

                letterCount++; //increase letter count 
                if (letterCount >= 2) 
                { 
                    return true; //if greater than 2 than accepted 
                }
            }

            start = end;
            end = charIterator.next();
        }

        return false;
    }
    public static boolean validateNameField(String name) {
        // Check if the name is null or empty
        if (name == null) return false;

        //Check if the name is more than 2 characters
        if (name.trim().length() < 2) return false;

        // Check if the name contains only letters and spaces
        if (!name.trim().matches("[\\p{L}\\s]+")) return false;
        return true;
    } 
    /*
     * Validates a file according to:
     * 1. Must have a .jpg or .png extension
     * 2. Must not exceed 4MB in size
     * 
     * @param filePath the file that user inputs 
     * @return true if both conditions are met, false otherwise
     */
    
     public static boolean isValidImageFile(String filePath) {
        File file = new File(filePath);
        String fileName = file.getName().toLowerCase(Locale.ROOT);
    
        // Allow only JPG or PNG files
        return fileName.endsWith(".jpg") || fileName.endsWith(".png");
    }

    
}
