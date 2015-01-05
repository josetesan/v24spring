package com.ventura24.nlp2.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

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
                    .usersByUsernameQuery("SELECT USER_LOGIN as USERNAME, PASSWORD , MANDATE_ID as ENABLED from UM_USERS WHERE USER_LOGIN=?")
                    .authoritiesByUsernameQuery("SELECT U.USER_LOGIN as USERNAME, T.NAME as authority from UM_USERS U, UM_ROLES R, UM_ROLE_TYPES T  WHERE T.ROLE_TYPE_ID = R.ROLE_TYPE_ID AND U.USER_ID = R.USER_ID AND U.USER_LOGIN=?")
                    .passwordEncoder(new ShaPasswordEncoder());

        }



        @Override
        protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//                .antMatchers("/game/**")
//                        .authenticated()

                .and()
                        .formLogin()
                                .loginPage("/login")
                                .failureUrl("/login?error")
                                .defaultSuccessUrl("/")
                .and()
                        .logout().logoutSuccessUrl("/login?logout")
                .and()
                        .exceptionHandling().accessDeniedPage("/error/500")
                .and()
                        .csrf();
        }


//        @Bean(name="userDetailsService")
//        public UserDetailsService userDetailsService()
//        {
//                JdbcDaoImpl userDetailsService = new JdbcDaoImpl();
//                userDetailsService.setDataSource(dataSource);
//                return userDetailsService;
//        }

}
