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
    private static final String FIND_ALL = "SELECT participant_id,horse,weight,jockey FROM participants";
    private static final String FIND_BY_HORSE = "SELECT participant_id,horse,weight,jockey FROM participants WHERE horse = ?";

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
    public boolean add() throws DaoException {//todo
        return false;
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
