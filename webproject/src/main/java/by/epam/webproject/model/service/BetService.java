package by.epam.webproject.model.service;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Bet;

import java.util.List;
import java.util.Optional;

/**
 * The {@code BetService} interface represents bet service
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface BetService {
    /**
     * Find all race bets
     *
     * @param raceId the race id
     * @return the list of bets found by race id
     * @throws ServiceException the service exception
     */
    List<Bet> findAllRaceBets(int raceId) throws ServiceException;

    /**
     * Find bet by id
     *
     * @param betId the bet id
     * @return the optional of bet
     * @throws ServiceException the service exception
     */
    Optional<Bet> findById(int betId) throws ServiceException;

    /**
     *
     * @param raceId the race id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean clearOdds(int raceId) throws ServiceException;
}
