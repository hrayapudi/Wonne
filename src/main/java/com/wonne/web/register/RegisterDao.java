package com.wonne.web.register;

import java.sql.*;
import org.slf4j.*;
import com.wonne.web.database.*;


public final class RegisterDao {

    private final static String NAME    = RegisterDao.class.getSimpleName( );
    private final static Logger LOGGER  = LoggerFactory.getLogger( NAME );
        
    
    public final boolean register( RegisterBean bean ){    
                
        Connection connection   = null;
        int updateResult        = -1;
        
        try{ 
            
            connection          = DBConnection.getConnection( );
            Statement statement = connection.createStatement( );
            String sqlQuery     = createQuery( bean );
            updateResult        = statement.executeUpdate( sqlQuery );
            LOGGER.info( "Successfully registered user", bean );
            
        }catch( SQLException e ){
            LOGGER.warn( "FAILED to registered user {}", bean, e );
        
        }finally {
                try{
                    if( connection != null) {
                        connection.close( );
                    }
                }catch( SQLException e ){
                    LOGGER.warn( "Exception while closing connection", e );        
                }
        }
            
        return ( updateResult > -1 );
    
    }
    
        
    
    private final static String createQuery(  RegisterBean bean ){
        StringBuilder sqlQuery     = new StringBuilder( 64 );
        
        sqlQuery.append( "INSERT INTO users values (" );
        sqlQuery.append( "'" ).append( bean.getFullName( ) ).append( "'");
        sqlQuery.append( "'" ).append( bean.getEmail( ) ).append( "'");
        sqlQuery.append( "'" ).append( bean.getPassword( ) ).append( "'");
        sqlQuery.append( "'" ).append( bean.getCompanyName( ) ).append( "'");
        sqlQuery.append( "'" ).append( bean.getTitle( ) ).append( "'");
        sqlQuery.append( "'" ).append( bean.getAddress( ) ).append( "'");
        sqlQuery.append( "'" ).append( bean.getPhone( ) ).append( "'");
        sqlQuery.append( "'" ).append( bean.getOrganization( ) ).append( "'");
        sqlQuery.append( "'" ).append( bean.getRole( ) ).append( "'");
        sqlQuery.append( "'" ).append( bean.getMessage( ) ).append( ")");
              
        
        return sqlQuery.toString( );
                
    }
    
}