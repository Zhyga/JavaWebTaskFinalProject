package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ToMainPageCommand implements Command {
    private static final String EN_LOCALE = "en_US";
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("currentLocale",EN_LOCALE);
        return PagePath.MAIN;
    }
}
