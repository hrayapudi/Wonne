package com.wonne.web.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.wonne.web.database.*;
import com.wonne.web.login.*;

import static com.wonne.web.register.RegisterItem.*;
import static com.wonne.web.util.WonneUtil.*;

import org.slf4j.*;


@WebServlet(name = "ForgotServlet", description = "Servlet to handle user password reset", urlPatterns = {"/ForgotServlet"})
public class ForgotServlet extends HttpServlet {
    
    private final static long serialVersionUID          = 1L;
    private final static String INPUT_INVAID_ERR_MSG    = "Error! Input cannot be invalid!";
    private final static String EMAIL_ZIP_NO_MATCH_MSG  = "Error! Email or Zipcode is not recognized!";
    private final static String PASS_NO_MATCH_ERR_MSG   = "Error! Passwords do not match!";
    private final static String UPDATE_FAILED_ERR_MSG   = "Internal Error! Failed to update password!";
    private final static String NAME                    = ForgotServlet.class.getSimpleName( );
    private final static Logger LOGGER                  = LoggerFactory.getLogger( NAME );
    
    
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
        
        handleForgot( service, request, response );
                        
    }
    
    
    protected final void handleForgot( DBService service, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        
        String email        = request.getParameter( EMAIL.getIName( ) );
        String zipcode      = request.getParameter( ZIPCODE.getIName( ) );
        String password     = request.getParameter( PASSWORD.getIName( ));
        String repassword   = request.getParameter( REPASSWORD.getIName( ));
        boolean inputValid  = isValid( email ) && isValid( zipcode ) && isValid( password ) && isValid( repassword );
        if( !inputValid ) {
            handleError( INPUT_INVAID_ERR_MSG, request, response );
            return;
        }
        
        boolean passMatch   = password.equals( repassword );
        if( !passMatch ) {
            handleError( PASS_NO_MATCH_ERR_MSG, request, response );
            return;
        }
        
        LoginBean loginBean = service.getUserUsingEmailZipcode( email, zipcode );
        if( loginBean == null ){
            handleError( EMAIL_ZIP_NO_MATCH_MSG, request, response );
            return;
        }

        //We found the User associated with the email address
        boolean isUpdated   = service.updatePassword( email, password, repassword, zipcode );
        if( !isUpdated ){
            handleError( UPDATE_FAILED_ERR_MSG, request, response );
            return;
        }
        
        String updatedMsg   = "Successfully updated password for " + email;
        LoginBean newBean   = LoginBean.createValid( loginBean.getFullName( ), email, loginBean.getType( ), updatedMsg);
        LOGGER.info( "Successfully updated password for user {}", newBean );
        
        handleSuccess( newBean, request, response );
    }
    
    

    protected final void handleSuccess( LoginBean bean, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute( FORGOT_PASS_BEAN_TAG, bean );
        request.getRequestDispatcher( FORGOT_PASS_PAGE ).forward(request, response);
    }
    
    
    protected final void handleError( String errorReason, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute( FORGOT_PASS_BEAN_TAG, LoginBean.createError(errorReason) );
        request.getRequestDispatcher( FORGOT_PASS_PAGE ).forward(request, response);
    }
        
    
}
