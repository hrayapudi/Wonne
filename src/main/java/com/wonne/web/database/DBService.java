package com.wonne.web.database;

import java.sql.*;
import org.slf4j.*;

import com.mysql.cj.jdbc.*;
import com.wonne.web.core.*;
import com.wonne.web.login.*;
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
    
    
    public final LoginBean userLogin( String email, String password ){
        
        try{
            
            checkUserStmt.setString( 1, email );
            
            ResultSet result        = checkUserStmt.executeQuery( );
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
            LOGGER.warn( "FAILED to check if email and password exists {}", email, e );   
        }
        
        return null;
        
    }
    
    
    public final boolean register( RegisterBean bean ){    
                
        int startColumnIndex    = 1;
        boolean registered      = false;
                
        try{ 
                                   
            insertStmt.setString( startColumnIndex++, bean.getFullName( ) );
            insertStmt.setString( startColumnIndex++, bean.getEmail( ) );
            insertStmt.setString( startColumnIndex++, bean.getPassword( ) );
            insertStmt.setString( startColumnIndex++, bean.getCompanyName( ) );
            insertStmt.setString( startColumnIndex++, bean.getPhone( ) );
            
            insertStmt.setString( startColumnIndex++, bean.getAddress( ) );
            insertStmt.setString( startColumnIndex++, bean.getCity( ) );
            insertStmt.setString( startColumnIndex++, bean.getState( ) );
            insertStmt.setString( startColumnIndex++, bean.getZip( ) );
            insertStmt.setString( startColumnIndex++, bean.getOrganization( ) );
            insertStmt.setString( startColumnIndex++, bean.getRole( ) );
            insertStmt.setInt( startColumnIndex,   UserType.VIEW.getCode( ) );
                                    
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


    public final void close( ) throws SQLException {
        connection.close();
        AbandonedConnectionCleanupThread.checkedShutdown( );
        LOGGER.info("Successfully closed connection to DB.");
        
    }
    
    
}