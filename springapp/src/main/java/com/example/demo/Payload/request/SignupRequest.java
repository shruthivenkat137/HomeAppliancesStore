
package com.example.demo.Payload.request;

import javax.validation.constraints.*;

public class SignupRequest {

    private String fullName;
    @NotEmpty
    @Size(min = 2, max = 20, message = "name must have atleast 2 characters")
    private String userName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$", message = "password should have atleast a upper and a lower case alphabeta number and a special character")
    @Size(min = 5, max = 20, message = "password should have atleast 5 characters")
    private String password;

    @NotEmpty
    @Pattern(regexp = "(0/91)?[6-9][0-9]{9}", message = "Mobile number  is invalid")
    @Size(min = 10, max = 10)
    private String phoneno;

    private String role;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
