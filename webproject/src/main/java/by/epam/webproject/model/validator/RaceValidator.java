package by.epam.webproject.model.validator;

import by.epam.webproject.model.dao.ColumnName;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The {@code RaceValidator} class represents race validator
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class RaceValidator {
    private static final String ID_REGEX = "^[1-9]\\d{0,9}$";
    private static final String TITLE_REGEX = "^[A-Za-z]*|[A-Za-z]*\\s[A-Za-z]{1,45}$";
    private static final String ROUNDS_REGEX = "^[1-9]{1,2}$";
    private static final String DETAILS_REGEX = "^[A-Za-z0-9\\s\\|\\.\\,]{1,100}$";

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
     * Checks title
     *
     * @param title the title
     * @return the boolean
     */
    public static boolean isTitleCorrect(String title) {
        return isStringCorrect(title, TITLE_REGEX);
    }

    /**
     * Checks rounds
     *
     * @param rounds the rounds
     * @return the boolean
     */
    public static boolean isRoundsCorrect(String rounds) {
        return isStringCorrect(rounds, ROUNDS_REGEX);
    }

    /**
     * Checks details
     *
     * @param details the details
     * @return the boolean
     */
    public static boolean isDetailsCorrect(String details) {
        return isStringCorrect(details, DETAILS_REGEX);
    }

    /**
     * Checks race date
     *
     * @param date the date
     * @param time the time
     * @return the boolean
     */
    public static boolean isRaceDateTimeCorrect(String date,String time) {
        String race_data_string = date + " " + time;
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime race_date = LocalDateTime.parse(race_data_string, inputFormatter);
        LocalDateTime currentTime = LocalDateTime.now();
        return race_date.isAfter(currentTime);
    }

    private static boolean isStringCorrect(String line, String regex) {
        boolean isStringCorrect = false;
        if (line != null) {
            isStringCorrect = line.matches(regex);
        }
        return isStringCorrect;
    }
}
