package com.wonne.web.servlet;

import java.io.*;
import org.slf4j.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.wonne.web.database.*;
import com.wonne.web.register.*;

import static com.wonne.web.util.WonneUtil.*;
import static com.wonne.web.register.RegisterItem.*;


public class RegisterServlet extends HttpServlet {
    
    private static final long serialVersionUID  = 1L;
    private static final String FORM_ERR_PAGE   = "/register.jsp";
    private static final String FORM_VALID_PAGE = "/RegistrationSuccess.html";
    private static final String DUP_USER_MSG    = " is already registered! Please login.";
    private final static String NAME            = RegisterServlet.class.getSimpleName( );
    private final static Logger LOGGER          = LoggerFactory.getLogger( NAME );
    
    
    @Override
    public void init() throws ServletException {
        super.init();
    }
    

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    
        RegisterBean bean       = parseInput( request );
        ValidationResult result = RegisterValidator.validate( bean );
        if( !result.isValid( ) ){
            request.setAttribute( ERR_MSG_TAG, result.getReason( ));
            request.getRequestDispatcher(FORM_ERR_PAGE).forward(request, response);
            return;
        }
                
        DBService service       = (DBService) getServletContext( ).getAttribute( DB_SERVICE_TAG );
        if( service == null ){
            request.setAttribute( ERR_MSG_TAG, DB_SERVICE_ERROR);
            request.getRequestDispatcher(FORM_ERR_PAGE).forward(request, response);
            return;
        }
        
        String email            = bean.getEmail( );
        boolean alreadyExists   = service.userExists( email );
        if( alreadyExists ){
            request.setAttribute( ERR_MSG_TAG, email + DUP_USER_MSG);
            request.getRequestDispatcher(FORM_ERR_PAGE).forward(request, response);
            return;
        }
        
        boolean isRegistered    = service.register(bean);
        if( !isRegistered ){
            request.setAttribute( ERR_MSG_TAG, result.getReason( ));
            request.getRequestDispatcher(FORM_ERR_PAGE).forward(request, response);
            return;
        }
        
        response.sendRedirect( FORM_VALID_PAGE );
            
    }
        
   
    protected final RegisterBean parseInput( HttpServletRequest request ){
        
        RegisterBean bean       = null;
    
        try{
        
            String fullName     = request.getParameter( FULL_NAME.getIName( ) );
            String email        = request.getParameter( EMAIL.getIName( ) );
            String password     = request.getParameter( PASSWORD.getIName( ));
            String repassword   = request.getParameter( REPASSWORD.getIName( ));
            String company      = request.getParameter( COMPANY.getIName( ) );
            String phone        = request.getParameter( PHONE.getIName( ));
            String address      = request.getParameter( ADDRESS.getIName( ));
            String city         = request.getParameter( CITY.getIName( ) );
            String state        = request.getParameter( STATE.getIName( ) );
            String zipcode      = request.getParameter( ZIPCODE.getIName( ) );
            
            String organization = request.getParameter( ORGANIZATION.getIName( ) );
            String role         = request.getParameter( ROLE.getIName( ) );
     
            bean                = new RegisterBean(fullName, email, password, repassword, company, phone, address, city, state, zipcode, organization, role );
            
        }catch( Exception e ){
            LOGGER.warn( "FAILED to parse input parameters", e );            
        }
        
        return bean;
    }

    
}
