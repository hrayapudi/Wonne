package com.wonne.web.register;

import static com.wonne.web.util.WonneUtil.*;

import org.slf4j.*;

import com.wonne.web.database.*;

import static com.wonne.web.register.ValidationResult.*;


public final class RegisterValidation{

    private final static String NAME    = RegisterValidation.class.getSimpleName( );
    private final static Logger LOGGER  = LoggerFactory.getLogger( NAME );
    
    
    public final static ValidationResult validate( RegisterBean bean ){
        
        if( bean == null ){
            return createInvalid( "Internal Error! Failed to extract properties from form inputs." );
        }
        
        
        if( bean.getFullName() == null || bean.getFullName().trim( ).length( ) < 3 ){
            return createInvalid( "Full name can't be less than 3 letters!" );            
        }
        
        //Check Email address
        
        
        if( !isValid(bean.getPassword()) ){
            request.setAttribute("error", "Password is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        if( !bean.getPassword().equals(bean.getRepassword()) ){
            request.setAttribute("error", "Passwords do not match!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getCompanyName()) ){
            request.setAttribute("error", "Company name is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
                
        if( !isValid(bean.getPhone()) ){
            request.setAttribute("error", "Phone number is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
                
        if( !isValid(bean.getAddress()) ){
            request.setAttribute("error", "Address is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }

        if( !isValid(bean.getCity()) ){
            request.setAttribute("error", "City is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        
        if( !isValid(bean.getState()) ){
            request.setAttribute("error", "State is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        
        if( !isValid(bean.getZip()) ){
            request.setAttribute("error", "Zipcode is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        
        if( !isValid(bean.getOrganization()) ){
            request.setAttribute("error", "Organization selection is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getRole()) ){
            request.setAttribute("error", "Role selection is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        
        return null;
    
    }
    
}
