package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * The {@code ToSignInPageCommand} class represents to sign in page command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class ToSignInPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.SIGN_IN;
    }
}
