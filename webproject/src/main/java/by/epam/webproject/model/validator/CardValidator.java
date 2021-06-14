package by.epam.webproject.model.validator;

/**
 * The {@code CardValidator} class represents card validator
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class CardValidator {
    private static final String CAR_NUMBER_REGEX = "^\\d{16}$";
    private static final String AMOUNT_REGEX = "^[1-9][0-9]{1,6}(\\.[0-9]{1,2})?$";

    /**
     * Checks card number
     *
     * @param cardNumber the card number
     * @return the boolean
     */
    public static boolean isCardNumberCorrect(String cardNumber) {
        return isStringCorrect(cardNumber, CAR_NUMBER_REGEX);
    }

    /**
     * Checks amount
     *
     * @param amount the amount
     * @return the boolean
     */
    public static boolean isAmountCorrect(String amount) {
        return isStringCorrect(amount, AMOUNT_REGEX);
    }

    private static boolean isStringCorrect(String line, String regex) {
        boolean isStringCorrect = false;
        if (line != null) {
            isStringCorrect = line.matches(regex);
        }
        return isStringCorrect;
    }
}
