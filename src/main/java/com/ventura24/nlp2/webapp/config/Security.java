package com.ventura24.nlp2.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

/**
 * Created by josetesan on 16/12/14.
 */
@EnableWebSecurity
public class Security {

        @Autowired
        private DataSource dataSource;

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery("");

        }
}
