package by.epam.webproject.model.dao;

import by.epam.webproject.model.entity.User;
import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.Wallet;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> findAllUsers() throws DaoException;
    Optional<User> findUserByEmail(String email) throws DaoException;
    Optional<User> findUserByLogin(String login) throws DaoException;
    Optional<User> authorize(String login) throws DaoException;
    Optional<String> checkByLogin(String login) throws DaoException;
    boolean add(String email, String login, String password, Wallet wallet) throws DaoException;
    boolean changeRole(int roleId,String login) throws DaoException;
}
