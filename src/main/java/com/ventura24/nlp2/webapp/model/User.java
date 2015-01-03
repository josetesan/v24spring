package com.ventura24.nlp2.webapp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by josete on 3/1/15.
 */
public class User {

    @NotEmpty
    @Size(min=4,max=8)
    private String username;
    @NotEmpty
    @Size(min=4,max=8)
    private String password;

    public User()
    {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
