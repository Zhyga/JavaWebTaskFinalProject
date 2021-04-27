package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.exception.ServiceException;
import by.epam.webproject.model.service.WalletService;
import by.epam.webproject.model.service.impl.WalletServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangeBalanceCommand implements Command {
    private final WalletService walletService = new WalletServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String newBalance = request.getParameter("newBalanceValue");
        double balance = Double.parseDouble(newBalance);
        try {
            if(walletService.changeBalance(1,balance)) {
                HttpSession session = request.getSession();
                session.setAttribute(SessionAttribute.BALANCE,balance);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return PagePath.ADMIN_USERS;
    }
}
