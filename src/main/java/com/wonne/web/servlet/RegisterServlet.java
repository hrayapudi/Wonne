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
    
    
     protected final boolean validate( RegisterBean bean, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        
         if( bean == null ){
            request.setAttribute("error", "Failed to extract registration form inputs.");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getFullName()) ){
            request.setAttribute("error", "Full name is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getEmail()) ){
            request.setAttribute("error", "Email is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        
        if( !isValid(bean.getPassword()) ){
            request.setAttribute("error", "Password is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        if( !bean.getPassword().equals(bean.getRepassword()) ){
            request.setAttribute("error", "Passwords do not match!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getCompanyName()) ){
            request.setAttribute("error", "Company name is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getTitle()) ){
            request.setAttribute("error", "Title is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        
        if( !isValid(bean.getAddress()) ){
            request.setAttribute("error", "Address is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getPhone()) ){
            request.setAttribute("error", "Phone number is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getOrganization()) ){
            request.setAttribute("error", "Organization selection is invalid!");
            request.getRequestDispatcher("/Register.html").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getRole()) ){
            request.setAttribute("error", "Role selection is invalid!");
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
            String title        = request.getParameter("title");
            String address      = request.getParameter("address");
            String phone        = request.getParameter("phone");
            String organization = request.getParameter("organization");
            String role         = request.getParameter("role");
     
            bean                = new RegisterBean(fullName, email, password, repassword, company, title, address, phone, organization, role );
            
        }catch( Exception e ){
            System.err.println("FAILED to parse input parameters");
            System.err.println( e );
        }
        
        return bean;
    }

   
    
    
    
}
