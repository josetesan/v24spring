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
public class UserJdbcDao implements UserDao{

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                                    .withTableName("USERS")
                                    .usingGeneratedKeyColumns("id");
    }


    @Override
    public Long findIdByUserName(String username) {
        return jdbcTemplate.queryForObject("Select id from USERS where username=?", Long.class, username);
    }

    @Override
    public Long saveUser(User user)
    {
        Map <String,Object>parameters = new ConcurrentHashMap<>();
        parameters.put("username", user.getUsername());
        parameters.put("password", user.getPassword());
        parameters.put("enabled", 1L);
        parameters.put("CREATE_DATE",new Date());
        return jdbcInsert.executeAndReturnKey(parameters).longValue();


    }
}
