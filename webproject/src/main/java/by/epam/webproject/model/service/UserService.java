package by.epam.webproject.model.service;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.User;
import by.epam.webproject.exception.ServiceException;

import java.util.List;
import java.util.Optional;

/**
 * The {@code UserService} interface represents user service
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface UserService {
     /**
      * Find all users
      *
      * @return the list of found users
      * @throws ServiceException the service exception
      */
     List<User> findAllUsers() throws ServiceException;

     /**
      * Find user by email
      *
      * @param email the email
      * @return the optional of found user
      * @throws ServiceException the service exception
      */
     Optional<User> findUserByEmail(String email) throws ServiceException;

     /**
      * Find user by login
      *
      * @param login the login
      * @return the optional of found user
      * @throws ServiceException the service exception
      */
     Optional<User> findUserByLogin(String login) throws ServiceException;

     /**
      * Find user by id
      *
      * @param id the id
      * @return the optional of found user
      * @throws ServiceException the service exception
      */
     Optional<User> findUserById(int id) throws ServiceException;

     /**
      * Authorize user
      *
      * @param login the login
      * @param password the password
      * @return the optional of authorized user
      * @throws ServiceException the service exception
      */
     Optional<User> authorizeUser(String login, String password) throws ServiceException;

     /**
      * Change user role & balance
      *
      * @param userId the user id
      * @param roleName the role name
      * @param balance the balance
      * @return the boolean
      * @throws ServiceException the service exception
      */
     boolean update(String userId, String roleName,String balance) throws ServiceException;

     /**
      * Confirm user email
      *
      * @param login the login
      * @return the boolean
      * @throws ServiceException the service exception
      */
     boolean confirmEmail(String login) throws ServiceException;

     /**
      * Add user
      *
      * @param email the email
      * @param login the login
      * @param password the password
      * @return the boolean
      * @throws ServiceException the service exception
      */
     boolean createUser(String email, String login, String password) throws ServiceException;

     /**
      * Change user password
      *
      * @param newPassword the new password
      * @param oldPassword the old password
      * @return the boolean
      * @throws ServiceException the service exception
      */
     boolean changePassword(String oldPassword, String newPassword) throws ServiceException;
}
