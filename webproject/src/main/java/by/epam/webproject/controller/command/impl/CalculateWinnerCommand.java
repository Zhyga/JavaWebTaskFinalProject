package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.entity.Bet;
import by.epam.webproject.model.entity.BetInfo;
import by.epam.webproject.model.entity.User;
import by.epam.webproject.model.service.*;
import by.epam.webproject.model.service.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * The {@code CalculateWinnerCommand} class represents calculate winner command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class CalculateWinnerCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final BetInfoService betInfoService = new BetInfoServiceImpl();
    private static final WalletService walletService = new WalletServiceImpl();
    private static final UserService userService = new UserServiceImpl();
    private static final BetService betService = new BetServiceImpl();
    private static final String STATUS_WIN = "Win";
    private static final String STATUS_LOST = "Lost";

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.BOOKMAKER_RACES;
        String raceIdString = request.getParameter(RequestParameter.RACE_ID);
        int raceId = Integer.parseInt(raceIdString);//fixme
        try {
            List<Bet> betsList = betService.findAllRaceBets(raceId);
            Random rand = new Random();
            Bet winnerBet = betsList.get(rand.nextInt(betsList.size()));
            int winner = winnerBet.getBetId();
            if(betInfoService.updateBetInfo(winner,STATUS_WIN)){
                betsList.remove(winnerBet);
                List<BetInfo> betInfos = betInfoService.findAllBetsInfo(winner);
                for(BetInfo betInfo : betInfos){
                    Optional<User> userOptional = userService.findUserById(betInfo.getUserId());
                    if(userOptional.isPresent()){
                        walletService.changeBalance(userOptional.get().getWallet().getWalletId(),
                                userOptional.get().getWallet().getBalance()+betInfo.getPrize());
                    }
                }
                for(Bet bet : betsList){
                    List<BetInfo> betInfos2 = betInfoService.findAllBetsInfo(bet.getBetId());
                    for(BetInfo betInfo : betInfos2){
                        Optional<User> userOptional = userService.findUserById(betInfo.getUserId());
                        if(userOptional.isPresent()){
                            betInfoService.updateBetInfo(bet.getBetId(),STATUS_LOST);
                        }
                    }
                }
                page = PagePath.BOOKMAKER_RACES;
            }
        } catch (ServiceException e) {
            logger.error("Error in CalculateWinnerCommand", e);
            page = PagePath.BOOKMAKER_RACES;
        }
        return page;
    }
}
