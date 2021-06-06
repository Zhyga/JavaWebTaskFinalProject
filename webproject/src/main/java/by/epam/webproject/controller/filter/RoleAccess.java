package by.epam.webproject.controller.filter;

import by.epam.webproject.controller.command.Command;
import by.epam.webproject.controller.command.CommandType;
import by.epam.webproject.controller.command.impl.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static by.epam.webproject.controller.command.CommandType.*;

/**
 * The {@code RoleAccess} enum represents role access
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public enum RoleAccess {
    GUEST(Stream.of(
            SIGN_IN,
            SIGN_UP,
            TO_SIGN_IN,
            TO_SIGN_UP,
            TO_MAIN,
            SWITCH_LOCALE
    ).map(CommandType::getCommand).collect(Collectors.toSet())),
    USER(Stream.of(
            TO_MAIN,
            SWITCH_LOCALE,
            LOG_OUT,
            TO_BET_PAGE,
            TO_PROFILE,
            TO_ADD_BALANCE,
            PLACE_BET,
            DEPOSIT,
            WITHDRAW,
            CONFIRM_EMAIL,
            TO_CHANGE_PASSWORD,
            CHANGE_PASSWORD
    ).map(CommandType::getCommand).collect(Collectors.toSet())),
    BOOKMAKER(Stream.of(
            TO_MAIN,
            TO_BOOKMAKER_RACES,
            CALCULATE_WINNER,
            SWITCH_LOCALE,
            PLACE_BET,
            LOG_OUT,
            TO_BET_PAGE,
            TO_CHANGE_PASSWORD,
            CHANGE_PASSWORD,
            TO_PROFILE,
            TO_ADD_RACE,
            TO_ADD_BALANCE,
            DEPOSIT,
            WITHDRAW,
            TO_ADMIN_RACES,
            TO_ADMIN_USERS,
            DELETE_RACE,
            CREATE_RACE
    ).map(CommandType::getCommand).collect(Collectors.toSet())),
    ADMIN(Stream.of(
            PLACE_BET,
            TO_MAIN,
            SWITCH_LOCALE,
            TO_ADD_BALANCE,
            DEPOSIT,
            WITHDRAW,
            LOG_OUT,
            TO_BET_PAGE,
            TO_PROFILE,
            TO_ADD_RACE,
            TO_ADMIN_RACES,
            TO_ADMIN_USERS,
            TO_CHANGE_PASSWORD,
            CHANGE_PASSWORD,
            DELETE_RACE,
            CREATE_RACE,
            DEPOSIT,
            CHANGE_ROLE
    ).map(CommandType::getCommand).collect(Collectors.toSet()));

    private final Set<Command> commands;

    RoleAccess(Set<Command> commands) {
        this.commands = commands;
    }

    /**
     * Gets commands
     * @return the commands
     */
    public Set<Command> getCommands() {
        return Collections.unmodifiableSet(commands);
    }
}
