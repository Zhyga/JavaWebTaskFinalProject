package by.epam.webproject.model.service.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.dao.CardDao;
import by.epam.webproject.model.dao.impl.CardDaoImpl;
import by.epam.webproject.model.service.CardService;
import by.epam.webproject.model.validator.CardValidator;

public class CardServiceImpl implements CardService {
    private final CardDao cardDao = CardDaoImpl.getInstance();

    @Override
    public boolean isCardFinded(String cardNumber, double balance) throws ServiceException {
        boolean isFinded = false;
        try {
            if(CardValidator.isCardNumberCorrect(cardNumber) && CardValidator.isAmountCorrect(String.valueOf(balance))) {
                if(cardDao.findByCardNumber(cardNumber,balance)) {
                    isFinded = true;
                }
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isFinded;
    }

    @Override
    public boolean update(String cardNumber, double balance) throws ServiceException {
        boolean isUpdated;
        try {
            cardDao.update(cardNumber,balance);
            isUpdated = true;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isUpdated;
    }
}
