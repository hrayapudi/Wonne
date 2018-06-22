package com.wonne.web.register;

import org.slf4j.*;
import java.util.regex.*;
import javax.mail.internet.*;
import com.wonne.web.database.*;

import static com.wonne.web.util.WonneUtil.*;
import static com.wonne.web.register.ValidationResult.*;


public final class RegisterValidation{

    private final static int FULLNAME_LENGTH    = 3;
    private final static String FULLNAME_ERR_MSG= "Full name can't be less than " + FULLNAME_LENGTH + " letters!";
     
    private final static int PASSWORD_LENGTH    = 8;
    private final static String PASSWORD_ERR_MSG= "Password must be at least " + PASSWORD_LENGTH + " letters, must contain at least one number & one uppercase letter.";
    
    private final static int ZIP_LENGTH         = 5;
    private final static String ZIP_REGEX       = "[0-9]+";
    
    private final static int PHONE_LENGTH       = 10;
    private final static String PHONE_REGEX     = "[0-9]+";
    
    private final static Pattern _1_LETTER      = Pattern.compile( "[0-9]" );
    private final static String NAME            = RegisterValidation.class.getSimpleName( );
    private final static Logger LOGGER          = LoggerFactory.getLogger( NAME );
    
    
    public final static ValidationResult validate( RegisterBean bean ){
        
        if( bean == null ){
            return createInvalid( "Internal Error! Failed to extract properties from form inputs." );
        }
        
        
        if( bean.getFullName() == null || bean.getFullName().trim( ).length( ) < FULLNAME_LENGTH ){
            return createInvalid( FULLNAME_ERR_MSG );            
        }
        
        
        if( !isValidEmail( bean.getEmail()) ){
            return createInvalid( "Email address is Invalid!" );
        }
        
        //Must be at least 8 characters and must contain at least one number & one uppercase letter
        if( !isValidPassword( bean.getPassword()) ){
            return createInvalid( PASSWORD_ERR_MSG );
        }
        
        
        if( !bean.getPassword().equals( bean.getRepassword( )) ){
            return createInvalid( "Passwords do not match!" );
        }
        
        
        if( !isValid(bean.getCompanyName()) ){
            return createInvalid( "Company name is invalid!");            
        }
                
        if( !isValidPhoneNumnber(bean.getPhone()) ){
            return createInvalid("Phone number is invalid!");            
        }
                
        if( !isValid(bean.getAddress()) ){
            return createInvalid("Address is invalid!");            
        }

        if( !isValid(bean.getCity()) ){
            return createInvalid("City is invalid!");            
        }        
        
        if( !isValid(bean.getState()) ){
            return createInvalid("State is invalid!");            
        }
        
        if( !isValidZip(bean.getZip()) ){
            return createInvalid("Zipcode is invalid!");            
        }
                
        if( !isValid(bean.getOrganization()) ){
            return createInvalid("Organization selection is invalid!");            
        }
        
        if( !isValid(bean.getRole()) ){
            return createInvalid("Role selection is invalid!");            
        }
        
        return createValid( );
    
    }
    
    
    protected final static boolean isValidZip( String zip ) {
        if ( !isValid(zip) ) return false;        
        return (zip.matches(ZIP_REGEX) && zip.length() == ZIP_LENGTH );        
    }

    
    protected final static boolean isValidPhoneNumnber( String phone ) {
        if ( !isValid(phone) ) return false;
        
        phone = phone.replaceAll( "-", "" );
        phone = phone.replaceAll( "(", "" );
        phone = phone.replaceAll( ")", "" );
        
        return (phone.matches(PHONE_REGEX) && phone.length() == PHONE_LENGTH );
        
    }

    protected final static boolean isValidPassword( String password ) {
        
        if ( !isValid(password) ) return false;
        if( password.length( ) != PASSWORD_LENGTH ) return false;

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
