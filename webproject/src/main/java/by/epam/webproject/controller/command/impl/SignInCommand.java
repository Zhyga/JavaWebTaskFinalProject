package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.model.entity.User;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.service.UserService;
import by.epam.webproject.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class SignInCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final UserService userService = new UserServiceImpl();
    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String ATTRIBUTE_USER = "user";
    private static final String ATTRIBUTE_ERROR = "errorLoginPasMessage";
    private static final String ATTRIBUTE_BOOL = "boolError";

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(LOGIN_PARAMETER);
        String password = request.getParameter(PASSWORD_PARAMETER);
        try {
            Optional<User> user = userService.authorizeUser(login, password);
            if (user.isPresent()) {
                request.setAttribute(ATTRIBUTE_USER, login);
                page = PagePath.PROFILE;
            } else {
                page = PagePath.SIGN_IN;
                request.setAttribute(ATTRIBUTE_ERROR, "Incorrect login or password");
                request.setAttribute(ATTRIBUTE_BOOL, true);
            }
        } catch (ServiceException e) {
            logger.error("Error occurred while sign in user", e);
            page = PagePath.HOME;
        }

        return page;
    }
}
