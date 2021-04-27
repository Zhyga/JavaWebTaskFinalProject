package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Race;
import by.epam.webproject.model.service.RaceService;
import by.epam.webproject.model.service.impl.RaceServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class FindAllRacesCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final RaceService raceService = new RaceServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        List<Race> races;
        String page;
        try {
            races = raceService.findAllRaces();
            HttpSession session = request.getSession();
            session.setAttribute(SessionAttribute.RACE_LIST, races);
            page = PagePath.MAIN;
        } catch (ServiceException e) {
            logger.error("Error occurred while finding all races", e);
            page = PagePath.HOME;
        }
        return page;
    }
}
