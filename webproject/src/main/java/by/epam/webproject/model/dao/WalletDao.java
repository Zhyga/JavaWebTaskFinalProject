package by.epam.webproject.model.dao;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.Wallet;

import java.util.Optional;

/**
 * The {@code WalletDao} interface represents wallet dao
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface WalletDao {
    /**
     * Create wallet
     *
     * @param wallet the wallet
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean add(Wallet wallet) throws DaoException;

    /**
     * Update wallet balance
     *
     * @param wallet the wallet
     * @return the boolean
     * @throws DaoException  the dao exception
     */
    boolean update(Wallet wallet) throws DaoException;

    /**
     * Find wallet by id
     *
     * @param walletId the wallet id
     * @return the optional of found wallet
     * @throws DaoException  the dao exception
     */
    Optional<Wallet> findById(int walletId) throws DaoException;
}
