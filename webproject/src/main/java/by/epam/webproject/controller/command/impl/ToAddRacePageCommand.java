package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Participant;
import by.epam.webproject.model.service.ParticipantService;
import by.epam.webproject.model.service.impl.ParticipantsServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * The {@code ToAddRacePageCommand} class represents to add page command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class ToAddRacePageCommand implements Command {
    private final static Logger logger = LogManager.getLogger();
    private final ParticipantService participantService = new ParticipantsServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        List<Participant> participants;
        try {
            participants = participantService.findAllParticipants();
            request.setAttribute(RequestAttribute.RACE_PARTICIPANTS,participants);
        } catch (ServiceException e) {
            logger.error("Error while loading participants", e);
        }
        return PagePath.ADD_RACES;
    }
}
