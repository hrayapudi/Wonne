package com.wonne.web.database;

import java.sql.*;
import org.slf4j.*;

import com.mysql.cj.jdbc.*;
import com.wonne.web.core.*;
import com.wonne.web.login.*;
import com.wonne.web.register.*;

public final class DBService {

    private final Connection connection;
    private final PreparedStatement registerUser;
    private final PreparedStatement lookupUsingEmail;
    private final PreparedStatement lookupUsingEmailZip;
    private final PreparedStatement updateUsingEmailZip;
    
    private final static String USER_TABLE      = "User";
    private final static String NAME            = DBService.class.getSimpleName( );
    private final static Logger LOGGER          = LoggerFactory.getLogger( NAME );
    
    public DBService( Connection connection ){
        this.connection         = connection;
        this.registerUser       = createRegisterUserStatement( connection );
        this.lookupUsingEmail   = createLookupUsingEmailStatement( connection );
        this.lookupUsingEmailZip= createLookupUsingEmailZipStatement( connection );
        this.updateUsingEmailZip= createUpdatePassUsingEmailZipStatement( connection );
    }
    
 
    public final Connection getConnection( ){
        return connection;
    }
        
    
    public final boolean userExists( String email ){
        return (getUserUsingEmail(email) != null);
    }
    
    
    public final LoginBean getUserUsingEmail( String email ){
        
        try{
            
            lookupUsingEmail.setString( 1, email );
            ResultSet result        = lookupUsingEmail.executeQuery( );
            
            while( result.next( ) ){
                String fullName = result.getString( RegisterItem.FULL_NAME.getIName( ) );
                int userTypeId  = result.getInt( RegisterItem.USER_TYPE_ID.getIName( ) );
                return LoginBean.createValid( fullName, email, userTypeId );
            }
            
        }catch( SQLException e ) {
            LOGGER.warn( "Exception while getting user from DB for email {}", email, e );   
        }
        
        return null;
        
    }
    
    public final LoginBean getUserUsingEmailCheckPassword( String email, String password ){
        
        try{
            
            lookupUsingEmail.setString( 1, email );
            
            ResultSet result        = lookupUsingEmail.executeQuery( );
            
            while( result.next( ) ){
                String emailInDB    = result.getString( RegisterItem.EMAIL.getIName( ) );
                String passwordInDB = result.getString( RegisterItem.PASSWORD.getIName( ) );
                boolean matchFound  = ( email.equals(emailInDB) && password.equals(passwordInDB) );
                if( matchFound ){
                    String fullName = result.getString( RegisterItem.FULL_NAME.getIName( ) );
                    int userTypeId  = result.getInt( RegisterItem.USER_TYPE_ID.getIName( ) );
                    return LoginBean.createValid( fullName, email, userTypeId );
                }
            }
            
        }catch( SQLException e ) {
            LOGGER.warn( "Exception while getting user from DB for email & password {}", email, e );   
        }
        
        return null;
        
    }
    
    
    public final LoginBean getUserUsingEmailZipcode( String email, String zipcode ){
        
        try{
            
            lookupUsingEmailZip.setString( 1, email );
            lookupUsingEmailZip.setString( 2, zipcode );
            
            ResultSet result        = lookupUsingEmailZip.executeQuery( );
            
            while( result.next( ) ){
                String emailInDB    = result.getString( RegisterItem.EMAIL.getIName( ) );
                String zipcodeInDB  = result.getString( RegisterItem.ZIPCODE.getIName( ) );
                boolean matchFound  = ( email.equals(emailInDB) && zipcode.equals(zipcodeInDB) );
                if( matchFound ){
                    String fullName = result.getString( RegisterItem.FULL_NAME.getIName( ) );
                    int userTypeId  = result.getInt( RegisterItem.USER_TYPE_ID.getIName( ) );
                    return LoginBean.createValid( fullName, email, userTypeId );
                }
                
            }
            
        }catch( SQLException e ) {
            LOGGER.warn( "FAILED to check if user with email {} and zipcode exists {}", email, zipcode, e );   
        }
        
        return null;
        
    }
    
    
        
    public final boolean updatePassword( String email, String password, String repassword, String zipcode ){

        int startColumnIndex    = 1;
        boolean passUpdated     = false;
        
        try{ 
                                   
            updateUsingEmailZip.setString( startColumnIndex++, password );
            updateUsingEmailZip.setString( startColumnIndex++, email );
            updateUsingEmailZip.setString( startColumnIndex++, zipcode );
                                    
            int updateResult    = updateUsingEmailZip.executeUpdate( );
            passUpdated         = ( updateResult > -1 );
                                       
        }catch( SQLException e ){
            LOGGER.warn( "FAILED to update password for user {} {}", email, zipcode, e );        
        }
            
        return passUpdated;
        
    }
    
    
    //All users are created as VIEW users
    public final boolean register( RegisterBean bean ){    
                
        int startColumnIndex    = 1;
        boolean registered      = false;
                
        try{ 
                                   
            registerUser.setString( startColumnIndex++, bean.getFullName( ) );
            registerUser.setString( startColumnIndex++, bean.getEmail( ) );
            registerUser.setString( startColumnIndex++, bean.getPassword( ) );
            registerUser.setString( startColumnIndex++, bean.getCompanyName( ) );
            registerUser.setString( startColumnIndex++, bean.getPhone( ) );
            
            registerUser.setString( startColumnIndex++, bean.getAddress( ) );
            registerUser.setString( startColumnIndex++, bean.getCity( ) );
            registerUser.setString( startColumnIndex++, bean.getState( ) );
            registerUser.setString( startColumnIndex++, bean.getZipcode( ) );
            registerUser.setString( startColumnIndex++, bean.getOrganization( ) );
            registerUser.setString( startColumnIndex++, bean.getRole( ) );
            registerUser.setInt   ( startColumnIndex,   UserType.VIEW.getCode( ) );
                                    
            int updateResult    = registerUser.executeUpdate( );
            registered          = ( updateResult > -1 );
            LOGGER.info( "Successfully registered user {}", bean );
                           
        }catch( SQLException e ){
            LOGGER.warn( "FAILED to registered user {}", bean, e );        
        }
            
        return registered;
    
    }
        
    
    protected final PreparedStatement createLookupUsingEmailStatement( Connection connection ){
        PreparedStatement pStatement = null;
    
        try {
            
            StringBuilder builder   = new StringBuilder( 32 );
            
            builder.append( "SELECT * FROM " ).append( USER_TABLE );
            builder.append( " WHERE " );
            builder.append( RegisterItem.EMAIL.getIName( ) ).append( " = ?" );
                        
            String query            = builder.toString( );
            pStatement              = connection.prepareStatement( query );
            
        }catch( Exception e ) {
            LOGGER.warn( "FAILED to created prepared statement.", e );
        }
    
        return pStatement;
    
    }
    
    
    protected final PreparedStatement createLookupUsingEmailZipStatement( Connection connection ){
        PreparedStatement pStatement = null;
    
        try {
            
            StringBuilder builder   = new StringBuilder( 32 );
            
            builder.append( "SELECT * FROM " ).append( USER_TABLE );
            builder.append( " WHERE " );
            builder.append( RegisterItem.EMAIL.getIName( ) ).append( " = ? AND " );
            builder.append( RegisterItem.ZIPCODE.getIName( ) ).append( " = ?" );
            
            String query            = builder.toString( );
            pStatement              = connection.prepareStatement( query );
            
        }catch( Exception e ) {
            LOGGER.warn( "FAILED to created prepared statement.", e );
        }
    
        return pStatement;
    
    }
    
    
    
    protected final PreparedStatement createRegisterUserStatement( Connection connection ){
        PreparedStatement pStatement = null;
    
        try {
            
            StringBuilder builder = new StringBuilder( 128 );
            
            builder.append( "INSERT INTO " ).append( USER_TABLE ).append( "( " );
            builder.append( RegisterItem.FULL_NAME.getIName( ) ).append( "," );
            builder.append( RegisterItem.EMAIL.getIName( ) ).append( "," );
            builder.append( RegisterItem.PASSWORD.getIName( ) ).append( "," );
            builder.append( RegisterItem.COMPANY.getIName( ) ).append( "," );
            builder.append( RegisterItem.PHONE.getIName( ) ).append( "," );
            builder.append( RegisterItem.ADDRESS.getIName( ) ).append( "," );
            builder.append( RegisterItem.CITY.getIName( ) ).append( "," );
            builder.append( RegisterItem.STATE.getIName( ) ).append( "," );
            builder.append( RegisterItem.ZIPCODE.getIName( ) ).append( "," );
            builder.append( RegisterItem.ORGANIZATION.getIName( ) ).append( "," );
            builder.append( RegisterItem.ROLE.getIName( ) ).append( "," );
            builder.append( RegisterItem.USER_TYPE_ID.getIName( ) );
            builder.append( ") values " );
            
            builder.append( "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )" );
            
            String query    = builder.toString( );
            pStatement      = connection.prepareStatement(query);
            
        }catch( Exception e ) {
            LOGGER.warn( "FAILED to created prepared statement.", e );
        }
    
        return pStatement;
    
    }

    
    
    protected final PreparedStatement createUpdatePassUsingEmailZipStatement( Connection connection ){
        
        PreparedStatement pStatement = null;
        
        try {
            
            StringBuilder builder = new StringBuilder( 64 );
            
            builder.append( "UPDATE " ).append( USER_TABLE ).append( " SET " );
            builder.append( RegisterItem.PASSWORD.getIName( ) ).append( "=? " );
            builder.append( " WHERE " );
            builder.append( RegisterItem.EMAIL.getIName( ) ).append( "=?" ).append( " AND " );
            builder.append( RegisterItem.ZIPCODE.getIName( ) ).append( "=?" );
            
            String query    = builder.toString( );
            pStatement      = connection.prepareStatement(query);
            
        }catch( Exception e ) {
            LOGGER.warn( "FAILED to created prepared statement.", e );
        }
    
        return pStatement;
        
    }
    

    public final void close( ) throws SQLException {
        
        if( connection != null ) {
            connection.close();
        }
        
        AbandonedConnectionCleanupThread.checkedShutdown( );
        LOGGER.info("Successfully closed connection to DB.");
        
    }

    
    
}