package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The {@code ChangeRoleCommand} class represents change role command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class ChangeRoleCommand implements Command {
    private static final Logger logger = LogManager.getLogger();


    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
