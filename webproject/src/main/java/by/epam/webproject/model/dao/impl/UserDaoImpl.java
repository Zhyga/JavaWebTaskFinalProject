package by.epam.webproject.model.dao.impl;

import by.epam.webproject.model.dao.ColumnName;
import by.epam.webproject.model.dao.UserDao;
import by.epam.webproject.model.dao.WalletDao;
import by.epam.webproject.model.entity.User;
import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.UserRole;
import by.epam.webproject.model.entity.Wallet;
import by.epam.webproject.model.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The {@code UserDaoImpl} class represents user dao implementation
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class UserDaoImpl implements UserDao {
    private static final UserDaoImpl instance = new UserDaoImpl();
    private static final String ADD = "INSERT INTO users (email,login,password,wallet_id) VALUES (?,?,?,?)";
    private static final String FIND_ALL = "SELECT user_id,email,login,password,amount_of_bets,is_approved,users.role_id," +
            "users.wallet_id,role_name,balance FROM users INNER JOIN roles ON users.role_id = roles.role_id " +
            "INNER JOIN wallets ON users.wallet_id = wallets.wallet_id";
    private static final String FIND_BY_EMAIL = "SELECT user_id,email,login,password,amount_of_bets,is_approved,users.role_id," +
            "role_name,users.wallet_id,balance FROM users INNER JOIN roles ON users.role_id = roles.role_id " +
            "INNER JOIN wallets ON users.wallet_id = wallets.wallet_id "
            + "WHERE email LIKE ?";
    private static final String FIND_BY_LOGIN = "SELECT user_id,email,login,password,amount_of_bets,is_approved,users.role_id," +
            "role_name,users.wallet_id,balance FROM users INNER JOIN roles ON users.role_id = roles.role_id " +
            "INNER JOIN wallets ON users.wallet_id = wallets.wallet_id "
            + "WHERE login LIKE ?";
    private static final String FIND_BY_ID = "SELECT user_id,email,login,password,amount_of_bets,is_approved,users.role_id," +
            "role_name,users.wallet_id,balance FROM users INNER JOIN roles ON users.role_id = roles.role_id " +
            "INNER JOIN wallets ON users.wallet_id = wallets.wallet_id "
            + "WHERE user_id LIKE ?";
    private static final String CHECK_BY_LOGIN = "SELECT password FROM users WHERE login LIKE ?";
    private static final String UPDATE_ROLE_BALANCE = "UPDATE users INNER JOIN wallets on users.wallet_id = wallets.wallet_id " +
            " SET role_id = ?,balance = ? WHERE user_id = ?";
    private static final String UPDATE_IS_APPROVED = "UPDATE users SET is_approved = 1 WHERE login = ?";
    private static final String UPDATE_PASSWORD = "UPDATE users SET password = ? WHERE login = ?";


    private UserDaoImpl() {
    }

    /**
     * Gets instance
     *
     * @return the instance
     */
    public static UserDao getInstance() {
        return instance;
    }

    @Override
    public List<User> findAllUsers() throws DaoException {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL);
             ResultSet resultSet = statement.executeQuery();) {
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
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_EMAIL);) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = Optional.of(createUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding all users", e);
        }
        return user;
    }

    @Override
    public Optional<User> findUserById(int id) throws DaoException {
        Optional<User> user = Optional.empty();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
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
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_LOGIN);) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
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
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_LOGIN);) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = Optional.of(createUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DaoException("Error while authorize user", e);
        }
        return user;
    }

    @Override
    public Optional<String> checkByLogin(String login) throws DaoException {
        Optional<String> password = Optional.empty();
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(CHECK_BY_LOGIN);) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                password = Optional.of(resultSet.getString(ColumnName.PASSWORD));
            }
        } catch (SQLException e) {
            throw new DaoException("Error while finding user: " + login, e);
        }
        return password;
    }

    @Override
    public boolean add(String email, String login, String password, Wallet wallet) throws DaoException {
        boolean isAdded;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD);) {
            statement.setString(1, email);
            statement.setString(2, login);
            statement.setString(3, password);
            statement.setInt(4, wallet.getWalletId());
            statement.executeUpdate();
            isAdded = true;
        } catch (SQLException e) {
            throw new DaoException("Error while creating user: " + login, e);
        }
        return isAdded;
    }

    @Override
    public boolean update(int userId,int roleId,double balance) throws DaoException {
        boolean isChanged;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ROLE_BALANCE);) {
            statement.setInt(1, roleId);
            statement.setDouble(2, balance);
            statement.setInt(3, userId);
            statement.executeUpdate();
            isChanged = true;
        } catch (SQLException e) {
            throw new DaoException("Error while changing role or balance", e);
        }
        return isChanged;
    }

    @Override
    public boolean confirmEmail(String login) throws DaoException {
        boolean isConfirmed;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_IS_APPROVED);) {
            statement.setString(1, login);
            statement.executeUpdate();
            isConfirmed = true;
        } catch (SQLException e) {
            throw new DaoException("Error while confirming email: " + login, e);
        }
        return isConfirmed;
    }

    @Override
    public boolean changePassword(String newPassword, String login) throws DaoException {
        boolean isChanged;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PASSWORD);) {
            statement.setString(1, newPassword);
            statement.setString(2, login);
            statement.executeUpdate();
            isChanged = true;
        } catch (SQLException e) {
            throw new DaoException("Error while changing password", e);
        }
        return isChanged;
    }

    private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        int id = resultSet.getInt(ColumnName.USER_ID);
        String login = resultSet.getString(ColumnName.LOGIN);
        String email = resultSet.getString(ColumnName.EMAIL);
        String password = resultSet.getString(ColumnName.PASSWORD);
        int amountOfBets = resultSet.getInt(ColumnName.AMOUNT_OF_BETS);
        boolean isApproved = resultSet.getBoolean(ColumnName.IS_APPROVED);
        String role_name = resultSet.getString(ColumnName.ROLE_NAME);
        int wallet_id = resultSet.getInt(ColumnName.WALLET_ID);
        double balance = resultSet.getDouble(ColumnName.BALANCE);
        user.setUserId(id);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setAmountOfBets(amountOfBets);
        user.setIsApproved(isApproved);
        user.setRole(UserRole.valueOf(role_name.toUpperCase()));
        user.setWallet(new Wallet(wallet_id, balance));
        return user;
    }
}
