package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.dao.ParticipantDao;
import by.epam.webproject.model.dao.impl.ParticipantsDaoImpl;
import by.epam.webproject.model.service.ParticipantService;
import by.epam.webproject.model.service.impl.ParticipantsServiceImpl;
import by.epam.webproject.model.service.impl.RaceServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class DeleteParticipantCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private final ParticipantService participantService = new ParticipantsServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String participantIdString = request.getParameter(RequestParameter.PARTICIPANT_ID);
        try {
            if (participantService.deleteParticipant(participantIdString)) {
                page = PagePath.ADMIN_PARTICIPANTS;
                request.setAttribute(RequestAttribute.PARTICIPANT_DELETED,"Participant deleted successfully");
            } else {
                page = PagePath.ADMIN_PARTICIPANTS;
                request.setAttribute(RequestAttribute.PARTICIPANT_DELETED,"Participant isn't deleted");
            }
        } catch (ServiceException e) {
            logger.error("Error while removing row: " + participantIdString, e);
            request.setAttribute(RequestAttribute.PARTICIPANT_DELETED,"Error while deleting participant");
            page = PagePath.ADMIN_PARTICIPANTS;
        }
        return page;
    }
}
