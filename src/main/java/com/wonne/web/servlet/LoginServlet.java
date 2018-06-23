package com.wonne.web.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.wonne.web.database.*;

import static com.wonne.web.register.RegisterItem.*;
import static com.wonne.web.util.WonneUtil.*;


public class LoginServlet extends HttpServlet {
    
    private static final int _10_MINUTES_IN_SECS= 10 * 60;
    private static final long serialVersionUID  = 1L;
    private static final String LOGIN_ERR_MSGE  = "Failed to login! Either the email or password is incorrect.";
    
    @Override
    public void init() throws ServletException {
        super.init();
    }

    
    @Override
    protected final void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        DBService service   = (DBService) getServletContext( ).getAttribute( DB_SERVICE_TAG );
        if( service == null ){
            request.setAttribute( ERR_MSG_TAG, DB_SERVICE_ERROR);
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
            return;
        }
        
        String email        = request.getParameter( EMAIL.getIName( ) );
        String password     = request.getParameter( PASSWORD.getIName( ));
        String fullName     = service.userPasswordMatch( email, password );
        boolean userExists  = isValid( fullName );
        if( !userExists ) {
            request.setAttribute( ERR_MSG_TAG, LOGIN_ERR_MSGE);
            request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
            return;
        }
        
        //get the old session and invalidate
        HttpSession oldSession = request.getSession(false);
        if( oldSession != null ){
            oldSession.invalidate();
        }
        
        //generate a new session
        HttpSession newSession = request.getSession(true);
        newSession.setMaxInactiveInterval( _10_MINUTES_IN_SECS );
        newSession.setAttribute(NAME_SESSION_TAG, fullName);
        response.sendRedirect( request.getContextPath() + LOGIN_PAGE );
        
    }
      
    
}
