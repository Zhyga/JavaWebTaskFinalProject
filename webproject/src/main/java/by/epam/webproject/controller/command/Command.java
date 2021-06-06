package by.epam.webproject.controller.command;

import javax.servlet.http.HttpServletRequest;

/**
 * The {@code Command} interface represents command
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public interface Command {
    /**
     * Execute command
     *
     * @param request the request
     * @return the string containing the path
     */
    String execute(HttpServletRequest request);
}
