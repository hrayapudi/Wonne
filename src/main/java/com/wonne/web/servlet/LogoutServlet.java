package com.wonne.web.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import static com.wonne.web.util.WonneUtil.*;


public class LogoutServlet extends HttpServlet {
    
    private static final long serialVersionUID  = 1L;
    
    @Override
    public void init() throws ServletException {
        super.init();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //invalidate the session if exists
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        
        response.sendRedirect( request.getContextPath() + LOGIN_PAGE );
    }
  
    
    
}
