package by.epam.webproject.model.service.impl;

import by.epam.webproject.model.dao.UserDao;
import by.epam.webproject.model.dao.WalletDao;
import by.epam.webproject.model.dao.impl.UserDaoImpl;
import by.epam.webproject.model.dao.impl.WalletDaoImpl;
import by.epam.webproject.model.entity.User;
import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Wallet;
import by.epam.webproject.model.service.UserService;
import by.epam.webproject.model.validator.UserValidator;
import by.epam.webproject.util.PasswordEncryptor;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = UserDaoImpl.getInstance();
    private final WalletDao walletDao = WalletDaoImpl.getInstance();

    public List<User> findAllUsers() throws ServiceException {
        try {
            List<User> users = userDao.findAllUsers();
            return users;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public Optional<User> findUserByEmail(String email) throws ServiceException {
        Optional<User> user;
        try {
            user = userDao.findUserByEmail(email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    public Optional<User> findUserByLogin(String email) throws ServiceException {
        Optional<User> user;
        try {
            user = userDao.findUserByLogin(email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    public Optional<User> authorizeUser(String login, String password) throws ServiceException {
        Optional<User> user = Optional.empty();
        try {
            if (UserValidator.isLoginCorrect(login) && UserValidator.isPasswordCorrect(password)) {
                Optional<String> userPasswordO = userDao.checkByLogin(login);
                if (userPasswordO.isPresent()) {
                    String userPassword = userPasswordO.get();
                    Optional<String> encPassword = PasswordEncryptor.encryptPassword(password);
                    if (encPassword.isPresent()) {
                        if (userPassword.equals(encPassword.get())) {
                            user = userDao.authorize(login);
                        }
                    }
                }
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    public boolean changeRole(String role, String login) throws ServiceException {//todo test
        boolean isRoleChanged;
        int roleId;
        switch (role) {
            case "bookmaker" -> roleId = 2;
            case "admin" -> roleId = 3;
            default -> roleId = 1;
        }
        try {
            isRoleChanged = userDao.changeRole(roleId,login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isRoleChanged;
    }

    @Override
    public boolean confirmEmail(String login) throws ServiceException {
        boolean isConfirmed = false;
        try {
            if(UserValidator.isLoginCorrect(login)) {
                userDao.confirmEmail(login);
                isConfirmed = true;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isConfirmed;
    }

    public boolean createUser(String email, String login, String password) throws ServiceException {
        boolean isUserCreated = false;
        try {
            if (UserValidator.isLoginCorrect(login) && UserValidator.isPasswordCorrect(password)
                    && UserValidator.isEmailCorrect(email)) {
                Optional<User> existingLogin = userDao.findUserByLogin(login);
                Optional<User> existingEmail = userDao.findUserByEmail(email);
                if (existingLogin.isPresent() || existingEmail.isPresent()) {
                    return isUserCreated;
                }
                Optional<String> encPassword = PasswordEncryptor.encryptPassword(password);
                if (encPassword.isPresent()) {
                    Wallet wallet = new Wallet();
                    walletDao.add(wallet);
                    isUserCreated = userDao.add(email, login, encPassword.get(),wallet);
                }
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isUserCreated;
    }
}