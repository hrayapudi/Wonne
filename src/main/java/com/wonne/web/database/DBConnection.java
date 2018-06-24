package com.wonne.web.database;

import java.sql.*;
import org.slf4j.*;


public final class DBConnection {

    private final static Logger LOGGER  = LoggerFactory.getLogger( "DBConnection" );
    
 
    public final DBService getDBService( String driverName, String dbHost, String dbPort, String dbName ){
        LOGGER.info( "Attempting to create DB connection.");
        
        String userName     = System.getProperty("RDS_USERNAME");
        String password     = System.getProperty("RDS_PASSWORD");
        Connection conn     = connect( driverName, dbHost, dbPort, dbName, userName, password );
        DBService service   = new DBService( conn );
        
        return service;
    }
    
              
    
    protected final Connection connect( String driverName, String hostname, String port, String dbName, String userName, String password ){
        
        Connection connection   = null;
        
        try {
            Class.forName( driverName );
            LOGGER.info("Loaded driver [{}] ", driverName );
            
            String jdbcUrl      = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName;
            LOGGER.info("Connecting to DB at [{}], User: [{}] ", jdbcUrl, userName );

            connection          = DriverManager.getConnection(jdbcUrl, userName, password);
            LOGGER.info("Successfully connected to database: [{}]", dbName);
            
        }catch( Exception e) { 
            LOGGER.error("FAILED to connect to DB [{}:{}] [{}] [{}]", hostname, port, dbName, userName, e );
        }
        
        return connection;
        
    }
    
    
    
}