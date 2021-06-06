package by.epam.webproject.model.dao;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.Participant;

import java.util.List;
import java.util.Optional;

/**
 * The {@code ParticipantDao} interface represents participant dao
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface ParticipantDao {
    /**
     * Add participant
     *
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean add() throws DaoException;//todo

    /**
     * Find all participants
     *
     * @return list of all founded participants
     * @throws DaoException the dao exception
     */
    List<Participant> findAll() throws DaoException;

    /**
     * Find participant by horse
     *
     * @param horse the horse
     * @return the optional of found participant
     * @throws DaoException the dao exception
     */
    Optional<Participant> findByHorse(String horse) throws DaoException;
}
