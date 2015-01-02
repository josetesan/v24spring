package com.ventura24.nlp2.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;

/**
 * Created by josetesan on 16/12/14.
 */
@EnableWebSecurity
@Configuration
@ActiveProfiles("dev")
public class Security extends WebSecurityConfigurerAdapter {

        @Autowired
        private DataSource dataSource;

/*
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .jdbcAuthentication()
                    .dataSource(dataSource)
                    .passwordEncoder(new ShaPasswordEncoder())
                    .usersByUsernameQuery("SELECT LOGIN as username, PASSWORD , ENABLED FROM LM_USERS WHERE LOGIN=?")
                    .groupAuthoritiesByUsername("SELECT LOGIN as username, NAME as role FROM LM_ROLES R, LM_USERS U, LM_USER_ROLES UR WHERE R.LM_ROLE_ID=UR.LM_ROLE_ID AND U.LM_USER_ID = UR.LM_USER_ID AND  LOGIN=?");

        }
 */
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth
                        .inMemoryAuthentication()
                        .withUser("josete").password("almudena").authorities("it")
                        .and()
                        .withUser("almudena").password("josete").authorities("mkt");

        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/**")
                        .access("hasRole('it')")
                .and()
                        .formLogin()
                                .loginPage("/login")
                                .failureUrl("/403")
                                .defaultSuccessUrl("/admin")
//                                .successHandler(savedRequestAwareAuthenticationSuccessHandler())
//                                .loginProcessingUrl("/auth/login_check")
                .and()
                        .logout().logoutSuccessUrl("/login?logout")
//                .and()
//                        .rememberMe()
//                                .tokenRepository(persistentTokenRepository())
//                                .tokenValiditySeconds(1209600)
                .and()
                        .exceptionHandling().accessDeniedPage("/403")
                .and()
                        .csrf();
        }

//        @Bean
//        public PersistentTokenRepository persistentTokenRepository() {
//                JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
//                db.setDataSource(dataSource);
//                return db;
//        }
//
//        @Bean
//        public SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler() {
//                SavedRequestAwareAuthenticationSuccessHandler auth = new SavedRequestAwareAuthenticationSuccessHandler();
//                auth.setTargetUrlParameter("targetUrl");
//                return auth;
//        }
/*
        @Bean(name="userDetailsService")
        public UserDetailsService userDetailsService()
        {
             JdbcDaoImpl userDetailsService = new JdbcDaoImpl();
             userDetailsService.setDataSource(dataSource);
             return userDetailsService;
        }
        */

}
