package com.wonne.web.register;

import java.sql.*;
import org.slf4j.*;
import com.wonne.web.database.*;


public final class RegisterService {

    private final DBConnection dbConn;
    private final Connection connection;
    private final PreparedStatement pStatement;
    
    private final static String TABLE_NAME  = "User";
    private final static String MYSQL_DRIVER= "com.mysql.cj.jdbc.Driver";
    private final static String NAME        = RegisterService.class.getSimpleName( );
    private final static Logger LOGGER      = LoggerFactory.getLogger( NAME );
    
    public RegisterService( ){    
        this.dbConn     = new DBConnection( MYSQL_DRIVER );
        this.connection = dbConn.getAWSDBConnection( );
        this.pStatement = createPStatement( connection );
    }
    
    
    public final boolean register( RegisterBean bean ){    
                
        int updateResult        = -1;
        
        try{ 
                       
            pStatement.setString( 1, bean.getFullName( ) );
            pStatement.setString( 2, bean.getEmail( ) );
            pStatement.setString( 3, bean.getPassword( ) );
            pStatement.setString( 4, bean.getCompanyName( ) );
            pStatement.setString( 5, bean.getAddress( ) );
            pStatement.setString( 6, bean.getPhone( ) );
            pStatement.setString( 7, bean.getTitle( ) );
            pStatement.setString( 8, bean.getOrganization( ) );
            pStatement.setString( 9, bean.getRole( ) );
            pStatement.setString( 10, bean.getMessage( ) );
                        
            updateResult        = pStatement.executeUpdate( );
            LOGGER.info( "Successfully registered user", bean );
            
        }catch( SQLException e ){
            LOGGER.warn( "FAILED to registered user {}", bean, e );
        
        }
            
        return ( updateResult > -1 );
    
    }
    
      
    
    protected final PreparedStatement createPStatement( Connection connection ){
        PreparedStatement pStatement = null;
    
        try {
            pStatement  = connection.prepareStatement("INSERT INTO " + TABLE_NAME + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
            
        }catch( Exception e ) {
            LOGGER.warn( "FAILED to created prepared statement.", e );
        }
    
        return pStatement;
    
    }
    
    
}