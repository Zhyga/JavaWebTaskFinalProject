package by.epam.webproject.controller.filter;

import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.SessionAttribute;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/controller"})
public class DoublePostingFilter implements Filter {
    private static String commandHashCode = "to_main";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String page = (String) session.getAttribute(SessionAttribute.CURRENT_PAGE);
        String commandName = req.getParameter(RequestParameter.COMMAND);
        if(commandHashCode.equals(commandName)){
            resp.sendRedirect(page);
            return;
        }else{
            commandHashCode = commandName;
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
