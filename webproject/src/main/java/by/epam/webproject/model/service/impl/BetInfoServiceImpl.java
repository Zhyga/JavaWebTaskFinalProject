package by.epam.webproject.model.service.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.dao.BetInfoDao;
import by.epam.webproject.model.dao.impl.BetInfoDaoImpl;
import by.epam.webproject.model.entity.BetInfo;
import by.epam.webproject.model.service.BetInfoService;

import java.util.List;

public class BetInfoServiceImpl implements BetInfoService {
    private final BetInfoDao betInfoDao = BetInfoDaoImpl.getInstance();

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
    public boolean addBetInfo(double prize, double betAmount, double multiplier, int userId, int betId) throws ServiceException {//todo
        return false;
    }

    @Override
    public boolean updateBetInfo(int betInfoId) throws ServiceException {//todo
        return false;
    }
}
