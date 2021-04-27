package by.epam.webproject.model.service;

import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Bet;

import java.util.List;

public interface BetService {
    List<Bet> findAllRaceBets(int raceId) throws ServiceException;
}
