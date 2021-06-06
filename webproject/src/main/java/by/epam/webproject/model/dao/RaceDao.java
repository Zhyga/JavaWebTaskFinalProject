package by.epam.webproject.model.dao;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.Race;
import by.epam.webproject.model.entity.RaceData;

import java.util.List;

/**
 * The {@code RaceDao} interface represents race dao
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface RaceDao {
    /**
     * Find all races
     *
     * @return the list of all found races
     * @throws DaoException the dao exception
     */
    List<Race> findAllRaces() throws DaoException;

    /**
     * Add race
     *
     * @param title the title
     * @param rounds the rounds
     * @param details the details
     * @param raceDate the race date
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean add(String title, int rounds, String details, RaceData raceDate) throws DaoException;

    /**
     * Delete race
     *
     * @param raceId the race id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean delete(int raceId) throws DaoException;

    /**
     * Update race
     *
     * @param id the id
     * @param title the title
     * @param rounds the rounds
     * @param details the details
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean update(int id, String title, int rounds, String details) throws DaoException;
}
