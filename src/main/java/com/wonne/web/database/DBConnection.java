package com.wonne.web.database;

import org.slf4j.*;

import java.sql.Connection;
import java.sql.DriverManager;


public final class DBConnection{
    
    private final static String NAME    = DBConnection.class.getSimpleName( );
    private final static Logger LOGGER  = LoggerFactory.getLogger( NAME );
    
    public DBConnection( String driverClassName ) {
        loadDriver( driverClassName );
    }
    
    public final Connection getAWSDBConnection( ){
        
        String hostname     = System.getProperty("RDS_HOSTNAME");
        String port         = System.getProperty("RDS_PORT");
        String dbName       = System.getProperty("RDS_DB_NAME");
        String userName     = System.getProperty("RDS_USERNAME");
        String password     = System.getProperty("RDS_PASSWORD");
        Connection awsDBConn= getConnection( hostname, port, dbName, userName, password );
        
        return awsDBConn;
    }
    
    
    public final Connection getDevConnection( ){
        
        String hostname     = "wonnedevdb.cmtwfoal5czm.us-east-2.rds.amazonaws.com";
        String port         = "3306";
        String dbName       = "WonneDB";
        String userName     = "hrayapudi";
        String password     = "Wonne22#";
        Connection awsDBConn= getConnection( hostname, port, dbName, userName, password );
        
        return awsDBConn;
    }
    
    
        
    public final Connection getConnection( String hostname, String port, String dbName, String userName, String password ){
         
        Connection connection   = null;
        
        try {
            String jdbcUrl      = createUrl( hostname, port, dbName );
            LOGGER.info("Attempting to connect to DB with url {}", jdbcUrl);

            connection          = DriverManager.getConnection(jdbcUrl, userName, password);
            LOGGER.info("Successfully connected to {}", jdbcUrl);
            
        }catch( Exception e) { 
            LOGGER.error("FAILED to create DB connection", e );
        }
        
        return connection;
        
    }
    
    
    
    private final static String createUrl( String hostname, String port, String dbName ){
        return "jdbc:mysql://" + hostname + ":" + port + "/" + dbName;
    }
    
    
    private final static void loadDriver( String driverClassName  ){
        try {
            Class.forName( driverClassName );
            
        }catch( ClassNotFoundException e ) {
            LOGGER.error( "Exiting as we FAILED to load database driver {}", driverClassName, e );
            System.exit(1);
        }
    }
   
    
    
}