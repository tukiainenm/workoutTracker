package com.example.workoutTracker.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class signUpForm {
    @NotEmpty
    @Size(min=5, max=30)
    private String userName = "";

    @NotEmpty
    @Size(min=7, max=30)
    private String password = "";

    @NotEmpty
    @Size(min=7, max=30)
    private String passwordCheck = "";

    @NotEmpty
    private String role = "";

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

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
