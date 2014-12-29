package com.ventura24.nlp2.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by josetesan on 29/12/14.
 */
@Configuration
@EnableTransactionManagement
public class DbConfiguration {


    @Bean(name = "dataSource")
    public DataSource dataSource()
    {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
//        dsLookup.setResourceRef(true);
        final DataSource dataSource = dsLookup.getDataSource("java:comp/env/jdbc/MyLocalDB");
        return dataSource;
    }
}
