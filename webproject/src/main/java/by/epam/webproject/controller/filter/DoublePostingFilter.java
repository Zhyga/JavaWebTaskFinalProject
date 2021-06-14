package by.epam.webproject.controller.filter;

import by.epam.webproject.controller.PagePath;
import by.epam.webproject.controller.RequestParameter;
import by.epam.webproject.controller.SessionAttribute;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/controller"})
public class DoublePostingFilter implements Filter {
    private static final String TO_MAIN_COMMAND = "to_main";
    private String commandHashCode = TO_MAIN_COMMAND;

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
        if(commandHashCode != null && commandHashCode.equals(commandName)){
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
        }else{
            commandHashCode = commandName;
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
