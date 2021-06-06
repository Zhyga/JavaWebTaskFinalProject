package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The {@code SwitchLocaleCommand} class represents switch locale command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class SwitchLocaleCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String locale = request.getParameter(RequestParameter.NEW_LOCALE);
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.LOCALE,locale);
        return (String) session.getAttribute(SessionAttribute.CURRENT_PAGE);
    }
}
