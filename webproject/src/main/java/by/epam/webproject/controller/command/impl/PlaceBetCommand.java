package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Race;
import by.epam.webproject.model.entity.User;
import by.epam.webproject.model.service.BetInfoService;
import by.epam.webproject.model.service.UserService;
import by.epam.webproject.model.service.WalletService;
import by.epam.webproject.model.service.impl.BetInfoServiceImpl;
import by.epam.webproject.model.service.impl.UserServiceImpl;
import by.epam.webproject.model.service.impl.WalletServiceImpl;
import by.epam.webproject.model.validator.CardValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class PlaceBetCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private final UserService userService = new UserServiceImpl();
    private final WalletService walletService = new WalletServiceImpl();
    private final BetInfoService betInfoService = new BetInfoServiceImpl();


    @Override
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        String stringBetSize = request.getParameter(RequestParameter.BET_SIZE);
        double betSize;
        if(!stringBetSize.matches("^[1-9][0-9]{1,6}([.,][0-9]{1,2})?$$")) {
            page = (String) session.getAttribute(SessionAttribute.CURRENT_PAGE);
        }
        else {
            betSize = Double.parseDouble(stringBetSize);
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
                        walletService.changeBalance(walletId, newBalance);
                        session.setAttribute(SessionAttribute.BALANCE, newBalance);
                        double mult = Double.parseDouble(request.getParameter("multiplier"));
                        betInfoService.addBetInfo(betSize, mult, currentRace.getRaceData().getDate(), currentRace.getTitle(), user.getUserId(), 1);
                        page = PagePath.MAIN;
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
