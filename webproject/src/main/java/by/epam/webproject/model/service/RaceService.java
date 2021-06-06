package by.epam.webproject.model.service;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Race;

import java.util.List;

/**
 * The {@code CreateRaceCommand} interface represents race service
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface RaceService {
    /**
     * Find all races
     *
     * @return the list of all found races
     * @throws ServiceException the service exception
     */
    List<Race> findAllRaces() throws ServiceException;

    /**
     * Add race
     *
     * @param title the title
     * @param rounds the rounds
     * @param details the details
     * @param date the race date
     * @param time the race date
     * @param participants the participants
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean createRace(String title, String rounds, String details,String date, String time,String[] participants) throws ServiceException;

    /**
     * Delete race
     *
     * @param raceId the race id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean deleteRace(int raceId) throws ServiceException;

    /**
     * Update race
     *
     * @param title the title
     * @param rounds the rounds
     * @param details the details
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean updateRace(String title,int rounds,String details) throws ServiceException;
}
