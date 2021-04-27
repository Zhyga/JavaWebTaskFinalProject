package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.model.entity.BetInfo;
import by.epam.webproject.model.entity.User;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.service.UserService;
import by.epam.webproject.model.service.impl.BetInfoServiceImpl;
import by.epam.webproject.model.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public class SignInCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(RequestParameter.LOGIN_PARAMETER);
        String password = request.getParameter(RequestParameter.PASSWORD_PARAMETER);
        try {
            Optional<User> user = userService.authorizeUser(login, password);
            if (user.isPresent()) {
                HttpSession session = request.getSession();
                session.setAttribute(SessionAttribute.LOGIN, login);
                session.setAttribute(SessionAttribute.BALANCE, user.get().getWallet().getBalance());
                session.setAttribute(SessionAttribute.ROLE,user.get().getRole().getRoleName());
                page = PagePath.MAIN;
            } else {
                page = PagePath.SIGN_IN;
                request.setAttribute(RequestAttribute.SIGN_IN_ERROR, "Incorrect login or password");
            }
        } catch (ServiceException e) {
            logger.error("Error occurred while sign in user", e);
            page = PagePath.HOME;
        }
        return page;
    }
}
