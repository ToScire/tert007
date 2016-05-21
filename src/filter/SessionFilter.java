package filter;

import controller.PageHelper;
import controller.PageName;
import entity.user.User;
import entity.user.UserType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 07.05.2016.
 */

@WebFilter(
        servletNames = "Controller",
        urlPatterns =  "*.jsp" ,
        initParams = {
                @WebInitParam(name = "INDEX_PATH", value = "/Controller?command=get_today_seances")
        }
)
public class SessionFilter implements Filter {

    private List<String> adminPages;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        adminPages = new ArrayList<>();
        adminPages.add(PageHelper.getPage(PageName.SEANCES_PAGE));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String url = httpRequest.getServletPath();

        HttpSession session = httpRequest.getSession();

        UserType userType = (UserType) session.getAttribute("userType");
        if (userType == null){
            userType = UserType.GUEST;
        }

        if (userType == UserType.GUEST) {
            if (adminPages.contains(url)){
                RequestDispatcher dispatcher = httpRequest.getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(httpRequest, httpResponse);
            }
        }

        if (userType == UserType.USER){

            if (adminPages.contains(url)) {
                RequestDispatcher dispatcher = httpRequest.getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(httpRequest, httpResponse);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
