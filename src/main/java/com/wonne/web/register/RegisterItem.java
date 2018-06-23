package com.wonne.web.register;


public enum RegisterItem{
    
    FULL_NAME   ("fullname",    "Full Name",        3   ),
    EMAIL       ("email",       "Email",            5   ),
    PASSWORD    ("password",    "Password",         8   ),
    REPASSWORD  ("repassword",  "Retype Password",  8   ),
    COMPANY     ("company",     "Company",          3   ),
    PHONE       ("phone",       "Phone xxx-xxx-xxxx", 10),
    ADDRESS     ("address",     "Address",          5   ),
    CITY        ("city",        "City",             2   ),
    STATE       ("state",       "State",            2   ),
    ZIPCODE     ("zipcode",     "Zipcode",          5   ),
    ORGANIZATION("organization","",                 2   ),
    ROLE        ("role",        "",                 2   );
    
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
