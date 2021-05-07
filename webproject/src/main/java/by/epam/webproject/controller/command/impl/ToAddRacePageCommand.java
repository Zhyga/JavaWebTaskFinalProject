package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class ToAddRacePageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.ADD_RACES;
    }
}