package by.epam.webproject.controller;

import by.epam.webproject.controller.command.Command;
import by.epam.webproject.controller.command.CommandProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * The {@code Controller} class represents controller
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
public class Controller extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter(RequestParameter.COMMAND);
        Command command = CommandProvider.defineCommand(commandName);
        String page = command.execute(req);
        HttpSession session = req.getSession();
        session.setAttribute(SessionAttribute.CURRENT_PAGE,page);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }
}