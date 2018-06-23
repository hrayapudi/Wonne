package com.wonne.web.util;

public final class WonneUtil {

    public final static String JSP_NEWLINE = "<br />";

    public final static boolean isValid( String data ){
        if( data == null || data.isEmpty() ){
            return false;
        }
        
        return true;
    }
    
}
