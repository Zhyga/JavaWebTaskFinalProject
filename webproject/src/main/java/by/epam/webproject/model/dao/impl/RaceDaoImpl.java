package by.epam.webproject.model.dao.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.dao.ColumnName;
import by.epam.webproject.model.dao.RaceDao;
import by.epam.webproject.model.dao.RaceDateDao;
import by.epam.webproject.model.entity.*;
import by.epam.webproject.model.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RaceDaoImpl implements RaceDao {
    private static final RaceDaoImpl instance = new RaceDaoImpl();
    private static final RaceDateDaoImpl raceDateDao = RaceDateDaoImpl.getInstance();
    private static final String FIND_ALL = "SELECT race_id,title,rounds,details,races.race_data_id,race_data.date," +
            "race_data.participant_id FROM races INNER JOIN race_data ON races.race_data_id = race_data.race_data_id " +
            "ORDER BY race_data.date";
    private static final String ADD = "INSERT INTO races (title,rounds,details,races.race_data_id) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE races SET title = ?, round = ?, details = ? WHERE race_id = ?";
    private static final String DELETE = "DELETE FROM races WHERE race_id = ?";

    private RaceDaoImpl() {
    }

    public static RaceDao getInstance() {
        return instance;
    }

    @Override
    public List<Race> findAllRaces() throws DaoException {
        List<Race> races = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                races.add(createRacesFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding all users", e);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return races;
    }


    @Override
    public boolean add(String title, int rounds, String details,RaceData raceDate) throws DaoException {//todo add participants
        boolean isAdded;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD);) {
            statement.setString(1, title);
            statement.setInt(2, rounds);
            statement.setString(3, details);
            raceDateDao.add(raceDate);
            statement.setInt(4,raceDate.getRaceDataId());
            statement.executeUpdate();
            isAdded = true;
        } catch (SQLException e) {
            throw new DaoException("Error while creating race", e);
        }
        return isAdded;
    }

    @Override
    public boolean delete(int raceId) throws DaoException {
        boolean isDeleted;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE);) {
            statement.setInt(1, raceId);
            statement.executeUpdate();
            isDeleted = true;
        } catch (SQLException e) {
            throw new DaoException("Error while deleting race", e);
        }
        return isDeleted;
    }

    @Override
    public boolean update(int id, String title, int rounds, String details) throws DaoException {//todo test(not used)
        boolean isUpdated;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE);) {
            statement.setString(1, title);
            statement.setInt(2, rounds);
            statement.setString(3, details);
            statement.setInt(4, id);
            statement.executeUpdate();
            isUpdated = true;
        } catch (SQLException e) {
            throw new DaoException("Error while changing user balance", e);
        }
        return isUpdated;
    }

    private Race createRacesFromResultSet(ResultSet resultSet) throws SQLException, ParseException, DaoException {
        Race race = new Race();
        int id = resultSet.getInt(ColumnName.RACE_ID);
        String title = resultSet.getString(ColumnName.TITLE);
        int rounds = resultSet.getInt(ColumnName.ROUNDS);
        String details = resultSet.getString(ColumnName.DETAILS);
        String race_data_string = resultSet.getString(ColumnName.DATE);
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime race_data = LocalDateTime.parse(race_data_string, inputFormatter);
        int race_date_id = resultSet.getInt(ColumnName.RACE_DATA_ID);
        race.setRaceId(id);
        race.setTitle(title);
        race.setRounds(rounds);
        race.setDetails(details);
        List<Participant> participants = raceDateDao.findAllParticipants(race_data_string);
        race.setRaceData(new RaceData(race_date_id, race_data, participants));
        return race;
    }
}
