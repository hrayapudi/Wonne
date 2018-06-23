package com.wonne.web.database;

import java.sql.*;
import org.slf4j.*;
import com.wonne.web.register.*;

public final class DBService {

    private final Connection connection;
    private final PreparedStatement insertStmt;
    private final PreparedStatement checkUserStmt;
    
    private final static String USER_TABLE      = "User";
    private final static String NAME            = DBService.class.getSimpleName( );
    private final static Logger LOGGER          = LoggerFactory.getLogger( NAME );
    
    public DBService( Connection connection ){
        this.connection     = connection;
        this.insertStmt     = createInsertPreparedStatement( connection );
        this.checkUserStmt  = createCheckUserPreparedStatement( connection );
    }
    
    
    public final Connection getConnection( ){
        return connection;
    }
    
    
    public final boolean userExists( String email ){
        
        boolean userExists      = false;
        
        try {
            
            checkUserStmt.setString( 1, email );
            
            ResultSet result    = checkUserStmt.executeQuery( );
            userExists          = result.next();
            
        }catch( SQLException e ) {
            LOGGER.warn( "FAILED to check if user exists {}", email, e );   
        }
        
        return userExists;
        
    }
    
    
    public final String userPasswordMatch( String email, String password ){
        
        try{
            
            checkUserStmt.setString( 1, email );
            
            ResultSet result        = checkUserStmt.executeQuery( );
            while( result.next( ) ) {
                String emailInDB    = result.getString( RegisterItem.EMAIL.getIName( ) );
                String passwordInDB = result.getString( RegisterItem.PASSWORD.getIName( ) );
                boolean matchFound  = ( email.equals(emailInDB) && password.equals(passwordInDB) );
                if( matchFound ) {
                    return result.getString( RegisterItem.FULL_NAME.getIName( ) );                    
                }
            }
            
        }catch( SQLException e ) {
            LOGGER.warn( "FAILED to check if email and password exists {}", email, e );   
        }
        
        return "";
        
    }
    
    
    public final boolean register( RegisterBean bean ){    
                
        boolean registered      = false;
                
        try{ 
                                   
            insertStmt.setString( 1, bean.getFullName( ) );
            insertStmt.setString( 2, bean.getEmail( ) );
            insertStmt.setString( 3, bean.getPassword( ) );
            insertStmt.setString( 4, bean.getCompanyName( ) );
            insertStmt.setString( 5, bean.getPhone( ) );
            
            insertStmt.setString( 6, bean.getAddress( ) );
            insertStmt.setString( 7, bean.getCity( ) );
            insertStmt.setString( 8, bean.getState( ) );
            insertStmt.setString( 9, bean.getZip( ) );
            insertStmt.setString( 10, bean.getOrganization( ) );
            insertStmt.setString( 11, bean.getRole( ) );
                                    
            int updateResult    = insertStmt.executeUpdate( );
            registered          = ( updateResult > -1 );
            LOGGER.info( "Successfully registered user {}", bean );
                           
        }catch( SQLException e ){
            LOGGER.warn( "FAILED to registered user {}", bean, e );        
        }
            
        return registered;
    
    }
    
    
    protected final PreparedStatement createCheckUserPreparedStatement( Connection connection ){
        PreparedStatement pStatement = null;
    
        try {
            pStatement  = connection.prepareStatement("SELECT * FROM " + USER_TABLE + " WHERE Email = ?");
            
        }catch( Exception e ) {
            LOGGER.warn( "FAILED to created prepared statement.", e );
        }
    
        return pStatement;
    
    }
    
    
    protected final PreparedStatement createInsertPreparedStatement( Connection connection ){
        PreparedStatement pStatement = null;
    
        try {
            pStatement  = connection.prepareStatement("INSERT INTO " + USER_TABLE + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
        }catch( Exception e ) {
            LOGGER.warn( "FAILED to created prepared statement.", e );
        }
    
        return pStatement;
    
    }
    
    
}