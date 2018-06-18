package com.wonne.web.register;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import static com.wonne.web.util.WonneUtil.*;


public class RegisterServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;


    public RegisterServlet() {
    }

    
    protected final void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    
        RegisterBean bean   = parseInput( request );
        boolean isValid     = vaidate( bean, request, response );
        if( !isValid ) return;
        
        RegisterDao registerDao = new RegisterDao();
        boolean isRegistered    = registerDao.register(bean);
        
        if( isRegistered ){
            request.getRequestDispatcher("/Home.jsp").forward(request, response);
            return;
        }
        
        request.setAttribute("errMessage", "FAILED to register user " + bean );
        request.getRequestDispatcher("/Register.jsp").forward(request, response);
            
    }
    
    
     protected final boolean vaidate( RegisterBean bean, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        if( bean == null ){
            request.setAttribute("errMessage", "Failed to extract registration form inputs.");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getFullName()) ){
            request.setAttribute("errMessage", "Full name is invalid!");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getEmail()) ){
            request.setAttribute("errMessage", "Email is invalid!");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return false;
        }
        
        
        if( !isValid(bean.getPassword()) ){
            request.setAttribute("errMessage", "Password is invalid!");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return false;
        }
        
        if( !bean.getPassword().equals(bean.getRepassword()) ){
            request.setAttribute("errMessage", "Passwords do not match!");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getCompanyName()) ){
            request.setAttribute("errMessage", "Company name is invalid!");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getTitle()) ){
            request.setAttribute("errMessage", "Title is invalid!");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return false;
        }
        
        
        if( !isValid(bean.getAddress()) ){
            request.setAttribute("errMessage", "Address is invalid!");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getPhone()) ){
            request.setAttribute("errMessage", "Phone number is invalid!");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getOrganization()) ){
            request.setAttribute("errMessage", "Organization selection is invalid!");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return false;
        }
        
        if( !isValid(bean.getRole()) ){
            request.setAttribute("errMessage", "Role selection is invalid!");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
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
            String message      = request.getParameter("message");
     
            bean                = new RegisterBean(fullName, email, password, repassword, company, title, address, phone, organization, role, message );
            
        }catch( Exception e ){
            System.err.println("FAILED to parse input parameters");
            System.err.println( e );
        }
        
        return bean;
    }

   
    
    
    
}
