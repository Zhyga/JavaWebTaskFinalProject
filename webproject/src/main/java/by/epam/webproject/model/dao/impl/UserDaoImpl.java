package by.epam.webproject.model.dao.impl;

import by.epam.webproject.model.dao.ColumnName;
import by.epam.webproject.model.dao.UserDao;
import by.epam.webproject.model.entity.User;
import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final UserDaoImpl instance = new UserDaoImpl();
    private static final String ADD = "INSERT INTO users (email,login,password) VALUES (?,?,?)";
    private static final String FIND_ALL = "SELECT user_id,email,login,password,amount_of_bets,is_approved FROM users";
    private static final String FIND_BY_EMAIL = "SELECT user_id,email,login,password,amount_of_bets,is_approved FROM users "
            + "WHERE email LIKE ?";
    private static final String FIND_BY_LOGIN = "SELECT user_id,email,login,password,amount_of_bets,is_approved FROM users "
            + "WHERE email LIKE ?";
    private static final String CHECK_BY_LOGIN = "SELECT password FROM users WHERE login LIKE ?";
    private static final String AUTHORIZE = "SELECT user_id,email,login,password,amount_of_bets,is_approved FROM users "
            + "WHERE login LIKE ?";


    private UserDaoImpl() {
    }

    public static UserDao getInstance() {
        return instance;
    }

    @Override
    public List<User> findAllUsers() throws DaoException {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(createUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding all users", e);
        }
        return users;
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws DaoException {
        Optional<User> user = Optional.empty();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = Optional.of(createUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding all users", e);
        }
        return user;
    }

    @Override
    public Optional<User> findUserByLogin(String login) throws DaoException {
        Optional<User> user = Optional.empty();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_LOGIN);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = Optional.of(createUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding all users", e);
        }
        return user;
    }

    @Override
    public Optional<User> authorize(String login) throws DaoException {
        Optional<User> user = Optional.empty();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(AUTHORIZE);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = Optional.of(createUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Error while authorize user", e);
        }
        return user;
    }

    @Override
    public String checkByLogin(String login) throws DaoException {
        String password = null;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CHECK_BY_LOGIN);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                password = resultSet.getString(ColumnName.PASSWORD);
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding user: " + login, e);
        }
        return password;
    }

    @Override
    public boolean add(String email, String login, String password) throws DaoException {
        boolean isAdded;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, email);
            statement.setString(2, login);
            statement.setString(3, password);
            statement.executeUpdate();
            isAdded = true;
        } catch (SQLException e) {
            throw new DaoException("Error while finding user: " + login, e);
        }
        return isAdded;
    }

    private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        int id = resultSet.getInt(ColumnName.USER_ID);
        String login = resultSet.getString(ColumnName.LOGIN);
        String email = resultSet.getString(ColumnName.EMAIL);
        String password = resultSet.getString(ColumnName.PASSWORD);
        int amountOfBets = resultSet.getInt(ColumnName.AMOUNT_OF_BETS);
        int isApproved = resultSet.getInt(ColumnName.IS_APPROVED);
        user.setUserId(id);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setAmountOfBets(amountOfBets);
        user.setIsApproved(isApproved);
        return user;
    }
}
