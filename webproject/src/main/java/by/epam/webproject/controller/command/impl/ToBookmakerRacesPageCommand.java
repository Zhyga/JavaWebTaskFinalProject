package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * The {@code ToBookmakerRacesPageCommand} class represents to bookmaker races page command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class ToBookmakerRacesPageCommand implements Command
{
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.BOOKMAKER_RACES;
    }
}
