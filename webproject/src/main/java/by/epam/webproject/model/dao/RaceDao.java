package by.epam.webproject.model.dao;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.Race;
import by.epam.webproject.model.entity.RaceData;

import java.util.List;

public interface RaceDao {
    List<Race> findAllRaces() throws DaoException;
    boolean add(String title, int rounds, String details, RaceData raceDate) throws DaoException;
    boolean delete(int raceId) throws DaoException;
    boolean update(int id, String title, int rounds, String details) throws DaoException;
}
