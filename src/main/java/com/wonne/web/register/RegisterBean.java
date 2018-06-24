package com.wonne.web.register;

/**
 *
 * @author vsingh
 */
public final class RegisterBean {
 
    private final String fullName;
    private final String email;
    private final String password;
    private final String repassword;
    private final String companyName;
    private final String phone;
    private final String address;
    private final String city;
    private final String state;
    private final String zipcode;    
    private final String organization;
    private final String role;
    

    public RegisterBean(String fullName, String email, String password, String repassword, String companyName, String phone, 
                        String address, String city, String state, String zipcode, String organization, String role ) {
        
        this.fullName   = fullName;
        this.email      = email;
        this.password   = password;
        this.repassword = repassword;
        this.companyName= companyName;
        this.phone      = phone;
        this.address    = address;
        this.city       = city;
        this.state      = state;
        this.zipcode    = zipcode;
        this.organization = organization;
        this.role       = role;
                
    }
    

    public final String getFullName() {
        return fullName;
    }

    public final String getEmail() {
        return email;
    }

    public final String getPassword() {
        return password;
    }

    public final String getRepassword() {
        return repassword;
    }
     
    public final String getCompanyName() {
        return companyName;
    }

    public final String getPhone() {
        return phone;
    }

    public final String getAddress() {
        return address;
    }
    

    public final String getCity() {
        return city;
    }    

    public final String getState() {
        return state;
    }
    

    public final String getZipcode() {
        return zipcode;
    }
    

    public final String getOrganization() {
        return organization;
    }

    public final String getRole() {
        return role;
    }


    @Override
    public String toString( ) {
        StringBuilder builder = new StringBuilder( );
        builder.append( "RegisterBean [fullName=" );
        builder.append( fullName );
        builder.append( ", email=" );
        builder.append( email );
        builder.append( ", password=" );
        builder.append( password );
        builder.append( ", repassword=" );
        builder.append( repassword );
        builder.append( ", companyName=" );
        builder.append( companyName );
        builder.append( ", phone=" );
        builder.append( phone );
        builder.append( ", address=" );
        builder.append( address );
        builder.append( ", city=" );
        builder.append( city );
        builder.append( ", state=" );
        builder.append( state );
        builder.append( ", zipcode=" );
        builder.append( zipcode );
        builder.append( ", organization=" );
        builder.append( organization );
        builder.append( ", role=" );
        builder.append( role );
        builder.append( "]" );
        return builder.toString( );
    }


        
    
}