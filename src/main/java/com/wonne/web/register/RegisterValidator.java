package com.wonne.web.register;

import java.util.regex.*;
import javax.mail.internet.*;

import com.wonne.web.core.*;

import static com.wonne.web.util.WonneUtil.*;
import static com.wonne.web.core.ValidationResult.*;
import static com.wonne.web.register.RegisterItem.*;


public final class RegisterValidator{

    private final static String ZIP_REGEX           = "[0-9]+";
    private final static String PHONE_REGEX         = "[0-9]+";
    private final static Pattern _1_LETTER          = Pattern.compile( "[0-9]" );
    private final static String FULLNAME_ERR_MSG    = "Full name must be greater than " + FULL_NAME.getMinLength( ) + " letters.";
    private final static String PASSWORD_ERR_MSG    = "Password must be at least " + PASSWORD.getMinLength( ) + " letters, must contain at least one number & one uppercase letter.";
    
    
    public final static ValidationResult validate( RegisterBean bean ){
        
        StringBuilder error = new StringBuilder( 64 );
        
        if( bean == null ){
            return createInvalid( "Internal Error! Please try again later!" );
        }
                
        
        if( !isFullNameValid( bean.getFullName( )) ){
            error.append( FULLNAME_ERR_MSG ).append( JSP_NEWLINE );                       
        }
        
        
        if( !isValidEmail( bean.getEmail()) ){
            error.append( "Email address is Invalid!" ).append( JSP_NEWLINE ); 
        }
        
        //Must be at least 8 characters and must contain at least one number & one uppercase letter
        if( !isValidPassword( bean.getPassword()) ){
            error.append( PASSWORD_ERR_MSG ).append( JSP_NEWLINE );
        }
        
        
        if( !bean.getPassword().equals( bean.getRepassword( )) ){
            error.append( "Passwords do not match!" ).append( JSP_NEWLINE );            
        }
        
        
        if( !isValid(bean.getCompanyName()) ){
            error.append( "Company name is invalid!").append( JSP_NEWLINE );
        }
         
                
        if( !isValidPhoneNumnber(bean.getPhone()) ){
            error.append( "Phone number is invalid!").append( JSP_NEWLINE );
        }
         
                
        if( !isValid(bean.getAddress()) ){
            error.append( "Address is invalid!").append( JSP_NEWLINE );
        }

        
        if( !isValid(bean.getCity()) ){
            error.append( "City is invalid!").append( JSP_NEWLINE );
        }        
        
        
        if( !isValid(bean.getState()) ){
            error.append( "State is invalid!").append( JSP_NEWLINE );      
        }
        
        
        if( !isValidZip(bean.getZip()) ){
            error.append( "Zipcode is invalid!").append( JSP_NEWLINE );            
        }
                
        if( !isValid(bean.getOrganization()) ){
            error.append( "Organization must be selected!").append( JSP_NEWLINE );
        }
        
        if( !isValid(bean.getRole()) ){
            error.append( "Role must be selected!").append( JSP_NEWLINE );            
        }
        
        ValidationResult result     = ( error.length( ) == 0 ) ? createValid( ) : createInvalid(  error.toString( ) );
        return result;
    
    }
    
    
    protected final static boolean isFullNameValid( String fullName ) {
        return( isValid(fullName) && fullName.trim( ).length( ) > FULL_NAME.getMinLength( ) );
    }


    protected final static boolean isValidZip( String zip ) {
        return ( isValid(zip) && zip.matches(ZIP_REGEX) && zip.length() == ZIPCODE.getMinLength( ) );        
    }

    
    protected final static boolean isValidPhoneNumnber( String phone ) {
        if ( !isValid(phone) ) return false;
        
        phone = phone.replaceAll( "-", "" ).trim( );
        return (phone.matches(PHONE_REGEX) && phone.length() == PHONE.getMinLength( ) );
        
    }

    protected final static boolean isValidPassword( String password ) {
        
        if ( !isValid(password) ) return false;
        if( password.length( ) < PASSWORD.getMinLength( ) ) return false;

        //Doesn't have at least 1 Upper case letter
        if( password.equals(password.toLowerCase()) ) return false;
        
        //Doesn't have at least 1 number
        if( !_1_LETTER.matcher( password ).find() ) return false;
        
        return true;
    }


    protected final static boolean isValidEmail( String email ){
        
        if ( !isValid(email) ) return false;
                
        boolean result = true;
        try{
            
            new InternetAddress( email );
            if( !hasNameAndDomain(email) ){
                result = false;
            }
        
        }catch( AddressException ex ){
          result = false;
        }
        
        return result;
      
    }
    

    private final static boolean hasNameAndDomain( String email ){
        String[] tokens = email.split("@");
        return tokens.length == 2 && isValid(tokens[0]) && isValid(tokens[1]);      
    }
    
}
