package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestAttribute;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.BetInfo;
import by.epam.webproject.model.service.impl.BetInfoServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ToProfilePageCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private final BetInfoServiceImpl betInfoService = new BetInfoServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            List<BetInfo> betInfoList = betInfoService.findAllBetsInfo(String.valueOf(session.getAttribute(SessionAttribute.LOGIN)));
            if(betInfoList.size() == 0){
                request.setAttribute(RequestAttribute.ZERO_BETS, "You placed zero bets");
            }else {
                session.setAttribute(SessionAttribute.BETS_INFO_LIST, betInfoList);
            }
        } catch (ServiceException e) {
            logger.error("Error while finding all bet info",e);
        }
        return PagePath.PROFILE;
    }
}
