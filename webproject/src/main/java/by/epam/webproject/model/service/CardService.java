package by.epam.webproject.model.service;

import by.epam.webproject.exception.ServiceException;

/**
 * The {@code CardService} interface represents card service
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface CardService {
    /**
     * Check if card exist and has enough balance
     *
     * @param cardNumber the card number
     * @param balance the balance
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean isCardFinded(String cardNumber, double balance) throws ServiceException;

    /**
     * Update card balance
     *
     * @param cardNumber the card number
     * @param balance the balance
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean update(String cardNumber, double balance) throws ServiceException;
}
