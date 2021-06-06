package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Bet;
import by.epam.webproject.model.entity.Race;
import by.epam.webproject.model.entity.User;
import by.epam.webproject.model.service.BetInfoService;
import by.epam.webproject.model.service.BetService;
import by.epam.webproject.model.service.UserService;
import by.epam.webproject.model.service.WalletService;
import by.epam.webproject.model.service.impl.BetInfoServiceImpl;
import by.epam.webproject.model.service.impl.BetServiceImpl;
import by.epam.webproject.model.service.impl.UserServiceImpl;
import by.epam.webproject.model.service.impl.WalletServiceImpl;
import by.epam.webproject.model.validator.CardValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * The {@code PlaceBetCommand} class represents place bet command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class PlaceBetCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private final UserService userService = new UserServiceImpl();
    private final BetService betService = new BetServiceImpl();
    private final WalletService walletService = new WalletServiceImpl();
    private final BetInfoService betInfoService = new BetInfoServiceImpl();


    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        String stringBetSize = request.getParameter(RequestParameter.BET_SIZE);
        String stringBetId = request.getParameter(RequestParameter.BET_ID);
        if (!CardValidator.isAmountCorrect(stringBetSize) && !stringBetId.matches("\\d")) {//fixme
            page = (String) session.getAttribute(SessionAttribute.CURRENT_PAGE);
        } else {
            int betId = Integer.parseInt(stringBetId);
            double betSize = Double.parseDouble(stringBetSize);
            double balance = (Double) session.getAttribute(SessionAttribute.BALANCE);
            Race currentRace = (Race) session.getAttribute(SessionAttribute.CURRENT_RACE);
            if (betSize > balance) {
                page = (String) session.getAttribute(SessionAttribute.CURRENT_PAGE);
            } else {
                String login = (String) session.getAttribute(SessionAttribute.LOGIN);
                try {
                    Optional<User> userOptional = userService.findUserByLogin(login);
                    if (userOptional.isPresent()) {
                        User user = userOptional.get();
                        int walletId = user.getWallet().getWalletId();
                        double newBalance = balance - betSize;
                        Optional<Bet> betOptional = betService.findById(betId);
                        if (betOptional.isPresent()) {
                            double multiplier = betOptional.get().getFirstMultiplier();
                            betInfoService.addBetInfo(betSize, multiplier, currentRace.getRaceData().getDate(),
                                    currentRace.getTitle(), user.getUserId(), betId);
                            page = (String) session.getAttribute(SessionAttribute.CURRENT_PAGE);
                            walletService.changeBalance(walletId, newBalance);
                            session.setAttribute(SessionAttribute.BALANCE, newBalance);
                        } else {
                            page = (String) session.getAttribute(SessionAttribute.CURRENT_PAGE);
                        }
                    } else {
                        page = (String) session.getAttribute(SessionAttribute.CURRENT_PAGE);
                    }
                } catch (ServiceException e) {
                    logger.error(e);
                    page = (String) session.getAttribute(SessionAttribute.CURRENT_PAGE);
                }
            }
        }
        return page;
    }
}
