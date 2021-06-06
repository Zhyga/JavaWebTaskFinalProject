package by.epam.webproject.model.dao;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.BetInfo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The {@code BetInfoDao} interface represents bet info dao
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface BetInfoDao {
    /**
     * Find all bet infos by bet id
     *
     * @param betId the bet id
     * @return the list of bet info found by bet id
     * @throws DaoException the dao exception
     */
    List<BetInfo> findAllBetBets(int betId) throws DaoException;

    /**
     * Find all bet infos by user login
     *
     * @param login the login
     * @return  the list of bets info found by login
     * @throws DaoException the dao exception
     */
    List<BetInfo> findAllUserBets(String login) throws DaoException;

    /**
     * Add bet info
     *
     * @param prize the prize
     * @param betAmount the bet amount
     * @param multiplier the multiplier
     * @param date the date
     * @param details the details
     * @param userId the user id
     * @param betId the bet id
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean add(double prize, double betAmount, double multiplier, LocalDateTime date, String details, int userId, int betId) throws DaoException;

    /**
     * Update bet status
     *
     * @param betId the bet id
     * @param status the status
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean update(int betId,String status) throws DaoException;
}
