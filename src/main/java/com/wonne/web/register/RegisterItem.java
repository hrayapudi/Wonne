package com.wonne.web.register;


public enum RegisterItem{
    
    FULL_NAME   ("FullName",    "Full Name",        3   ),
    EMAIL       ("Email",       "Email",            5   ),
    PASSWORD    ("Password",    "Password",         8   ),
    REPASSWORD  ("Repassword",  "Retype Password",  8   ),
    COMPANY     ("Company",     "Company",          3   ),
    PHONE       ("Phone",       "Phone xxx-xxx-xxxx", 10),
    ADDRESS     ("Address",     "Address",          5   ),
    CITY        ("City",        "City",             2   ),
    STATE       ("State",       "State",            2   ),
    ZIPCODE     ("Zipcode",     "Zipcode",          5   ),
    ORGANIZATION("Organization","",                 2   ),
    ROLE        ("Role",        "",                 2   ),
    USER_TYPE_ID("UserTypeId",  "",                 0   );
        
    
    private final String iName;
    private final String holder;
    private final int minLength;
    
    private RegisterItem( String iName, String holder, int minLength ) {
        this.iName      = iName;
        this.holder     = holder;
        this.minLength  = minLength;
    }
    
    
    public final String getIName( ) {
        return iName;
    }
    
    public final String getHolder( ) {
        return holder;
    }
    
    public final int getMinLength( ) {
        return minLength;
    }
    
}
