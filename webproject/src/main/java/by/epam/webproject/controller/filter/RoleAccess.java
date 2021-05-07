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

public enum RoleAccess {
    GUEST(Stream.of(
            FIND_ALL_RACES,
            SIGN_IN,
            SIGN_UP,
            TO_SIGN_IN,
            TO_SIGN_UP,
            TO_MAIN,
            SWITCH_LOCALE
    ).map(CommandType::getCommand).collect(Collectors.toSet())),
    USER(Stream.of(
            FIND_ALL_RACES,
            TO_MAIN,
            SWITCH_LOCALE,
            LOG_OUT,
            TO_BET_PAGE,
            TO_PROFILE,
            TO_ADD_BALANCE,
            DEPOSIT,
            WITHDRAW,
            CONFIRM_EMAIL
    ).map(CommandType::getCommand).collect(Collectors.toSet())),
    BOOKMAKER(Stream.of(
            FIND_ALL_RACES,
            TO_MAIN,
            SWITCH_LOCALE,
            LOG_OUT,
            TO_BET_PAGE,
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
            FIND_ALL_RACES,
            FIND_ALL_USERS,
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
            DELETE_RACE,
            CREATE_RACE,
            DEPOSIT,
            CHANGE_ROLE
    ).map(CommandType::getCommand).collect(Collectors.toSet()));

    private final Set<Command> commands;

    RoleAccess(Set<Command> commands) {
        this.commands = commands;
    }

    public Set<Command> getCommands() {
        return Collections.unmodifiableSet(commands);
    }
}
