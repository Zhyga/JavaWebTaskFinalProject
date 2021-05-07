package by.epam.webproject.model.validator;

import by.epam.webproject.model.dao.ColumnName;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RaceValidator {
    private static final String ID_REGEX = "^[1-9]\\d{0,9}$";
    private static final String TITLE_REGEX = "^[A-Za-z]*\\s|[A-Za-z]*\\s[A-Za-z]*$";
    private static final String ROUNDS_REGEX = "^[1-9]{1,2}$";
    private static final String DETAILS_REGEX = "^[A-Za-z\\s\\|\\.\\,]*$";

    public static boolean isIdCorrect(String id) {
        return isStringCorrect(id, ID_REGEX);
    }

    public static boolean isTitleCorrect(String title) {
        return isStringCorrect(title, TITLE_REGEX);
    }

    public static boolean isRoundsCorrect(String rounds) {
        return isStringCorrect(rounds, ROUNDS_REGEX);
    }

    public static boolean isDetailsCorrect(String details) {
        return isStringCorrect(details, DETAILS_REGEX);
    }

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
