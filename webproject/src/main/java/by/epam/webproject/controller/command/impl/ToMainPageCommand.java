package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.UserRole;
import by.epam.webproject.model.service.impl.RaceServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ToMainPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final String LOCALE = "en_US";
    private final RaceServiceImpl raceService = new RaceServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute(SessionAttribute.LOCALE) == null) {
            session.setAttribute(SessionAttribute.LOCALE, LOCALE);
        }
        if (session.getAttribute(SessionAttribute.ROLE) == null) {
            session.setAttribute(SessionAttribute.ROLE, UserRole.GUEST.getRoleName());
        }
        try {
            session.setAttribute(SessionAttribute.RACE_LIST, raceService.findAllRaces());
        } catch (ServiceException e) {
            logger.error("Error while setting up race list", e);
        }
        return PagePath.MAIN;
    }
}
