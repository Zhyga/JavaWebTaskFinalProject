package by.epam.webproject.model.service.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.dao.BetDao;
import by.epam.webproject.model.dao.impl.BetDaoImpl;
import by.epam.webproject.model.entity.Bet;
import by.epam.webproject.model.service.BetService;

import java.util.List;
import java.util.Optional;

/**
 * The {@code BetServiceImpl} class represents bet service implementation
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class BetServiceImpl implements BetService {
    private static final BetDao betDao = BetDaoImpl.getInstance();

    @Override
    public List<Bet> findAllRaceBets(int raceId) throws ServiceException {
        try {
            List<Bet> bets  = betDao.findRaceBets(raceId);
            return bets;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<Bet> findById(int betId) throws ServiceException {
        Optional<Bet> betOptional;
        try {
            betOptional = betDao.findById(betId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return betOptional;
    }

    @Override
    public boolean addBet(String betOdd, int raceId) throws ServiceException {
        boolean isAdded = false;
        double betOddDouble = Double.parseDouble(betOdd);
        try {
            if(betDao.add(raceId,betOddDouble)){
                isAdded = true;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isAdded;
    }

    @Override
    public boolean clearOdds(int raceId) throws ServiceException {
        boolean isCleared = false;
        try {
            if(betDao.removeRaceBets(raceId)){
                isCleared = true;
            }
        } catch (DaoException e) {
           throw new ServiceException(e);
        }
        return isCleared;
    }
}
