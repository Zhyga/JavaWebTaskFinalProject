package by.epam.webproject.model.dao;

import by.epam.webproject.exception.DaoException;

public interface CardDao {
    boolean findByCardNumber(String cardNumber,double balance) throws DaoException;
    boolean update(String cardNumber,double balance) throws DaoException;
}
