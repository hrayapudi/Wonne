package com.wonne.web.register;


public final class ValidationResult{
    
    private final boolean isValid;
    private final String reason;
    
    public ValidationResult( boolean isValid, String reason ){
        this.isValid = isValid;
        this.reason  = reason;
    }
    
    public final static ValidationResult createValid( ){
        return new ValidationResult( true, "" );
    }

    public final static ValidationResult createInvalid( String reason ){
        return new ValidationResult( false, reason );
    }
    

    public final boolean isValid( ){
        return isValid;
    }
    
    
    public final String getReason( ){
        return reason;
    }

    
    @Override
    public final String toString( ){
        StringBuilder builder = new StringBuilder( );
        builder.append( "Result [Valid=" ).append( isValid );
        builder.append( ", Reason=" ).append( reason ).append( "]" );
        return builder.toString( );
    }


}
