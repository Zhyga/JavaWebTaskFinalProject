package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Bet;
import by.epam.webproject.model.entity.Race;
import by.epam.webproject.model.service.impl.BetServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public class ToBetPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private final BetServiceImpl betService = new BetServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String raceString = request.getParameter(RequestParameter.RACE_ID);
        int raceId = Integer.parseInt(raceString);
        HttpSession session = request.getSession();
        List<Race> raceList = (List<Race>) session.getAttribute(SessionAttribute.RACE_LIST);
        Optional<Race> raceOptional = raceList.stream().filter(t -> t.getRaceId() == raceId).findAny();
        if (raceOptional.isPresent()) {
            try {
                Race race = raceOptional.get();
                session.setAttribute(SessionAttribute.CURRENT_RACE,race);
                List<Bet> bets = betService.findAllRaceBets(raceId);
                request.setAttribute(RequestAttribute.RACE_BETS,bets);
                request.setAttribute(RequestAttribute.RACE_PARTICIPANTS,race.getRaceData().getParticipantsId());
                request.setAttribute(RequestAttribute.RACE_DETAILS,race.getDetails());
                request.setAttribute(RequestAttribute.RACE_ROUNDS,race.getRounds());
                request.setAttribute(RequestAttribute.RACE_TIME,race.getRaceData().getDate());
                request.setAttribute(RequestAttribute.RACE_TITLE,race.getTitle());
                page = PagePath.RACE;
            } catch (ServiceException e) {
                logger.error("Error while loading race page", e);
                page = PagePath.MAIN;
            }
        }
        else {
            page = PagePath.HOME;
        }
        return page;
    }
}
