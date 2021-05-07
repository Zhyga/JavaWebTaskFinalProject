package by.epam.webproject.model.service;

import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.BetInfo;

import java.time.LocalDateTime;
import java.util.List;

public interface BetInfoService {
    List<BetInfo> findAllBetsInfo(String login) throws ServiceException;
    boolean addBetInfo(double betAmount, double multiplier, LocalDateTime date, String details, int userId, int betId) throws ServiceException;
    boolean updateBetInfo(int betInfoId) throws ServiceException;
}
