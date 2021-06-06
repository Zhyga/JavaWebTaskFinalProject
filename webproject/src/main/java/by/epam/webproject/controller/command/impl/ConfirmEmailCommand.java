package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.service.UserService;
import by.epam.webproject.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The {@code ConfirmEmailCommand} class represents confirm email command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class ConfirmEmailCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(RequestParameter.LOGIN_PARAMETER);
        try {
            if (userService.confirmEmail(login)) {
                page = PagePath.MAIN;
            } else {
                request.setAttribute(RequestAttribute.SIGN_IN_ERROR, "Email is not confirmed");
                page = PagePath.SIGN_IN;
            }
        } catch (ServiceException e) {
            logger.error("Error while confirming email", e);
            page = PagePath.SIGN_IN;
        }
        return page;
    }
}
