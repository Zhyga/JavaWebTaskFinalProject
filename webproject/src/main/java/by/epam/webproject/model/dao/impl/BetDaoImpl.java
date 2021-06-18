package by.epam.webproject.model.dao.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.dao.BetDao;
import by.epam.webproject.model.dao.ColumnName;
import by.epam.webproject.model.entity.Bet;
import by.epam.webproject.model.entity.Race;
import by.epam.webproject.model.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The {@code BetDaoImpl} class represents bet dao implementation
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class BetDaoImpl implements BetDao {
    private static final BetDaoImpl instance = new BetDaoImpl();
    private static final String FIND_ALL_RACE_BETS = "SELECT bet_id,type_of_bet,first_multiplier,second_multiplier,bets.race_id " +
            "FROM bets INNER JOIN races on bets.race_id = races.race_id WHERE bets.race_id = ?";
    private static final String FIND_BET_BY_ID = "SELECT bet_id,type_of_bet,first_multiplier,second_multiplier,bets.race_id " +
            "FROM bets WHERE bet_id = ?";
    private static final String ADD = "INSERT INTO bets (first_multiplier,bets.race_id) VALUES (?,?)";
    private static final String DELETE_BETS = "DELETE FROM bets WHERE bets.race_id = ?";

    private BetDaoImpl() {
    }

    /**
     * Gets instance
     *
     * @return the instance
     */
    public static BetDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<Bet> findRaceBets(int raceId) throws DaoException {
        List<Bet> bets = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_RACE_BETS);) {
            statement.setInt(1, raceId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bets.add(createBetsFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding all bets on race", e);
        }
        return bets;
    }

    @Override
    public Optional<Bet> findById(int betId) throws DaoException {
        Optional<Bet> betOptional = Optional.empty();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BET_BY_ID);) {
            statement.setInt(1, betId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                betOptional = Optional.of(createBetsFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding all bets on race", e);
        }
        return betOptional;
    }

    @Override
    public boolean add(int raceId, double firstMultiplier) throws DaoException {
        boolean isAdded;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD);) {
            statement.setDouble(1, firstMultiplier);
            statement.setInt(2, raceId);
            statement.executeUpdate();
            isAdded = true;
        } catch (SQLException e) {
            throw new DaoException("Error while creating race", e);
        }
        return isAdded;
    }

    @Override
    public boolean removeRaceBets(int raceId) throws DaoException {
        boolean isRemoved;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BETS);) {
            statement.setInt(1, raceId);
            statement.execute();
            isRemoved = true;
        } catch (SQLException e) {
            throw new DaoException("Error while removing all bets on race", e);
        }
        return isRemoved;
    }

    private Bet createBetsFromResultSet(ResultSet resultSet) throws SQLException {
        Bet bet = new Bet();
        bet.setBetId(resultSet.getInt(ColumnName.BET_ID));
        bet.setTypeOfBet(resultSet.getString(ColumnName.TYPE_OF_BET));
        bet.setFirstMultiplier(resultSet.getDouble(ColumnName.FIRST_MULTIPLIER));
        bet.setSecondMultiplier(resultSet.getDouble(ColumnName.SECOND_MULTIPLIER));
        return bet;
    }
}
