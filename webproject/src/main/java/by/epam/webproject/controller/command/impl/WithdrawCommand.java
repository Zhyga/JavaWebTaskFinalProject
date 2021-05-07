package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.User;
import by.epam.webproject.model.service.CardService;
import by.epam.webproject.model.service.UserService;
import by.epam.webproject.model.service.WalletService;
import by.epam.webproject.model.service.impl.CardServiceImpl;
import by.epam.webproject.model.service.impl.UserServiceImpl;
import by.epam.webproject.model.service.impl.WalletServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class WithdrawCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private final WalletService walletService = new WalletServiceImpl();
    private final CardService cardService = new CardServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {//todo refactor
        HttpSession session = request.getSession();
        String withdraw = request.getParameter(RequestParameter.WITHDRAW_AMOUNT);
        String cardNumber = request.getParameter(RequestParameter.CARD_NUMBER);
        String login = (String) session.getAttribute(SessionAttribute.LOGIN);
        try {
            Optional<User> userOptional = userService.findUserByLogin(login);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                int walletId = user.getWallet().getWalletId();
                double balanceToWithdraw = Double.parseDouble(withdraw);
                if (cardService.isCardFinded(cardNumber,0)) {//todo split in to 2 functions. 1 to find 2 to check balance
                    double currentBalance = (Double) session.getAttribute(SessionAttribute.BALANCE);
                    double newBalance = currentBalance - balanceToWithdraw;
                    if (walletService.changeBalance(walletId, newBalance)) {
                        cardService.update(cardNumber,currentBalance+balanceToWithdraw);
                        session.setAttribute(SessionAttribute.BALANCE, newBalance);
                    }
                }
                else {
                    request.setAttribute(RequestAttribute.CAR_NUMBER_ERROR, "incorrect card number");
                }
            }
        } catch (ServiceException e) {
            logger.error("Error while updating users balance",e);
        }
        return PagePath.MAIN;
    }
}
