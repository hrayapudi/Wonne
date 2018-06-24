package com.wonne.web.core;

public enum UserType {

    VIEW    (1),
    ADMIN   (2),
    UNKNOWN (-1);
    
    private final int code;
    
    private UserType( int code ) {
        this.code = code;
    }
    
    public final int getCode( ) {
        return code;
    }
    
    public final static UserType fromCode( int code ){
        for( UserType type : UserType.values( ) ) {
            if( type.code == code ) {
                return type;
            }
        }
        
        return UNKNOWN;
    }
    
}
