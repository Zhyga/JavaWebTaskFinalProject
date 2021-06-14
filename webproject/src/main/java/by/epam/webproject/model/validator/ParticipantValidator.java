package by.epam.webproject.model.validator;

public class ParticipantValidator {
    private static final String ID_REGEX = "^[1-9]\\d{0,9}$";
    private static final String JOCKEY_REGEX = "^[A-Za-z]{3,45}|[A-Za-z]*\\s[A-Za-z]{3,45}$";
    private static final String HORSE_REGEX = "^[A-Za-z]{3,45}$";
    private static final String WEIGHT_REGEX = "^[1-9][0-9]{1,2}$";

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
     * Checks jockey
     *
     * @param jockey the jockey
     * @return the boolean
     */
    public static boolean isJockeyCorrect(String jockey) {
        return isStringCorrect(jockey, JOCKEY_REGEX);
    }

    /**
     * Checks horse
     *
     * @param horse the horse
     * @return the boolean
     */
    public static boolean isHorseCorrect(String horse) {
        return isStringCorrect(horse, HORSE_REGEX);
    }

    /**
     * Checks weight
     *
     * @param weight the weight
     * @return the boolean
     */
    public static boolean isWeightCorrect(String weight) {
        return isStringCorrect(weight, WEIGHT_REGEX);
    }


    private static boolean isStringCorrect(String line, String regex) {
        boolean isStringCorrect = false;
        if (line != null) {
            isStringCorrect = line.matches(regex);
        }
        return isStringCorrect;
    }
}
