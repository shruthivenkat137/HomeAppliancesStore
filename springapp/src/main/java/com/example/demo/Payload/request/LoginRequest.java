
package com.example.demo.Payload.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginRequest {

    @NotEmpty
    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
