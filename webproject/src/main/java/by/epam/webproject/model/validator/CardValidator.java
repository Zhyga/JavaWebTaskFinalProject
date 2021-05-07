package by.epam.webproject.model.validator;

public class CardValidator {
    private static final String CAR_NUMBER_REGEX = "^\\d{16}$";
    private static final String AMOUNT_REGEX = "^[1-9][0-9]{1,6}([.,][0-9]{1,2})?$$";

    public static boolean isCardNumberCorrect(String cardNumber) {
        return isStringCorrect(cardNumber, CAR_NUMBER_REGEX);
    }

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
