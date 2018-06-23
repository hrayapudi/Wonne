package com.wonne.web.util;

public final class WonneUtil {

    public final static String JSP_NEWLINE      = "<br />";
    
    public final static String SERVLET_FAILED   = "-1";
    public final static String SERVLET_SUCCESS  = "1";
    
    public final static String DB_SERVICE_TAG   = "DBService";
        
    public final static String LOGIN_PAGE       = "/index.jsp";
    public final static String LOGIN_STATUS_TAG = "loginStatus";
    public final static String LOGIN_MSG_TAG    = "loginMessage";
    
    public final static String REGISTER_STATUS_TAG= "registerStatus";
    public final static String REGISTER_MSG_TAG  = "registerMessage";
    public final static String DB_SERVICE_ERROR = "Internal Error! Failed to load database service!";
    public final static String DB_STORE_ERROR   = "Internal Error! Failed to store info in database!";

    public final static boolean isValid( String data ){
        if( data == null || data.isEmpty() ){
            return false;
        }
        
        return true;
    }
    
}
