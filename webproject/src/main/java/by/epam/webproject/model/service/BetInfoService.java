package by.epam.webproject.model.service;

import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.BetInfo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The {@code BetInfoService} interface represents bet info service
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface BetInfoService {
    /**
     * Find all bet infos by bet id
     *
     * @param betId the bet id
     * @return the list of bet info found by bet id
     * @throws ServiceException the service exception
     */
    List<BetInfo> findAllBetsInfo(int betId) throws ServiceException;

    /**
     * Find all bet infos by user login
     *
     * @param login the login
     * @return the list of bet info found by login
     * @throws ServiceException the service exception
     */
    List<BetInfo> findAllBetsInfo(String login) throws ServiceException;

    /**
     *  Add bet info
     *
     * @param betAmount the bet amount
     * @param multiplier the multiplier
     * @param date the date
     * @param details the details
     * @param userId the user id
     * @param betId the bet id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean addBetInfo(double betAmount, double multiplier, LocalDateTime date, String details, int userId, int betId) throws ServiceException;

    /**
     * Update bet info
     *
     * @param betId the bet id
     * @param status the status
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean updateBetInfo(int betId,String status) throws ServiceException;
}
