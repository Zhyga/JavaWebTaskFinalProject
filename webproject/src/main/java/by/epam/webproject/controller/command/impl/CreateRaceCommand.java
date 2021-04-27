package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.service.impl.RaceServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CreateRaceCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private final RaceServiceImpl raceService = new RaceServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String title = request.getParameter("raceTitle");
        String rounds = request.getParameter("raceRounds");
        String details = request.getParameter("raceDetails");
        String date = request.getParameter("raceDate");
        String time = request.getParameter("raceTime");
        try {
            if(raceService.createRace(title,rounds,details,date,time)){
                page = PagePath.HOME;
            }
            else{
                page = PagePath.ADD_RACES;
                request.setAttribute(RequestAttribute.RACE_CREATE_ERROR,"Can't create race with such parameters");
            }
        } catch (ServiceException e) {
            logger.error("Error while creating new race", e);
            request.setAttribute(RequestAttribute.RACE_CREATE_ERROR,"Error while creating race");
            page = PagePath.ADD_RACES;
        }
        return page;
    }
}
