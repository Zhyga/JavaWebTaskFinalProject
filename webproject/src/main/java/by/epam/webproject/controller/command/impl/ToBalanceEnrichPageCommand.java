package by.epam.webproject.controller.command.impl;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * The {@code ToBalanceEnrichPageCommand} class represents to balance enrich page command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class ToBalanceEnrichPageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.DEPOSIT;
    }
}
