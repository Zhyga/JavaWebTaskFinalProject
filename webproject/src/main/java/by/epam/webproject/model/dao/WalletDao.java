package by.epam.webproject.model.dao;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.Wallet;

import java.util.Optional;

public interface WalletDao {
    boolean add(Wallet wallet) throws DaoException;
    boolean update(Wallet wallet) throws DaoException;
    Optional<Wallet> findById(int walletId) throws DaoException;
}
