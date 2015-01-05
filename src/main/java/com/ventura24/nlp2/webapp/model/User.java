package com.ventura24.nlp2.webapp.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by josete on 3/1/15.
 */
public class User {

    @NotEmpty
    @Size(min=4,max=8)
    private String name;
    @NotEmpty
    @Size(min=8,max=16)
    private String password;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min=9,max=9)
    private String login;

    public User()
    {

    }


    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
