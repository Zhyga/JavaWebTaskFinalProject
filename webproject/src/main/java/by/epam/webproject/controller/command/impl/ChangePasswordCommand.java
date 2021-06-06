package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.User;
import by.epam.webproject.model.service.UserService;
import by.epam.webproject.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * The {@code ChangePasswordCommand} class represents change password command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class ChangePasswordCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private final UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.CHANGE_PASSWORD;
        HttpSession session = request.getSession();
        String oldPassword = request.getParameter(RequestParameter.OLD_PASSWORD);
        String newPassword = request.getParameter(RequestParameter.NEW_PASSWORD);
        String login = String.valueOf(session.getAttribute(SessionAttribute.LOGIN));
        if (oldPassword.equals(newPassword)) {
            request.setAttribute(RequestAttribute.CHANGE_PASSWORD_ERROR, "The new password cannot be the same as the old one");
        } else {
            try {
                Optional<User> userOptional = userService.authorizeUser(login, oldPassword);
                if (userOptional.isEmpty()) {
                    request.setAttribute(RequestAttribute.CHANGE_PASSWORD_ERROR, "Incorrect old password");
                } else {
                    if (userService.changePassword(newPassword, login)) {
                        request.setAttribute(RequestAttribute.CHANGE_PASSWORD_ERROR, "Password successfully changed");
                    } else {
                        request.setAttribute(RequestAttribute.CHANGE_PASSWORD_ERROR, "Cant change password");
                    }
                }
            } catch (ServiceException e) {
                logger.error("Error while change user password", e);
                page = PagePath.HOME;
            }
        }
        return page;
    }
}
