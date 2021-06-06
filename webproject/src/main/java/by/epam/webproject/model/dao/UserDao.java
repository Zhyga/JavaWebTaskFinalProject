package by.epam.webproject.model.dao;

import by.epam.webproject.model.entity.User;
import by.epam.webproject.exception.DaoException;
import by.epam.webproject.model.entity.Wallet;

import java.util.List;
import java.util.Optional;

/**
 * The {@code UserDao} interface represents user dao
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface UserDao {
    /**
     * Find all users
     *
     * @return the list of found users
     * @throws DaoException the dao exception
     */
    List<User> findAllUsers() throws DaoException;

    /**
     * Find user by email
     *
     * @param email the email
     * @return the optional of found user
     * @throws DaoException the dao exception
     */
    Optional<User> findUserByEmail(String email) throws DaoException;

    /**
     * Find user by login
     *
     * @param login the login
     * @return the optional of found user
     * @throws DaoException the dao exception
     */
    Optional<User> findUserByLogin(String login) throws DaoException;

    /**
     * Find user by id
     *
     * @param id the id
     * @return the optional of found user
     * @throws DaoException the dao exception
     */
    Optional<User> findUserById(int id) throws DaoException;

    /**
     * Authorize user
     *
     * @param login the login
     * @return the optional of authorized user
     * @throws DaoException the dao exception
     */
    Optional<User> authorize(String login) throws DaoException;

    /**
     * Check user existing by login
     *
     * @param login the login
     * @return the optional of user password
     * @throws DaoException the dao exception
     */
    Optional<String> checkByLogin(String login) throws DaoException;

    /**
     * Add user
     *
     * @param email the email
     * @param login the login
     * @param password the password
     * @param wallet the wallet
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean add(String email, String login, String password, Wallet wallet) throws DaoException;

    /**
     * Change user role
     *
     * @param roleId the role id
     * @param login the login
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean changeRole(int roleId,String login) throws DaoException;

    /**
     * Confirm user email
     *
     * @param login the login
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean confirmEmail(String login) throws DaoException;

    /**
     * Change user password
     *
     * @param newPassword the new password
     * @param login the login
     * @return the boolean
     * @throws DaoException the dao exception
     */
    boolean changePassword(String newPassword, String login) throws DaoException;
}
