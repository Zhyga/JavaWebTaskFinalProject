package by.epam.webproject.model.dao;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.Participant;
import by.epam.webproject.model.entity.RaceData;

import java.util.List;

/**
 * The {@code RaceDateDao} interface represents race date dao
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface RaceDateDao {
    /**
     * Add race date
     *
     * @param raceData the race date
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean add(RaceData raceData) throws DaoException;

    /**
     * Find all participants by race date
     *
     * @param raceDate the race date
     * @return the list of found participants
     * @throws DaoException the dao exception
     */
    List<Participant> findAllParticipantsByDate(String raceDate) throws DaoException;
}
