package by.epam.webproject.model.dao.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.dao.BetInfoDao;
import by.epam.webproject.model.dao.ColumnName;
import by.epam.webproject.model.entity.Bet;
import by.epam.webproject.model.entity.BetInfo;
import by.epam.webproject.model.entity.Race;
import by.epam.webproject.model.entity.RaceData;
import by.epam.webproject.model.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code BetInfoDaoImpl} class represents bet info dao implementation
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class BetInfoDaoImpl implements BetInfoDao {
    private static final BetInfoDaoImpl instance = new BetInfoDaoImpl();
    private static final String FIND_ALL_BY_USERS = "SELECT bet_info_id,prize,bet_amount,multiplier,bet_status,bet_info.user_id," +
            "bet_info.bet_id,bet_info.date,bet_details " +
            "FROM bet_info INNER JOIN users ON bet_info.user_id = users.user_id " +
            "WHERE users.login LIKE ?";
    private static final String FIND_ALL_BY_BETID = "SELECT bet_info_id,prize,bet_amount,multiplier,bet_status,bet_info.user_id," +
            "bet_info.bet_id,bet_info.date,bet_details " +
            "FROM bet_info WHERE bet_info.bet_id LIKE ?";
    private static final String ADD = "INSERT INTO bet_info (prize,bet_amount,multiplier,bet_info.date,bet_details,user_id,bet_id) " +
            "VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE bet_info SET bet_status = ? WHERE bet_id = ?";

    private BetInfoDaoImpl() {
    }

    /**
     * Gets instance
     *
     * @return the instance
     */
    public static BetInfoDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<BetInfo> findAllBetBets(int betId) throws DaoException {
        List<BetInfo> betInfos = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_BETID);) {
            statement.setInt(1,betId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                betInfos.add(createBetInfoFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding bet history", e);
        }
        return betInfos;
    }

    @Override
    public List<BetInfo> findAllUserBets(String login) throws DaoException {
        List<BetInfo> betInfos = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_USERS);) {
            statement.setString(1,login);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                betInfos.add(createBetInfoFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding bet history", e);
        }
        return betInfos;
    }

    @Override
    public boolean add(double prize, double betAmount, double multiplier,LocalDateTime date,String details, int userId, int betId) throws DaoException {
        boolean isAdded;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD);) {
            statement.setDouble(1, prize);
            statement.setDouble(2, betAmount);
            statement.setDouble(3, multiplier);
            statement.setString(4, String.valueOf(date));
            statement.setString(5, details);
            statement.setInt(6, userId);
            statement.setInt(7, betId);
            statement.executeUpdate();
            isAdded = true;
        } catch (SQLException e) {
            throw new DaoException("Error while creating bet info", e);
        }
        return isAdded;
    }

    @Override
    public boolean update(int betId,String status) throws DaoException {
        boolean isUpdated;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE);) {
            statement.setString(1, status);
            statement.setInt(2, betId);
            statement.executeUpdate();
            isUpdated = true;
        } catch (SQLException e) {
            throw new DaoException("Error while changing bet info", e);
        }
        return isUpdated;
    }

    private BetInfo createBetInfoFromResultSet(ResultSet resultSet) throws SQLException {
        BetInfo betInfo = new BetInfo();
        betInfo.setBetInfoId(resultSet.getInt(ColumnName.BET_INFO_ID));
        betInfo.setBetSize(resultSet.getDouble(ColumnName.BET_SIZE));
        betInfo.setBetStatus(resultSet.getString(ColumnName.BET_STATUS));
        betInfo.setMultiplier(resultSet.getDouble(ColumnName.MULTIPLIER));
        betInfo.setPrize(resultSet.getDouble(ColumnName.PRIZE));
        betInfo.setUserId(resultSet.getInt(ColumnName.USER_ID));
        String race_data_string = resultSet.getString(ColumnName.DATE);
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime race_data = LocalDateTime.parse(race_data_string, inputFormatter);
        betInfo.setDate(race_data);
        betInfo.setBetInfo(resultSet.getString(ColumnName.BET_DETAILS));
        betInfo.setBetId(resultSet.getInt(ColumnName.BET_ID));
        return betInfo;
    }
}
