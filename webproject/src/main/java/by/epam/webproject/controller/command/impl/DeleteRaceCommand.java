package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.service.impl.RaceServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * The {@code DeleteRaceCommand} class represents delete race command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class DeleteRaceCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private final RaceServiceImpl raceService = new RaceServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String raceIdString = request.getParameter("raceId");
        int raceId = Integer.parseInt(raceIdString);
        try {
            if (raceService.deleteRace(raceId)) {
                page = PagePath.HOME;
                request.setAttribute(RequestAttribute.RACE_DELETED,"Race deleted successfully");
            } else {
                page = PagePath.ADMIN_RACES;
                request.setAttribute(RequestAttribute.RACE_DELETED,"Race isn't deleted");
            }
        } catch (ServiceException e) {
            logger.error("Error while removing row: " + raceId, e);
            request.setAttribute(RequestAttribute.RACE_DELETED,"Error while deleting race");
            page = PagePath.ADMIN_RACES;
        }
        return page;
    }
}
