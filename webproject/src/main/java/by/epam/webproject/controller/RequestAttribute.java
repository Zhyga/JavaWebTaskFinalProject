package by.epam.webproject.controller;

/**
 * The {@code RequestAttribute} class represents request attribute
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class RequestAttribute {
    public static final String SIGN_IN_ERROR = "errorLoginPasMessage";
    public static final String CAR_NUMBER_ERROR = "errorIncorrectCarNumber";
    public static final String CHANGE_PASSWORD_ERROR = "errorChangePasMessage";
    public static final String ZERO_BETS = "emptyBetInfoList";
    public static final String RACE_DELETED = "raceDeleted";
    public static final String RACE_CREATE_ERROR = "errorRaceCreated";
    public static final String RACE_TITLE = "raceTitle";
    public static final String RACE_PARTICIPANTS = "raceParticipants";
    public static final String ADMIN_USERS_ERROR = "errorAdminUser";
    public static final String ADMIN_PARTICIPANTS_ERROR = "errorParticipantCreated";
    public static final String JOCKEY = "jockey";
    public static final String HORSE = "horse";
    public static final String WEIGHT = "weight";

    private RequestAttribute(){}
}
