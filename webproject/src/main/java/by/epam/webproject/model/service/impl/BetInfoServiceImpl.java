package by.epam.webproject.model.service.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.dao.BetInfoDao;
import by.epam.webproject.model.dao.impl.BetInfoDaoImpl;
import by.epam.webproject.model.entity.Bet;
import by.epam.webproject.model.entity.BetInfo;
import by.epam.webproject.model.service.BetInfoService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * The {@code BetInfoServiceImpl} class represents bet info service implementation
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class BetInfoServiceImpl implements BetInfoService {
    private final BetInfoDao betInfoDao = BetInfoDaoImpl.getInstance();

    @Override
    public List<BetInfo> findAllBetsInfo(int betId) throws ServiceException {
        try {
            List<BetInfo> betInfos = betInfoDao.findAllBetBets(betId);
            return betInfos;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<BetInfo> findAllBetsInfo(String login) throws ServiceException {
        try {
            List<BetInfo> betInfos = betInfoDao.findAllUserBets(login);
            return betInfos;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean addBetInfo(double betAmount, double multiplier, LocalDateTime date, String details, int userId, int betId) throws ServiceException {
        boolean isAdded;
        try {
            double prize = betAmount * multiplier;
            betInfoDao.add(prize, betAmount, multiplier, date, details, userId, betId);
            isAdded = true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateBetInfo(int betId, String status) throws ServiceException {
        boolean isUpdated;
        try {
            betInfoDao.update(betId, status);
            isUpdated = true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isUpdated;
    }
}
