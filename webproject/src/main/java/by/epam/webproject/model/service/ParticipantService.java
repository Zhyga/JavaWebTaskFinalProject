package by.epam.webproject.model.service;

import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Participant;

import java.util.List;

/**
 * The {@code ParticipantService} interface represents create race command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface ParticipantService {
    /**
     * Add participant
     *
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean add() throws ServiceException;//todo

    /**
     * Find all participants
     *
     * @return the list of participants
     * @throws ServiceException the service exception
     */
    List<Participant> findAllParticipants() throws ServiceException;
}
