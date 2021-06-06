package by.epam.webproject.model.service.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.dao.ParticipantDao;
import by.epam.webproject.model.dao.RaceDao;
import by.epam.webproject.model.dao.RaceDateDao;
import by.epam.webproject.model.dao.impl.ParticipantsDaoImpl;
import by.epam.webproject.model.dao.impl.RaceDaoImpl;
import by.epam.webproject.model.dao.impl.RaceDateDaoImpl;
import by.epam.webproject.model.entity.Participant;
import by.epam.webproject.model.entity.Race;
import by.epam.webproject.model.entity.RaceData;
import by.epam.webproject.model.service.RaceService;
import by.epam.webproject.model.validator.RaceValidator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The {@code RaceServiceImpl} class represents race service implementation
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class RaceServiceImpl implements RaceService {
    private final RaceDao raceDao = RaceDaoImpl.getInstance();
    private final RaceDateDao raceDateDao = RaceDateDaoImpl.getInstance();
    private final ParticipantDao participantDao = ParticipantsDaoImpl.getInstance();

    @Override
    public boolean createRace(String title, String rounds, String details, String date, String time, String[] participants)
            throws ServiceException {
        boolean isCreated = false;
        try {
            if (RaceValidator.isTitleCorrect(title) && RaceValidator.isRoundsCorrect(rounds) &&
                    RaceValidator.isRaceDateTimeCorrect(date, time) && RaceValidator.isDetailsCorrect(details)) {
                int roundNumber = Integer.parseInt(rounds);
                String race_data_string = date + " " + time;
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime race_date = LocalDateTime.parse(race_data_string, inputFormatter);
                List<Participant> p = new ArrayList<>();
                for (String participant : participants) {
                    Optional<Participant> participantOptional = participantDao.findByHorse(participant);
                    if (participantOptional.isPresent()) {
                        p.add(participantOptional.get());
                    }
                }
                RaceData raceData = new RaceData(race_date, p);
                raceDateDao.add(raceData);
                isCreated = raceDao.add(title, roundNumber, details, raceData);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isCreated;
    }

    @Override
    public boolean deleteRace(int raceId) throws ServiceException {
        boolean isDeleted;
        try {
            isDeleted = raceDao.delete(raceId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isDeleted;
    }

    @Override
    public List<Race> findAllRaces() throws ServiceException {
        try {
            List<Race> races = raceDao.findAllRaces();
            return races;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updateRace(String title, int rounds, String details) throws ServiceException {//todo not used
        return false;
    }
}
