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
import by.epam.webproject.model.validator.CardValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * The {@code WithdrawCommand} class represents withdraw command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class WithdrawCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private final WalletService walletService = new WalletServiceImpl();
    private final CardService cardService = new CardServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        String withdraw = request.getParameter(RequestParameter.WITHDRAW_AMOUNT);
        if (!CardValidator.isAmountCorrect(withdraw)) {
            request.setAttribute(RequestAttribute.CAR_NUMBER_ERROR, "Incorrect deposit sum");
            page = PagePath.DEPOSIT;
        } else {
            String cardNumber = request.getParameter(RequestParameter.CARD_NUMBER);
            String login = (String) session.getAttribute(SessionAttribute.LOGIN);
            try {
                Optional<User> userOptional = userService.findUserByLogin(login);
                if (userOptional.isEmpty()) {
                    page = PagePath.HOME;
                } else {
                    User user = userOptional.get();
                    int walletId = user.getWallet().getWalletId();
                    double balanceToWithdraw = Double.parseDouble(withdraw);
                    if (cardService.isCardFinded(cardNumber, Integer.MIN_VALUE)) {
                        double currentBalance = (Double) session.getAttribute(SessionAttribute.BALANCE);
                        double newBalance = currentBalance - balanceToWithdraw;
                        if (walletService.changeBalance(walletId, newBalance) &&
                                cardService.update(cardNumber, currentBalance + balanceToWithdraw)) {
                            session.setAttribute(SessionAttribute.BALANCE, newBalance);
                            request.setAttribute(RequestAttribute.CAR_NUMBER_ERROR, "Deposit successfully");
                            page = PagePath.DEPOSIT;
                        } else {
                            request.setAttribute(RequestAttribute.CAR_NUMBER_ERROR, "Error while changing balance");
                            page = PagePath.DEPOSIT;
                        }
                    } else {
                        request.setAttribute(RequestAttribute.CAR_NUMBER_ERROR, "incorrect card number");
                        page = PagePath.DEPOSIT;
                    }
                }
            } catch (ServiceException e) {
                logger.error("Error while updating users balance", e);
                page = PagePath.HOME;
            }
        }
        return page;
    }
}
