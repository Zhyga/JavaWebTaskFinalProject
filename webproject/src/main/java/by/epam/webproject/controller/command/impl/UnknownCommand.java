package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * The {@code UnknownCommand} class represents unknown command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class UnknownCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.HOME;
        return page;
    }
}
