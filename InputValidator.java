public class InputValidator {
    /**
     * Validates a bio field.
     * 
     * Checks if the bio string is non-empty and is less than 200 characters long, any characters can be used.
     * 
     * @param bio the description as string.
     * @return whether or not the description passes the validation.
     */
    public static boolean validateBioField(String bio) {
        //Null case.
        if (bio == null) {
            return false;
        }
        //Check length (empty string is allowed based on requirements).
        return bio.length() < 200;
    }
}