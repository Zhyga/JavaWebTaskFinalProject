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

public class ToAdminParticipantsPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final ParticipantService part = new ParticipantsServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        try {
            List<Participant> participantList = part.findAllParticipants();
            request.setAttribute(RequestAttribute.RACE_PARTICIPANTS,participantList);
        } catch (ServiceException e) {
            logger.error("Error while finding all participants", e);
        }
        return PagePath.ADMIN_PARTICIPANTS;
    }
}
