package com.ventura24.nlp2.webapp.dao;

import com.ventura24.nlp2.webapp.model.User;

/**
 * Created by josete on 3/1/15.
 */
public interface UserDao {

    public Long findIdByUserName(String username);

    public Long saveUser(User user);
}
