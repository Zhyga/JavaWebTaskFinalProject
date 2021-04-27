package by.epam.webproject.model.dao.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.dao.ColumnName;
import by.epam.webproject.model.dao.RaceDateDao;
import by.epam.webproject.model.entity.Participant;
import by.epam.webproject.model.entity.RaceData;
import by.epam.webproject.model.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RaceDateDaoImpl implements RaceDateDao {
    private final static RaceDateDaoImpl instance = new RaceDateDaoImpl();
    private static final String ADD = "INSERT INTO race_data (race_data.date) VALUES (?) ";
    private static final String FIND_ALL_PARTICIPANTS = "SELECT race_data.date,race_data.participant_id,horse,weight,jockey FROM race_data " +
            "INNER JOIN participants ON race_data.participant_id = participants.participant_id WHERE race_data.date = ?";

    private RaceDateDaoImpl() {
    }

    public static RaceDateDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean add(RaceData raceData) throws DaoException {
        boolean isAdded;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD, Statement.RETURN_GENERATED_KEYS);) {
            statement.setString(1, String.valueOf(raceData.getDate()));
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                raceData.setRaceDataId(generatedKeys.getInt(1));
            }
            isAdded = true;
        } catch (SQLException e) {
            throw new DaoException("Error while creating race date", e);
        }
        return isAdded;
    }

    @Override
    public List<Participant> findAllParticipants(String raceDate) throws DaoException {//todo refactor
        List<Participant> participants = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_PARTICIPANTS);) {
            statement.setString(1, raceDate);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Participant participant = new Participant();
                participant.setParticipantID(resultSet.getInt(ColumnName.PARTICIPANT_ID));
                participant.setHorse(resultSet.getString(ColumnName.HORSE));
                participant.setWeight(resultSet.getInt(ColumnName.WEIGHT));
                participant.setJockey(resultSet.getString(ColumnName.JOCKEY));
                participants.add(participant);
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding all participants", e);
        }
        return participants;
    }

}
