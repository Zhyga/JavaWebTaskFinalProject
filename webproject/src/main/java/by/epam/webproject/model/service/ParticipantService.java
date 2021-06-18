package by.epam.webproject.model.service;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Participant;

import java.util.List;
import java.util.Optional;

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
     * @param jockey the jockey
     * @param horse  the horse
     * @param weight the weight
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean add(String jockey, String horse,String weight) throws ServiceException;

    /**
     * Delete participant
     *
     * @param participantId the participant id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean deleteParticipant(String participantId) throws ServiceException;

    /**
     * Update participant
     *
     * @param jockey the jockey
     * @param horse  the horse
     * @param weight the weight
     * @param participantId the participant id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean update(String jockey, String horse,String weight, String participantId) throws ServiceException;

    /**
     * Find all participants
     *
     * @return the list of participants
     * @throws ServiceException the service exception
     */
    List<Participant> findAllParticipants() throws ServiceException;

    /**
     * Find participant by id
     *
     * @param id the id
     * @return the optional of found participant
     * @throws ServiceException the dao exception
     */
    Optional<Participant> findParticipantById(String id) throws ServiceException;
}
