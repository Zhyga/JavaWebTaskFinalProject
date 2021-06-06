package by.epam.webproject.model.service.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.dao.ParticipantDao;
import by.epam.webproject.model.dao.impl.ParticipantsDaoImpl;
import by.epam.webproject.model.entity.Participant;
import by.epam.webproject.model.service.ParticipantService;

import java.util.List;

/**
 * The {@code ParticipantsServiceImpl} class represents participants service implementation
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class ParticipantsServiceImpl implements ParticipantService {
    private final ParticipantDao participantDao = ParticipantsDaoImpl.getInstance();

    @Override
    public boolean add() throws ServiceException {
        return false;
    }

    @Override
    public List<Participant> findAllParticipants() throws ServiceException {
        try {
            List<Participant> participants = participantDao.findAll();
            return participants;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
