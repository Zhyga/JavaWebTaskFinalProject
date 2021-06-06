package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * The {@code ToAdminRacesPageCommand} class represents to admin page command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class ToAdminRacesPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.ADMIN_RACES;
    }
}
