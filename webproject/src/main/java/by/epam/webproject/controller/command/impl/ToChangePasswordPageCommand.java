package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * The {@code ToChangePasswordPageCommand} class represents to change password page command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class ToChangePasswordPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.CHANGE_PASSWORD;
    }
}
