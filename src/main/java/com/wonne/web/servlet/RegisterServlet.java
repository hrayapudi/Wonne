package com.wonne.web.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.wonne.web.register.*;

import static com.wonne.web.util.WonneUtil.*;


public class RegisterServlet extends HttpServlet {
    
    private RegisterService service;
    
    private static final long serialVersionUID = 1L;


    @Override
    public void init() throws ServletException {
        super.init();
        this.service = new RegisterService();
    }
    
    
    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    
        RegisterBean bean   = parseInput( request );
        boolean isValid     = validate( bean, request, response );
        if( !isValid ) return;
        
        boolean isRegistered= service.register(bean);
        if( !isRegistered ){
            response.sendRedirect("/Register.html");
            return;
        }
        
        response.sendRedirect( "/RegistrationSuccess.html");
            
    }
    
    
    //If Validation fails, populate form with fields that did pass the check
    protected final boolean validate( RegisterBean bean, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        
        ValidationResult result = RegisterValidation.validate( bean );
        boolean validationPassed= result.isValid( );
         
        if( !validationPassed ){
            request.setAttribute("error", result.getReason( ));
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        return true;
        
    }
     
    
   
    protected final RegisterBean parseInput( HttpServletRequest request ){
        
        RegisterBean bean       = null;
    
        try{
        
            String fullName     = request.getParameter("fullname");
            String email        = request.getParameter("email");
            String password     = request.getParameter("password");
            String repassword   = request.getParameter("repassword");
            String company      = request.getParameter("company");
            String phone        = request.getParameter("phone");
            String address      = request.getParameter("address");
            String city         = request.getParameter("city");
            String state        = request.getParameter("state");
            String zipcode      = request.getParameter("zip");
            
            String organization = request.getParameter("organization");
            String role         = request.getParameter("role");
     
            bean                = new RegisterBean(fullName, email, password, repassword, company, phone, address, city, state, zipcode, organization, role );
            
        }catch( Exception e ){
            System.err.println("FAILED to parse input parameters");
            System.err.println( e );
        }
        
        return bean;
    }

    
}
