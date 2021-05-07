package by.epam.webproject.model.service;

import by.epam.webproject.exception.ServiceException;

public interface CardService {
    boolean isCardFinded(String cardNumber, double balance) throws ServiceException;
    boolean update(String cardNumber, double balance) throws ServiceException;
}
