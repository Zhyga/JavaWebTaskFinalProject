package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Race;
import by.epam.webproject.model.service.BetService;
import by.epam.webproject.model.service.impl.BetServiceImpl;
import by.epam.webproject.model.validator.CardValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddOddCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final BetService betService = new BetServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String betOdd = request.getParameter(RequestParameter.BET_ODD);
        if (!betOdd.matches("^([1-9]|[1-9]\\.[1-9]{1,2})$")) {
            logger.error("Bet odd is not correct");
        } else {
            HttpSession session = request.getSession();
            Race race = (Race) session.getAttribute(SessionAttribute.CURRENT_RACE);
            int raceId = race.getRaceId();
            try {
                betService.addBet(betOdd, raceId);
            } catch (ServiceException e) {
                logger.error("Error while setting odd", e);
            }
        }
        return PagePath.RACE;
    }
}
