package by.epam.webproject.model.dao;

import by.epam.webproject.model.entity.User;
import by.epam.webproject.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> findAllUsers() throws DaoException;
    Optional<User> findUserByEmail(String email) throws DaoException;
    Optional<User> findUserByLogin(String login) throws DaoException;
    Optional<User> authorize(String login) throws DaoException;
    String checkByLogin(String login) throws DaoException;
    boolean add(String email,String login,String password) throws DaoException;
}
