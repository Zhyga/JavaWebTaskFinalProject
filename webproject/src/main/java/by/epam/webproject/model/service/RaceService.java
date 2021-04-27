package by.epam.webproject.model.service;

import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Race;

import java.util.List;


public interface RaceService {
    List<Race> findAllRaces() throws ServiceException;
    boolean createRace(String title, String rounds, String details,String date, String time) throws ServiceException;
    boolean deleteRace(int raceId) throws ServiceException;
    boolean updateRace(String title,int rounds,String details) throws ServiceException;
}
