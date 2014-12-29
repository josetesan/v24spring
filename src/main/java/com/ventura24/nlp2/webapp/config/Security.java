package com.ventura24.nlp2.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by josetesan on 16/12/14.
 */
@EnableWebSecurity
@Configuration
public class Security extends WebSecurityConfigurerAdapter {

        @Autowired
        private DataSource dataSource;

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery("SELECT LOGIN as username, PASSWORD , ENABLED FROM LM_USERS WHERE LOGIN=?")
                    .groupAuthoritiesByUsername("SELECT LOGIN as username, NAME as role FROM LM_ROLES R, LM_USERS U, LM_USER_ROLES UR WHERE R.LM_ROLE_ID=UR.LM_ROLE_ID AND U.LM_USER_ID = UR.LM_USER_ID AND  LOGIN=?");

        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('it')")
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/login?error")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .rememberMe()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf();
        }
}
