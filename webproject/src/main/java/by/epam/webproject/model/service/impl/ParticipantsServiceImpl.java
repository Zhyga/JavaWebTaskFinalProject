package by.epam.webproject.model.service.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.dao.ParticipantDao;
import by.epam.webproject.model.dao.impl.ParticipantsDaoImpl;
import by.epam.webproject.model.entity.Participant;
import by.epam.webproject.model.service.ParticipantService;
import by.epam.webproject.model.validator.ParticipantValidator;

import java.util.List;
import java.util.Optional;

/**
 * The {@code ParticipantsServiceImpl} class represents participants service implementation
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class ParticipantsServiceImpl implements ParticipantService {
    private final ParticipantDao participantDao = ParticipantsDaoImpl.getInstance();

    @Override
    public boolean add(String jockey, String horse,String weight) throws ServiceException {
        boolean isAdded = false;
        if(ParticipantValidator.isJockeyCorrect(jockey) && ParticipantValidator.isHorseCorrect(horse) &&
        ParticipantValidator.isWeightCorrect(weight)) {
            int weightInt = Integer.parseInt(weight);
            try {
                if(participantDao.add(jockey, horse, weightInt)){
                    isAdded = true;
                }
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return isAdded;
    }

    @Override
    public boolean deleteParticipant(String participantId) throws ServiceException {
        boolean isDeleted = false;
        try {
            if(ParticipantValidator.isIdCorrect(participantId)) {
                int participantIdInt = Integer.parseInt(participantId);
                isDeleted = participantDao.delete(participantIdInt);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isDeleted;
    }

    @Override
    public boolean update(String jockey, String horse, String weight, String participantId) throws ServiceException {
        boolean isUpdated = false;
        if(ParticipantValidator.isJockeyCorrect(jockey) && ParticipantValidator.isHorseCorrect(horse) &&
                ParticipantValidator.isWeightCorrect(weight) && ParticipantValidator.isIdCorrect(participantId)) {
            int weightInt = Integer.parseInt(weight);
            int participantIdInt = Integer.parseInt(participantId);
            try {
                if(participantDao.update(jockey, horse, weightInt,participantIdInt)){
                    isUpdated = true;
                }
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return isUpdated;
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

    @Override
    public Optional<Participant> findParticipantById(String id) throws ServiceException {
        Optional<Participant> participantOptional = Optional.empty();
        try {
            if(ParticipantValidator.isIdCorrect(id)) {
                int participantId = Integer.parseInt(id);
                participantOptional = participantDao.findById(participantId);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return participantOptional;
    }
}
