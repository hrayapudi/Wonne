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
    private final String title;
    private final String address;
    private final String phone;
    private final String organization;
    private final String role;
    

    public RegisterBean(String fullName, String email, String password, String repassword, String companyName, String title, 
                        String address, String phone, String organization, String role ) {
        
        this.fullName   = fullName;
        this.email      = email;
        this.password   = password;
        this.repassword = repassword;
        this.companyName= companyName;
        this.title      = title;
        this.address    = address;
        this.phone      = phone;
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

    public final String getTitle() {
        return title;
    }

    public final String getAddress() {
        return address;
    }

    public final String getPhone() {
        return phone;
    }

    public final String getOrganization() {
        return organization;
    }

    public final String getRole() {
        return role;
    }


    @Override
    public final String toString( ) {
        StringBuilder builder = new StringBuilder( 64 );
        builder.append( "[FullName=" );
        builder.append( fullName );
        builder.append( ", email=" );
        builder.append( email );
        builder.append( ", password=" );
        builder.append( password );
        builder.append( ", repassword=" );
        builder.append( repassword );
        builder.append( ", companyName=" );
        builder.append( companyName );
        builder.append( ", title=" );
        builder.append( title );
        builder.append( ", address=" );
        builder.append( address );
        builder.append( ", phone=" );
        builder.append( phone );
        builder.append( ", organization=" );
        builder.append( organization );
        builder.append( ", role=" );
        builder.append( role );
        builder.append( "]" );
        
        return builder.toString( );
    }
        

        
    
}