package com.ventura24.nlp2.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
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
                    .passwordEncoder(new PlaintextPasswordEncoder());

        }



        @Override
        protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/game/**")
                        .authenticated()
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


        @Bean(name="userDetailsService")
        public UserDetailsService userDetailsService()
        {
                JdbcDaoImpl userDetailsService = new JdbcDaoImpl();
                userDetailsService.setDataSource(dataSource);
                return userDetailsService;
        }

}
