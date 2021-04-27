package by.epam.webproject.model.dao;

public final class ColumnName {
    /*User table*/
    public static final String USER_ID = "user_id";
    public static final String EMAIL = "email";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String AMOUNT_OF_BETS = "amount_of_bets";
    public static final String IS_APPROVED = "is_approved";

    /*Role table*/
    public static final String ROLE_ID = "role_id";
    public static final String ROLE_NAME = "role_name";

    /*Wallet table*/
    public static final String WALLET_ID = "wallet_id";
    public static final String BALANCE = "balance";
    
    /*Participants table*/
    public static final String PARTICIPANT_ID = "participant_id";
    public static final String HORSE = "horse";
    public static final String WEIGHT = "weight";
    public static final String JOCKEY = "jockey";

    /*Race data table*/
    public static final String RACE_DATA_ID = "race_data_id";
    public static final String DATE = "date";

    /*Race table*/
    public static final String RACE_ID = "race_id";
    public static final String TITLE = "title";
    public static final String ROUNDS = "rounds";
    public static final String DETAILS = "details";

    /*Bet table*/
    public static final String BET_ID = "bet_id";
    public static final String TYPE_OF_BET = "type_of_bet";
    public static final String FIRST_MULTIPLIER = "first_multiplier";
    public static final String SECOND_MULTIPLIER = "second_multiplier";

    /*Bet info table*/
    public static final String BET_INFO_ID = "bet_info_id";
    public static final String PRIZE = "prize";
    public static final String BET_SIZE = "bet_amount";
    public static final String MULTIPLIER = "multiplier";
    public static final String BET_STATUS = "bet_status";
    public static final String BET_DETAILS = "bet_details";

    private ColumnName(){}

}
