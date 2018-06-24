package com.wonne.web.login;

import com.wonne.web.core.*;

public final class LoginBean {
 
    private final boolean isValid;
    private final String fullName;
    private final String email;
    private final UserType type;
    private final String message;
    
    public LoginBean( boolean isValid, String fullName, String email, UserType type, String message ) {
        this.isValid    = isValid;
        this.fullName   = fullName;
        this.email      = email;
        this.type       = type;                       
        this.message    = message;
    }
    
    public final static LoginBean createError( String message ) {
        return new LoginBean( false, "", "", UserType.UNKNOWN, message );
    }

    public final static LoginBean createValid( String fullName, String email, int userTypeId ) {
        return new LoginBean( true, fullName, email, UserType.fromCode(userTypeId), "" );
    }
    
    
    public final boolean isValid() {
        return isValid;
    }

    public final String getFullName() {
        return fullName;
    }

    public final String getEmail() {
        return email;
    }

    public final UserType getType() {
        return type;
    }

    public final String getMessage() {
        return message;
    }

    @Override
    public final String toString( ) {
        StringBuilder builder = new StringBuilder( );
        builder.append( "LoginBean [isValid=" );
        builder.append( isValid );
        builder.append( ", fullName=" );
        builder.append( fullName );
        builder.append( ", email=" );
        builder.append( email );
        builder.append( ", type=" );
        builder.append( type );
        builder.append( ", message=" );
        builder.append( message );
        builder.append( "]" );
        return builder.toString( );
    }

          
    
}