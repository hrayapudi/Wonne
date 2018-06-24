package com.wonne.web.servlet;

import java.io.*;
import java.sql.*;
import org.slf4j.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import com.wonne.web.database.*;

import static com.wonne.web.util.WonneUtil.*;


@WebListener
public class WonneContextListener implements ServletContextListener{

    private final static String RDS_DRIVER_TAG  = "RDS_DRIVER";
    private final static String RDS_HOST_TAG    = "RDS_HOST";
    private final static String RDS_PORT_TAG    = "RDS_PORT";
    private final static String RDS_DB_NAME_TAG = "RDS_DB_NAME";
    private final static String LOGGER_CFG_TAG  = "LOGGER_CONFIG";
    
    private final static Logger LOGGER          = LoggerFactory.getLogger( "WonneContextListener" );
  
    
    @Override
    public void contextInitialized( ServletContextEvent event ){
        LOGGER.info( "Initializing Wonne Servlet context.");
        
        ServletContext ctx  = event.getServletContext();
        loadLogger( ctx );
        
        String dbDriver     = ctx.getInitParameter(RDS_DRIVER_TAG);
        String dbHost       = ctx.getInitParameter(RDS_HOST_TAG);
        String dbPort       = ctx.getInitParameter(RDS_PORT_TAG);
        String dbName       = ctx.getInitParameter(RDS_DB_NAME_TAG);
        
        DBConnection conn   = new DBConnection( );
        DBService service   = conn.getDBService( dbDriver, dbHost, dbPort, dbName );
        if( service != null ) {
            ctx.setAttribute( DB_SERVICE_TAG, service );
            LOGGER.info("Successfully stored RegisterService in ServletContext with tag: {}", DB_SERVICE_TAG);
        }
       
        LOGGER.info( "Wonne Servlet context initialized!");
        
    }

    
    protected final void loadLogger( ServletContext context ){
        
        String loggerCfgFile    = context.getInitParameter(LOGGER_CFG_TAG);
        
        try {
            
            if( !isValid(loggerCfgFile) ){
                System.err.println("Error: Logger config file is unspecified as context-param [" + LOGGER_CFG_TAG + "] in web.xml!");
                return;
            }
            
            String fullPath     = context.getRealPath("") + File.separator + loggerCfgFile;
            System.setProperty( "logback.configurationFile", fullPath );
            LOGGER.info( "Successfully loaded logger config from [{}]", loggerCfgFile );
        
        }catch( Exception e ) {
            System.err.println("FAILED to load logger config from " + loggerCfgFile);
            e.printStackTrace( );
        }
        
         
    }
           
    @Override
    public void contextDestroyed( ServletContextEvent event ){
        
        try {
            
            ServletContext ctx  = event.getServletContext();
            DBService service   = (DBService) ctx.getAttribute( DB_SERVICE_TAG );
            if( service == null ) return;
            
            service.close( );
            LOGGER.info( "Successfully destroyed Wonne Servlet context.");
            
        } catch (SQLException e) {
            LOGGER.warn("FAILED to destroy Wonne Servlet context.", e);
        }
    }
    
}