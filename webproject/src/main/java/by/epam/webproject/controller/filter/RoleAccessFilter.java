package by.epam.webproject.controller.filter;

import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.SessionAttribute;
import by.epam.webproject.controller.command.Command;
import by.epam.webproject.controller.command.CommandProvider;
import by.epam.webproject.model.entity.UserRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * The {@code RoleAccessFilter} class represents role access filter
 *
 * @author Alexey Zhyhadlo
 * @version 1.0
 */
@WebFilter(urlPatterns = "/controller")
public class RoleAccessFilter implements Filter {
    private static final Logger logger = LogManager.getLogger();
    private static final int FORBIDDEN_ACCESS_ERROR_NUMBER = 403;

    @Override
    public void init(FilterConfig config) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String commandName = request.getParameter(RequestParameter.COMMAND);
        Command command = CommandProvider.defineCommand(commandName);
        String roleName = (String) session.getAttribute(SessionAttribute.ROLE);
        UserRole userRole;
        if (roleName != null) {
            userRole = UserRole.valueOf(roleName.toUpperCase());
        } else {
            userRole = UserRole.GUEST;
        }
        Set<Command> commands = switch (userRole) {
            case GUEST -> RoleAccess.GUEST.getCommands();
            case USER -> RoleAccess.USER.getCommands();
            case BOOKMAKER -> RoleAccess.BOOKMAKER.getCommands();
            case ADMIN -> RoleAccess.ADMIN.getCommands();
        };
        if (!commands.contains(command)) {
            logger.error("Role {} has no access to {} command", roleName, commandName);
            response.sendError(FORBIDDEN_ACCESS_ERROR_NUMBER);
            return;
        }
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
