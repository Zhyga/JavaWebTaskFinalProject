package by.epam.webproject.model.dao;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.Bet;

import java.util.List;
import java.util.Optional;

/**
 * The {@code BetDao} interface represents bet dao
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface BetDao {
    /**
     * Find all race bets
     *
     * @param raceId the race id
     * @return the list of found bets
     * @throws DaoException the dao exception
     */
    List<Bet> findRaceBets(int raceId) throws DaoException;

    /**
     * Find bet by id
     *
     * @param betId the bet id
     * @return the optional of bet
     * @throws DaoException the dao exception
     */
    Optional<Bet> findById(int betId) throws DaoException;
}
