package by.epam.webproject.model.dao;

import by.epam.webproject.exception.DaoException;

/**
 * The {@code CardDao} interface represents card dao
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface CardDao {
    /**
     * Check if card exist and has enough balance
     *
     * @param cardNumber the card number
     * @param balance the balance
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean findByCardNumber(String cardNumber,double balance) throws DaoException;

    /**
     * Update card balance
     *
     * @param cardNumber the card number
     * @param balance the balance
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean update(String cardNumber,double balance) throws DaoException;
}
