package by.epam.webproject.model.dao;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.BetInfo;

import java.util.List;

public interface BetInfoDao {
    List<BetInfo> findAllUserBets(String login) throws DaoException;
    boolean add(double prize, double betAmount, double multiplier, int userId, int betId) throws DaoException;
    boolean update(int betInfoId) throws DaoException;
}
