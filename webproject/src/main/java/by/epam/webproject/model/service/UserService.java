package by.epam.webproject.model.service;

import by.epam.webproject.model.entity.User;
import by.epam.webproject.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {
     List<User> findAllUsers() throws ServiceException;
     Optional<User> findUserByEmail(String email) throws ServiceException;
     Optional<User> findUserByLogin(String login) throws ServiceException;
     Optional<User> authorizeUser(String login, String password) throws ServiceException;
     boolean changeRole(String role,String login) throws ServiceException;
     boolean confirmEmail(String login) throws ServiceException;
     boolean createUser(String email, String login, String password) throws ServiceException;
}
