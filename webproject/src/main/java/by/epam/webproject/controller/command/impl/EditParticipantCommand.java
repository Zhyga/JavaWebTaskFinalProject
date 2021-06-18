package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.service.ParticipantService;
import by.epam.webproject.model.service.impl.ParticipantsServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class EditParticipantCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final ParticipantService participantService = new ParticipantsServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String participantId = request.getParameter(RequestParameter.PARTICIPANT_ID);
        String jockey = request.getParameter(RequestParameter.JOCKEY);
        String horse = request.getParameter(RequestParameter.HORSE);
        String weight = request.getParameter(RequestParameter.WEIGHT);
        try {
            participantService.update(jockey,horse,weight,participantId);
            request.setAttribute(RequestAttribute.ADMIN_PARTICIPANTS_ERROR,"Participant updated successfully");
        } catch (ServiceException e) {
            logger.error("Error while updating participant", e);
            request.setAttribute(RequestAttribute.ADMIN_PARTICIPANTS_ERROR,"Participant was not updated");
        }
        return PagePath.EDIT_PARTICIPANT;
    }
}
