package com.wonne.web.database;

import org.slf4j.*;

import java.sql.Connection;
import java.sql.DriverManager;


public final class DBConnection{
    
    static {
        loadDriver( );
    }
    
    private final static String DRIVER  = "com.mysql.jdbc.Driver";
    private final static String NAME    = DBConnection.class.getSimpleName( );
    private final static Logger LOGGER  = LoggerFactory.getLogger( NAME );
    
        
    public final static Connection getConnection( ){
         
        Connection connection   = null;
        
        try {
                    
            String hostname     = System.getProperty("RDS_HOSTNAME");
            String port         = System.getProperty("RDS_PORT");
            String dbName       = System.getProperty("RDS_DB_NAME");
            String userName     = System.getProperty("RDS_USERNAME");
            String password     = System.getProperty("RDS_PASSWORD");
            
            String jdbcUrl      = createUrl( hostname, port, dbName, userName, password );
            LOGGER.trace("Getting remote connection with connection string from environment variables.");

            connection          = DriverManager.getConnection(jdbcUrl);
            LOGGER.info("Remote connection successful.");
      
        }catch( Exception e) { 
            LOGGER.error("FAILED to create DB connection", e );
        }
        
        return connection;
        
    }
    
    
    
    private final static String createUrl( String hostname, String port, String dbName, String userName, String password ){
        return "jdbc:driver://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
    }
    
    
    private final static void loadDriver( ){
        try {
            Class.forName( DRIVER );
            
        }catch( ClassNotFoundException e ) {
            LOGGER.error( "Exiting as we FAILED to load database driver {}", DRIVER, e );
            System.exit(1);
        }
    }
   
    
    
}