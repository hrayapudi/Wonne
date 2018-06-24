package com.wonne.web.servlet;

import java.sql.*;
import org.slf4j.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import com.wonne.web.database.*;

import static com.wonne.web.util.WonneUtil.*;


@WebListener
public class WonneContextListener implements ServletContextListener{

    private final static Logger LOGGER          = LoggerFactory.getLogger( "WonneContextListener" );
  
    
    @Override
    public void contextInitialized( ServletContextEvent event ){
        
        ServletContext ctx  = event.getServletContext();
        DBService service   = new DBConnection( ).getDBService( );
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