package by.epam.webproject.model.service;

import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.BetInfo;

import java.util.List;

public interface BetInfoService {
    List<BetInfo> findAllBetsInfo(String login) throws ServiceException;
    boolean addBetInfo(double prize, double betAmount, double multiplier, int userId, int betId) throws ServiceException;
    boolean updateBetInfo(int betInfoId) throws ServiceException;
}
