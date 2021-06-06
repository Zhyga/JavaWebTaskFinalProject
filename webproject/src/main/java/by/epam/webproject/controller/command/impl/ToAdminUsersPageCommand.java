package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.BetInfo;
import by.epam.webproject.model.entity.User;
import by.epam.webproject.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * The {@code ToAdminUsersPageCommand} class represents to admin users page command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class ToAdminUsersPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private final UserServiceImpl userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            List<User> users = userService.findAllUsers();
            session.setAttribute(SessionAttribute.USERS_LIST, users);
        } catch (ServiceException e) {
            logger.error("Error while finding all users",e);
        }
        return PagePath.ADMIN_USERS;
    }
}
