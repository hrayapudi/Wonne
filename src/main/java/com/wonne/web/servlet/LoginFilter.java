package com.wonne.web.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import static com.wonne.web.util.WonneUtil.*;


public class LoginFilter implements Filter {
    
    
    @Override
    public void init( FilterConfig filterConfig ) throws ServletException {
        
    }

    
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest request      = (HttpServletRequest) req;
        HttpServletResponse response    = (HttpServletResponse) res;
        HttpSession session             = request.getSession( false );
        boolean userAlreadyLoggedIn     = (session != null && session.getAttribute(LOGIN_BEAN_TAG) !=null );
        
        // User already logged in, so just continue request.
        if( userAlreadyLoggedIn ){
            chain.doFilter(req, res); 
        }else {
            // User NOT logged in, redirect to login page
            response.sendRedirect(request.getContextPath() + LOGIN_PAGE);
        }
        
    }



    @Override
    public void destroy( ) {
        
    }

    
    
}
