package by.epam.webproject.model.dao.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.dao.ColumnName;
import by.epam.webproject.model.dao.ParticipantDao;
import by.epam.webproject.model.dao.RaceDao;
import by.epam.webproject.model.entity.Participant;
import by.epam.webproject.model.entity.Race;
import by.epam.webproject.model.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The {@code ParticipantsDaoImpl} class represents participants dao implementation
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class ParticipantsDaoImpl implements ParticipantDao {
    private static final ParticipantsDaoImpl instance = new ParticipantsDaoImpl();
    private static final String ADD = "INSERT INTO participants (jockey,horse,weight) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE participants SET jockey = ?, horse = ?, weight = ?";
    private static final String FIND_ALL = "SELECT participant_id,horse,weight,jockey FROM participants";
    private static final String FIND_BY_HORSE = "SELECT participant_id,horse,weight,jockey FROM participants WHERE horse = ?";
    private static final String FIND_BY_ID = "SELECT participant_id,horse,weight,jockey FROM participants WHERE participant_id = ?";

    private ParticipantsDaoImpl() {
    }

    /**
     * Gets instance
     *
     * @return the instance
     */
    public static ParticipantDao getInstance() {
        return instance;
    }

    @Override
    public boolean add(String jockey, String horse,int weight) throws DaoException {
        boolean isAdded;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD);
             ) {
            statement.setString(1,jockey);
            statement.setString(2,horse);
            statement.setInt(3,weight);
            statement.executeUpdate();
            isAdded = true;
        } catch (SQLException e) {
            throw new DaoException("Error while adding participant", e);
        }
        return isAdded;
    }

    @Override
    public boolean update(String jockey, String horse, int weight) throws DaoException {
        boolean isUpdated;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE);
        ) {
            statement.setString(1,jockey);
            statement.setString(2,horse);
            statement.setInt(3,weight);
            statement.executeUpdate();
            isUpdated = true;
        } catch (SQLException e) {
            throw new DaoException("Error while updating participant", e);
        }
        return isUpdated;
    }

    @Override
    public List<Participant> findAll() throws DaoException {
        List<Participant> participants = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                Participant participant = new Participant();
                participant.setParticipantID(resultSet.getInt(ColumnName.PARTICIPANT_ID));
                participant.setHorse(resultSet.getString(ColumnName.HORSE));
                participant.setWeight(resultSet.getInt(ColumnName.WEIGHT));
                participant.setJockey(resultSet.getString(ColumnName.JOCKEY));
                participants.add(participant);
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding all users", e);
        }
        return participants;
    }

    @Override
    public Optional<Participant> findById(int id) throws DaoException {
        Optional<Participant> participantOptional = Optional.empty();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Participant participant = new Participant();
                participant.setParticipantID(resultSet.getInt(ColumnName.PARTICIPANT_ID));
                participant.setHorse(resultSet.getString(ColumnName.HORSE));
                participant.setWeight(resultSet.getInt(ColumnName.WEIGHT));
                participant.setJockey(resultSet.getString(ColumnName.JOCKEY));
                participantOptional = Optional.of(participant);
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding participant", e);
        }
        return participantOptional;
    }

    @Override
    public Optional<Participant> findByHorse(String horse) throws DaoException {
        Optional<Participant> participantOptional = Optional.empty();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_HORSE);) {
            statement.setString(1, horse);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Participant participant = new Participant();
                participant.setParticipantID(resultSet.getInt(ColumnName.PARTICIPANT_ID));
                participant.setHorse(resultSet.getString(ColumnName.HORSE));
                participant.setWeight(resultSet.getInt(ColumnName.WEIGHT));
                participant.setJockey(resultSet.getString(ColumnName.JOCKEY));
                participantOptional = Optional.of(participant);
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding participant", e);
        }
        return participantOptional;
    }
}
