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
import java.util.ArrayList;
import java.util.List;

public class FindByEmailCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        List<User> users = new ArrayList<>();
        String page;
        String email = request.getParameter("user_mail");
        try {
            users.add(userService.findUserByEmail(email).get());
            request.setAttribute("lst", users);
            page = PagePath.MAIN;
        } catch (ServiceException e) {
            logger.error("Error occurred while finding user by email {}", email, e);
            page = PagePath.HOME;
        }
        return page;
    }
}
