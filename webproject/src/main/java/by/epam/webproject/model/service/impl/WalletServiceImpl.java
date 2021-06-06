package by.epam.webproject.model.service.impl;

import by.epam.webproject.exception.DaoException;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.dao.WalletDao;
import by.epam.webproject.model.dao.impl.WalletDaoImpl;
import by.epam.webproject.model.entity.Wallet;
import by.epam.webproject.model.service.WalletService;

import java.util.Optional;

/**
 * The {@code WalletServiceImpl} class represents wallet service implementation
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class WalletServiceImpl implements WalletService {
    private final WalletDao walletDao = WalletDaoImpl.getInstance();

    @Override
    public boolean changeBalance(int walletId, double newBalance) throws ServiceException {
        boolean isChanged = false;
        try {
            Optional<Wallet> walletOptional;
            walletOptional = walletDao.findById(walletId);
            if(walletOptional.isPresent()){
                Wallet wallet = walletOptional.get();
                wallet.setBalance(newBalance);
                walletDao.update(wallet);
                isChanged = true;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return isChanged;
    }
}
