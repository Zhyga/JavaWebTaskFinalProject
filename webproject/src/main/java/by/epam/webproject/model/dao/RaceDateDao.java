package by.epam.webproject.model.dao;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.Participant;
import by.epam.webproject.model.entity.RaceData;

import java.util.List;

public interface RaceDateDao {
    boolean add(RaceData raceData) throws DaoException;
    List<Participant> findAllParticipants(String raceDate) throws DaoException;
}
