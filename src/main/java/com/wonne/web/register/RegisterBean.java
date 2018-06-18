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
    private final String message;
    

    public RegisterBean(String fullName, String email, String password, String repassword, String companyName, String title, 
                        String address, String phone, String organization, String role, String message ) {
        
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
        this.message    = message;
        
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
    
    public final String getMessage() {
        return message;
    }
    

    @Override
    public final String toString( ){
        return "RegisterBean{" + "fullName=" + fullName + ", email=" + email + ", password=" + password + ", repassword=" + repassword +", companyName=" + companyName +
                ", title=" + title + ", address=" + address + ", phone=" + phone + ", organization=" + organization + ", role=" + role + ", message=" + message + '}';
    }
        
    
}