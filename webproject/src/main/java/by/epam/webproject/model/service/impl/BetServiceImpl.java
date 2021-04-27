package by.epam.webproject.model.service.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.dao.BetDao;
import by.epam.webproject.model.dao.impl.BetDaoImpl;
import by.epam.webproject.model.entity.Bet;
import by.epam.webproject.model.service.BetService;

import java.util.List;

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
}
