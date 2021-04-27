package by.epam.webproject.model.service;

import by.epam.webproject.exception.ServiceException;

public interface WalletService {
    boolean changeBalance(int walletId, double newBalance) throws ServiceException;
}
