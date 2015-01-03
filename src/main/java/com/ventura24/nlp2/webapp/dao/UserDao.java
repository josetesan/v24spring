package com.ventura24.nlp2.webapp.dao;

/**
 * Created by josete on 3/1/15.
 */
public interface UserDao {

    public Long findIdByUserName(String username);
}
