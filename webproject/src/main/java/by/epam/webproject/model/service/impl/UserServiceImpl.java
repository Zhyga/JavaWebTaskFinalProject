package by.epam.webproject.model.service.impl;

import by.epam.webproject.model.dao.UserDao;
import by.epam.webproject.model.dao.impl.UserDaoImpl;
import by.epam.webproject.model.entity.User;
import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.service.UserService;
import by.epam.webproject.model.validator.UserValidator;
import by.epam.webproject.util.PasswordEncryptor;


import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = UserDaoImpl.getInstance();

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

    public Optional<User> authorizeUser(String login, String password) throws ServiceException {
        Optional<User> user = Optional.empty();
        try {
            if (UserValidator.isLoginCorrect(login) && UserValidator.isPasswordCorrect(password)) {
                String userPassword = userDao.checkByLogin(login);
                String encPassword = PasswordEncryptor.encryptPassword(password);
                if (encPassword.equals(userPassword)) {
                    user = userDao.authorize(login);
                }
            }
        } catch (DaoException | NoSuchAlgorithmException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    public boolean createUser(String email, String login, String password) throws ServiceException{
        boolean isUserCreated = false;
        try{
            if(UserValidator.isLoginCorrect(login) && UserValidator.isPasswordCorrect(password)
            && UserValidator.isEmailCorrect(email)){
                Optional<User> existingLogin = userDao.findUserByLogin(login);
                Optional<User> existingEmail = userDao.findUserByEmail(email);
                if(existingLogin.isPresent() || existingEmail.isPresent()){
                    return  isUserCreated;
                }
                String encPassword = PasswordEncryptor.encryptPassword(password);
                isUserCreated = userDao.add(email,login,encPassword);
            }
        } catch (NoSuchAlgorithmException | DaoException e) {
            throw new ServiceException(e);
        }
        return isUserCreated;
    }
}