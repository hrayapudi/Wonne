package com.wonne.web.servlet;

import java.sql.*;
import org.slf4j.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

import com.mysql.cj.jdbc.*;
import com.wonne.web.database.*;
import static com.wonne.web.util.WonneUtil.*;


@WebListener
public class WonneContextListener implements ServletContextListener{

    private final static String MYSQL_DRIVER    = "com.mysql.jdbc.Driver";
    private final static Logger LOGGER          = LoggerFactory.getLogger( "WonneContextListener" );
  
    
    @Override
    public void contextInitialized( ServletContextEvent event ){
        
        ServletContext ctx  = event.getServletContext();
        DBService service   = getDBService( );
        if( service != null ) {
            ctx.setAttribute( DB_SERVICE_TAG, service );
            LOGGER.info("Successfully stored RegisterService in ServletContext with tag: {}", DB_SERVICE_TAG);
        }
        
        /*
        //initialize log4j
        String log4jConfig = ctx.getInitParameter("log4j-config");
        if(log4jConfig == null){
            System.err.println("No log4j-config init param, initializing log4j with BasicConfigurator");
            BasicConfigurator.configure();
        }else {
            String webAppPath = ctx.getRealPath("/");
            String log4jProp = webAppPath + log4jConfig;
            File log4jConfigFile = new File(log4jProp);
            if (log4jConfigFile.exists()) {
                System.out.println("Initializing log4j with: " + log4jProp);
                DOMConfigurator.configure(log4jProp);
            } else {
                System.err.println(log4jProp + " file not found, initializing log4j with BasicConfigurator");
                BasicConfigurator.configure();
            }
        }
        */
        
    }

    
    //TODO: Add logic to get AWS conn or Hardcoded conn
    protected final DBService getDBService( ){
        Connection dbConn   = getDevConnection( );
        DBService service   = new DBService( dbConn );
        
        return service;
    }
    
    
    protected final Connection getAWSDBConnection( ){
        
        String hostname     = System.getProperty("RDS_HOSTNAME");
        String port         = System.getProperty("RDS_PORT");
        String dbName       = System.getProperty("RDS_DB_NAME");
        String userName     = System.getProperty("RDS_USERNAME");
        String password     = System.getProperty("RDS_PASSWORD");
        Connection awsDBConn= connect( hostname, port, dbName, userName, password );
        
        return awsDBConn;
    }
    
    
    protected final Connection getDevConnection( ){
        
        String hostname     = "wonnedevdb.cmtwfoal5czm.us-east-2.rds.amazonaws.com";
        String port         = "3306";
        String dbName       = "WonneDB";
        String userName     = "hrayapudi";
        String password     = "Wonne22#";
        Connection awsDBConn= connect( hostname, port, dbName, userName, password );
        
        return awsDBConn;
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
    
           
    @Override
    public void contextDestroyed( ServletContextEvent event ){
        
        try {
            
            ServletContext ctx  = event.getServletContext();
            DBService service   = (DBService) ctx.getAttribute( DB_SERVICE_TAG );
            if( service == null ) return;
            
            Connection conn = service.getConnection();
            if( conn == null ) return;
            
            conn.close();
            AbandonedConnectionCleanupThread.checkedShutdown( );
            LOGGER.info("Successfully closed connection to DB.");
                        
        } catch (SQLException e) {
            LOGGER.warn("FAILED to close connection to database", e);
        }
    }
    
}