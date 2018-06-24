package com.wonne.web.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.wonne.web.database.*;
import com.wonne.web.login.*;

import static com.wonne.web.register.RegisterItem.*;
import static com.wonne.web.util.WonneUtil.*;


@WebServlet(name = "LoginServlet", description = "Servlet to handle user login", urlPatterns = {"/LoginServlet"})
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
            handleError( DB_SERVICE_ERROR, request, response );
            return;
        }
        
        handleLogin( service, request, response );
                        
    }
     


    protected final void handleLogin( DBService service, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        
        String email        = request.getParameter( EMAIL.getIName( ) );
        String password     = request.getParameter( PASSWORD.getIName( ));
        LoginBean loginBean = service.getUserUsingEmailCheckPassword( email, password );
        if( loginBean == null ){
            handleError( LOGIN_ERR_MSGE, request, response );
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
        handleSuccess( loginBean, request, response );
        
    }
    
    

    protected final void handleSuccess( LoginBean bean, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getSession( ).setAttribute( LOGIN_BEAN_TAG, bean );
        response.sendRedirect( request.getContextPath() + LOGIN_PAGE );
    }
    
    
    protected final void handleError( String errorReason, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute( LOGIN_BEAN_TAG, LoginBean.createError(errorReason) );
        request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
    }
    
    
}
