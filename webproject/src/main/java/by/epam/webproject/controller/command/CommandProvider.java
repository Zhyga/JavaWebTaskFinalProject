package by.epam.webproject.controller.command;

import by.epam.webproject.controller.command.impl.UnknownCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The {@code CommandProvider} class represents command provider
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class CommandProvider {
    private static final Logger logger = LogManager.getLogger();

    private CommandProvider() {
    }

    /**
     * Define command
     *
     * @param commandName the command name
     * @return the defined command
     */
    public static Command defineCommand(String commandName) {
        Command currentCommand;
        if (commandName != null) {
            try {
                CommandType commandType = CommandType.valueOf(commandName.toUpperCase());
                currentCommand = commandType.getCommand();
            } catch (IllegalArgumentException e) {
                logger.error("No such command found {}", commandName, e);
                currentCommand = new UnknownCommand();
            }
        } else {
            currentCommand = new UnknownCommand();
        }
        return currentCommand;
    }
}
