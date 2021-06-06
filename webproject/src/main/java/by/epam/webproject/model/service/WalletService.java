package by.epam.webproject.model.service;

import by.epam.webproject.exception.ServiceException;

/**
 * The {@code WalletService} interface represents wallet service
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface WalletService {
    /**
     *
     * @param walletId the wallet id
     * @param newBalance the new wallet balance
     * @return the boolean
     * @throws ServiceException the service exception
     */
    boolean changeBalance(int walletId, double newBalance) throws ServiceException;
}
