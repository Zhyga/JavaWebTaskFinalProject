package by.epam.webproject.model.dao;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.Bet;

import java.util.List;

public interface BetDao {
    List<Bet> findRaceBets(int raceId) throws DaoException;
}
