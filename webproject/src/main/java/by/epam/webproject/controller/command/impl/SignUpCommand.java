package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.service.UserService;
import by.epam.webproject.model.service.impl.UserServiceImpl;
import by.epam.webproject.util.EmailSender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The {@code SignUpCommand} class represents sign up command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class SignUpCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(RequestParameter.LOGIN_PARAMETER);
        String email = request.getParameter(RequestParameter.EMAIL_PARAMETER);
        String password = request.getParameter(RequestParameter.PASSWORD_PARAMETER);
        String confirmPassword = request.getParameter(RequestParameter.CONFIRM_PASSWORD_PARAMETER);
        if(!password.equals(confirmPassword)){
            page = PagePath.SIGN_UP;
            request.setAttribute(RequestAttribute.SIGN_IN_ERROR, "Passwords do not match!");
        }
        else {
            try {
                boolean isUserCreated = userService.createUser(email, login, password);
                if (isUserCreated) {
                    EmailSender.sendMessage(email, login, request.getRequestURL().toString());
                    page = PagePath.MAIN;
                } else {
                    page = PagePath.SIGN_UP;
                    request.setAttribute(RequestAttribute.SIGN_IN_ERROR, "Error occurred while reg user");
                }
            } catch (ServiceException e) {
                logger.error("Error occurred while sign up user", e);
                page = PagePath.HOME;
            }
        }
        return page;
    }
}
