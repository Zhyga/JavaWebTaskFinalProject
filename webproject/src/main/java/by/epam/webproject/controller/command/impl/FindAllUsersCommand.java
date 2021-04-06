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
import java.util.List;

public class FindAllUsersCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        List<User> users;
        String page = null;
        try {
            users = userService.findAllUsers();
            request.setAttribute("lst", users);
            page = PagePath.MAIN;
        } catch (ServiceException e) {
            logger.error("Error occurred while finding all users", e);
            page = PagePath.HOME;
        }
        return page;
    }
}
