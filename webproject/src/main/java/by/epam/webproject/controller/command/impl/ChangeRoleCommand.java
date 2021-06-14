package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.service.UserService;
import by.epam.webproject.model.service.impl.UserServiceImpl;
import by.epam.webproject.model.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The {@code ChangeRoleCommand} class represents change role command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class ChangeRoleCommand implements Command {
    private final UserService userService = new UserServiceImpl();
    private static final Logger logger = LogManager.getLogger();


    @Override
    public String execute(HttpServletRequest request) {
        String userId = request.getParameter(RequestParameter.USER_ID);
        String roleName = request.getParameter(RequestParameter.USER_ROLE);
        String userBalance = request.getParameter(RequestParameter.USER_BALANCE);
        try {
            userService.update(userId,roleName,userBalance);
            request.setAttribute(RequestAttribute.ADMIN_USERS_ERROR,"Role or/and balance is changed");
        } catch (ServiceException e) {
            logger.error("Error while changing users role or/and balance", e);
            request.setAttribute(RequestAttribute.ADMIN_USERS_ERROR,"Role or/and balance is not changed");
        }
        return PagePath.ADMIN_USERS;
    }
}
