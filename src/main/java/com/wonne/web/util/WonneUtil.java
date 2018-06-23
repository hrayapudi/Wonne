package com.wonne.web.util;

public final class WonneUtil {

    public final static String JSP_NEWLINE      = "<br />";
    public final static String DB_SERVICE_TAG   = "DBService";
    public final static String USER_SESSION_TAG = "UserSession";
    public final static String NAME_SESSION_TAG = "FullName";
    public final static String LOGIN_PAGE       = "/index.jsp";
    
    public final static String ERR_MSG_TAG      = "errorMessage";
    public final static String DB_SERVICE_ERROR = "Internal Error! Failed to load database service!";

    public final static boolean isValid( String data ){
        if( data == null || data.isEmpty() ){
            return false;
        }
        
        return true;
    }
    
}
