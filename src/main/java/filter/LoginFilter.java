package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rakib
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
        HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession(false);
    boolean loggedIn = (session != null) ? session.getAttribute("user") != null : false;
    String loginURL = request.getContextPath() + "/loginForm.xhtml"; 

    if (!loggedIn && !request.getRequestURI().equals(loginURL)) {       
        response.sendRedirect(loginURL);
    } else {
        chain.doFilter(request, response);
    }
    }

    @Override
    public void destroy() {
        
    }

}