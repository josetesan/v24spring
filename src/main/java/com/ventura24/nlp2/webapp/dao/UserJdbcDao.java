package com.ventura24.nlp2.webapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by josete on 3/1/15.
 */
@Repository
public class UserJdbcDao implements UserDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Long findIdByUserName(String username) {
        return jdbcTemplate.queryForObject("Select id from USERS where username=?",Long.class,username);
    }
}
