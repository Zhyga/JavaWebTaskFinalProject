package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.User;
import by.epam.webproject.model.service.UserService;
import by.epam.webproject.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final UserService userService = new UserServiceImpl();
    private static final String LOGIN_PARAMETER = "login";
    private static final String EMAIL_PARAMETER = "email";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String ATTRIBUTE_USER = "user";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(LOGIN_PARAMETER);
        String email = request.getParameter(EMAIL_PARAMETER);
        String password = request.getParameter(PASSWORD_PARAMETER);
        try {
            boolean isUserCreated = userService.createUser(email, login, password);
            if (isUserCreated) {
                request.setAttribute(ATTRIBUTE_USER, login);
                page = PagePath.PROFILE;
            }
            else{
                page = PagePath.HOME;
                request.setAttribute("errorLoginPasMessage", "Error occurred while reg user");
            }
        } catch (ServiceException e) {
            logger.error("Error occurred while sign up user", e);
            page = PagePath.HOME;
        }
        return page;
    }
}
