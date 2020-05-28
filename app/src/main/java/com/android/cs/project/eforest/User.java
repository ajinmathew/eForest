package com.android.cs.project.eforest;

public class User {
    String name,password,email,mobileno;

    public User() {
    }

    public User(String name, String password, String email, String mobileno) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.mobileno = mobileno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}
