package com.wonne.web.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.wonne.web.database.*;

import static com.wonne.web.util.WonneUtil.*;


public class AdminServlet extends HttpServlet {
    
    private static final long serialVersionUID  = 1L;
    
    @Override
    public void init() throws ServletException {
        super.init();
    }

    
    @Override
    protected final void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        DBService service   = (DBService) getServletContext( ).getAttribute( DB_SERVICE_TAG );
        if( service == null ){
            //handleError( DB_SERVICE_ERROR, request, response );
            return;
        }
        
                
    }
     
    
}
