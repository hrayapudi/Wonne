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

    private final static String LOG_LOC = "logger-config-location";
    private final static Logger LOGGER  = LoggerFactory.getLogger( "WonneContextListener" );
  
    
    @Override
    public void contextInitialized( ServletContextEvent event ){
        
        ServletContext ctx  = event.getServletContext();
        loadLogger( ctx );
        
        DBService service   = new DBConnection( ).getDBService( );
        if( service != null ) {
            ctx.setAttribute( DB_SERVICE_TAG, service );
            LOGGER.info("Successfully stored RegisterService in ServletContext with tag: {}", DB_SERVICE_TAG);
        }
        
       
    }

    
    protected final void loadLogger( ServletContext context ){
        
        String loggerCfgFile    = context.getInitParameter(LOG_LOC);
        
        try {
            
            if( !isValid(loggerCfgFile) ){
                System.err.println("FAILED to load logger config file as it in not specified in web.xml!");
                return;
            }
            
            String fullPath     = context.getRealPath("") + File.separator + loggerCfgFile;
            System.setProperty( "logback.configurationFile", fullPath );
            LOGGER.info( "Successfully load log config from [{}]", loggerCfgFile );
        
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
                        
        } catch (SQLException e) {
            LOGGER.warn("FAILED to close connection to database", e);
        }
    }
    
}