package com.wonne.web.database;

import java.sql.*;
import org.slf4j.*;


public final class DBConnection {

    private final static String MYSQL_DRIVER    = "com.mysql.jdbc.Driver";
    private final static Logger LOGGER          = LoggerFactory.getLogger( "DBConnection" );
    
 
    public final DBService getDBService( ){
        
        Connection dbConn   = getAWSDBConnection( );
        DBService service   = new DBService( dbConn );
        
        return service;
    }
    
    
    protected final Connection getAWSDBConnection( ){
        
        String hostname     = System.getProperty("RDS_HOSTNAME");
        String port         = System.getProperty("RDS_PORT");
        String dbName       = System.getProperty("RDS_DB_NAME");
        String userName     = System.getProperty("RDS_USERNAME");
        String password     = System.getProperty("RDS_PASSWORD");
        Connection conn     = connect( hostname, port, dbName, userName, password );
        
        return conn;
    }
    
        
    
    protected final Connection connect( String hostname, String port, String dbName, String userName, String password ){
        
        Connection connection   = null;
        
        try {
            Class.forName( MYSQL_DRIVER );
            
            String jdbcUrl      = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName;
            LOGGER.info("Attempting to connect to DB with url {}", jdbcUrl);

            connection          = DriverManager.getConnection(jdbcUrl, userName, password);
            LOGGER.info("Successfully connected to {}", jdbcUrl);
            
        }catch( Exception e) { 
            LOGGER.error("FAILED to create DB connection", e );
        }
        
        return connection;
        
    }
    
    
    
}