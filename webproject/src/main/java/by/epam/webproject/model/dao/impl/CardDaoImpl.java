package by.epam.webproject.model.dao.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.dao.CardDao;
import by.epam.webproject.model.entity.BetInfo;
import by.epam.webproject.model.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The {@code CardDaoImpl} class represents card dao implementation
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class CardDaoImpl implements CardDao {
    private static final CardDaoImpl instance = new CardDaoImpl();
    private static final String FIND_BY_CARD_NUMBER = "SELECT * FROM payment_cards WHERE card_number LIKE ? " +
            "AND balance >= ?";
    private static final String UPDATE = "UPDATE payment_cards SET balance = ? WHERE card_number = ?";

    private CardDaoImpl() {
    }

    /**
     * Gets instance
     *
     * @return the instance
     */
    public static CardDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean findByCardNumber(String cardNumber, double balance) throws DaoException {
        boolean isFound = false;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_CARD_NUMBER);) {
            statement.setString(1,cardNumber);
            statement.setDouble(2,balance);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isFound = true;
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding card", e);
        }
        return isFound;
    }

    @Override
    public boolean update(String cardNumber, double balance) throws DaoException {
        boolean isUpdated;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE);) {
            statement.setDouble(1, balance);
            statement.setString(2, cardNumber);
            statement.executeUpdate();
            isUpdated = true;
        } catch (SQLException e) {
            throw new DaoException("Error while changing card balance", e);
        }
        return isUpdated;
    }
}
