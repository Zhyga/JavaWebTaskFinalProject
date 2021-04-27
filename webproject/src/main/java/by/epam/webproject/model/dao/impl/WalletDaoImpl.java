package by.epam.webproject.model.dao.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.dao.ColumnName;
import by.epam.webproject.model.dao.UserDao;
import by.epam.webproject.model.dao.WalletDao;
import by.epam.webproject.model.entity.Wallet;
import by.epam.webproject.model.pool.ConnectionPool;

import java.sql.*;
import java.util.Optional;

public class WalletDaoImpl implements WalletDao {
    private static final WalletDaoImpl instance = new WalletDaoImpl();
    private static final String ADD = "INSERT INTO wallets (balance) VALUES (0)";
    private static final String UPDATE = "UPDATE wallets SET balance = ? WHERE wallet_id = ?";
    private static final String FIND_BY_ID = "SELECT wallet_id,balance FROM wallets WHERE wallet_id LIKE ?";

    private WalletDaoImpl() {
    }

    public static WalletDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean add(Wallet wallet) throws DaoException {
        boolean isAdded;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD, Statement.RETURN_GENERATED_KEYS);) {
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                wallet.setWalletId(generatedKeys.getInt(1));
            }
            isAdded = true;
        } catch (SQLException e) {
            throw new DaoException("Error while creating user wallet", e);
        }
        return isAdded;
    }

    @Override
    public boolean update(Wallet wallet) throws DaoException {
        boolean isAdded;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE);) {
            statement.setDouble(1, wallet.getBalance());
            statement.setInt(2, wallet.getWalletId());
            statement.executeUpdate();
            isAdded = true;
        } catch (SQLException e) {
            throw new DaoException("Error while changing user balance", e);
        }
        return isAdded;
    }

    @Override
    public Optional<Wallet> findById(int walletId) throws DaoException {
        Optional<Wallet> walletOptional;
        try (Connection connection = ConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);) {
            statement.setInt(1, walletId);
            ResultSet resultSet = statement.executeQuery();
            Wallet wallet = new Wallet(null,0);
            if (resultSet.next()) {
                wallet.setWalletId(resultSet.getInt(ColumnName.WALLET_ID));
                wallet.setBalance(resultSet.getDouble(ColumnName.BALANCE));
            }
            walletOptional = Optional.of(wallet);
        } catch (SQLException e) {
            throw new DaoException("Error while finding wallet", e);
        }
        return walletOptional;
    }
}
