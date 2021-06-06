package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Participant;
import by.epam.webproject.model.service.impl.RaceServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code CreateRaceCommand} class represents create race command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class CreateRaceCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private final RaceServiceImpl raceService = new RaceServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String title = request.getParameter(RequestParameter.RACE_TITLE);
        String rounds = request.getParameter(RequestParameter.RACE_ROUNDS);
        String details = request.getParameter(RequestParameter.RACE_DETAILS);
        String date = request.getParameter(RequestParameter.RACE_DATE);
        String time = request.getParameter(RequestParameter.RACE_TIME);
        String[] participants = request.getParameterValues(RequestParameter.RACE_PARTICIPANTS);
        try {
            if(raceService.createRace(title,rounds,details,date,time,participants)){
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
