package com.ventura24.nlp2.webapp.dao;

import com.ventura24.nlp2.webapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by josete on 3/1/15.
 */
@Repository
public class UserJdbcRepository implements UserDao{

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                                    .withTableName("UM_USERS")
                                    .usingGeneratedKeyColumns("USER_ID");
    }


    @Override
    public Long findIdByUserName(String userlogin) {
        return jdbcTemplate.queryForObject("Select USER_ID from UM_USERS where USER_LOGIN=?", Long.class, userlogin);
    }

    @Override
    public Long saveUser(User user)
    {
        Map <String,Object>parameters = new ConcurrentHashMap<>();
        parameters.put("USER_LOGIN", user.getLogin());
        parameters.put("PASSWORD", user.getPassword());
        parameters.put("MANDATE_ID", 1L);
        parameters.put("CREATION_DATE",new Date());
        parameters.put("USER_TYPE_ID",1L);
        parameters.put("USER_LOGIN_TYPE_ID",1L);
        parameters.put("NAME",user.getName());
        parameters.put("EMAIL",user.getEmail());
        return jdbcInsert.executeAndReturnKey(parameters).longValue();


    }
}
