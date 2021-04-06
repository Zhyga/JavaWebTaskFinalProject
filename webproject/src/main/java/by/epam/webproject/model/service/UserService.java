package by.epam.webproject.model.service;

import by.epam.webproject.model.entity.User;
import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;

import java.util.List;

public interface UserService {
     List<User> findAllUsers() throws ServiceException;
     User findUsersByEmail(String email) throws ServiceException;
     User authorizeUser(String login, String password) throws ServiceException;
     boolean createUser(String email, String login, String password) throws ServiceException;
}
