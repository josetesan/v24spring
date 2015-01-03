package com.ventura24.nlp2.webapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by josete on 3/1/15.
 */
@Repository
public class AuthoritiesRepository implements AuthoritiesDao {

    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("AUTHORITIES")
                .usingGeneratedKeyColumns("id");
    }



    @Override
    public void saveAuthority(String username, String authority) {
        Map<String,String> parameters = new ConcurrentHashMap<>();
        parameters.put("username",username);
        parameters.put("authority",authority);
        jdbcInsert.execute(parameters);
    }
}
