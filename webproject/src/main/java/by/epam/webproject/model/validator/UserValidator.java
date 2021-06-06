package by.epam.webproject.model.validator;

/**
 * The {@code UserValidator} class represents user validator
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class UserValidator {
    private static final String ID_REGEX = "^[1-9]\\d{0,9}$";
    private static final String LOGIN_REGEX = "^(?=.*[A-Za-z0-9]$)[A-Za-z][\\w.-]{0,19}$";
    private static final String EMAIL_REGEX = "^[\\w\\.]{3,13}@(gmail|yandex|tut|mail)\\.(com|ru|by)$";
    private static final String PASSWORD_REGEX = "^[\\w]{3,20}$";

    /**
     * Checks id
     *
     * @param id the id
     * @return the boolean
     */
    public static boolean isIdCorrect(String id) {
        return isStringCorrect(id, ID_REGEX);
    }

    /**
     * Checks login
     *
     * @param login the login
     * @return the boolean
     */
    public static boolean isLoginCorrect(String login) {
        return isStringCorrect(login, LOGIN_REGEX);
    }

    /**
     * Checks email
     *
     * @param email the email
     * @return the boolean
     */
    public static boolean isEmailCorrect(String email) {
        return isStringCorrect(email, EMAIL_REGEX);
    }

    /**
     * Checks password
     *
     * @param password the password
     * @return the boolean
     */
    public static boolean isPasswordCorrect(String password) {
        return isStringCorrect(password, PASSWORD_REGEX);
    }

    private static boolean isStringCorrect(String line, String regex) {
        boolean isStringCorrect = false;
        if (line != null) {
            isStringCorrect = line.matches(regex);
        }
        return isStringCorrect;
    }
}
