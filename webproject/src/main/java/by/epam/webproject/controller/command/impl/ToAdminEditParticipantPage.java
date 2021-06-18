package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Participant;
import by.epam.webproject.model.service.ParticipantService;
import by.epam.webproject.model.service.impl.ParticipantsServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class ToAdminEditParticipantPage implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final ParticipantService participantService = new ParticipantsServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String participantId = request.getParameter(RequestParameter.PARTICIPANT_ID);
        try {
            Optional<Participant> participantOptional = participantService.findParticipantById(participantId);
            if(participantOptional.isPresent()){
                HttpSession session = request.getSession();
                session.setAttribute(SessionAttribute.PARTICIPANT_ID,participantOptional.get().getParticipantID());
                session.setAttribute(SessionAttribute.JOCKEY,participantOptional.get().getJockey());
                session.setAttribute(SessionAttribute.HORSE,participantOptional.get().getHorse());
                session.setAttribute(SessionAttribute.WEIGHT,participantOptional.get().getWeight());
            }
        } catch (ServiceException e) {
            logger.error("Error while finding participant by id", e);
        }
        return PagePath.EDIT_PARTICIPANT;
    }
}
