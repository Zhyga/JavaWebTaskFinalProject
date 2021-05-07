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

public class BetDaoImpl implements BetDao {
    private static final BetDaoImpl instance = new BetDaoImpl();
    private static final String FIND_ALL_RACE_BETS = "SELECT bet_id,type_of_bet,first_multiplier,second_multiplier,bets.race_id " +
            "FROM bets INNER JOIN races on bets.race_id = races.race_id WHERE bets.race_id = ?";

    private BetDaoImpl() {
    }

    public static BetDaoImpl getInstance(){
        return instance;
    }

    @Override
    public List<Bet> findRaceBets(int raceId) throws DaoException {
        List<Bet> bets = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_RACE_BETS);) {
            statement.setInt(1,raceId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bets.add(createBetsFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding all bets on race", e);
        }
        return bets;
    }

    private Bet createBetsFromResultSet(ResultSet resultSet) throws SQLException {
        Bet bet = new Bet();
        bet.setBetId(resultSet.getInt(ColumnName.BET_ID));
        bet.setTypeOfBet(resultSet.getString(ColumnName.TYPE_OF_BET));
        bet.setFirstMultiplier(resultSet.getDouble(ColumnName.FIRST_MULTIPLIER));
        bet.setSecondMultiplier(resultSet.getDouble(ColumnName.SECOND_MULTIPLIER));
        //bet.setRaceId(resultSet.getInt(ColumnName.RACE_ID));
        return bet;
    }
}
