package com.ventura24.nlp2.webapp.config.production;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by josetesan on 29/12/14.
 */
@Configuration
@EnableTransactionManagement
@Profile("production")
public class DbProdConfiguration
{

    // JNDI
    @Bean(name = "dataSource",destroyMethod = "")
    public DataSource dataSource()
    {
       return  getDataSource("java:comp/env/jdbc/nlp");
    }


    @Bean(name = "loginDataSource",destroyMethod = "")
    public DataSource loginDataSource()
    {
        return getDataSource("java:comp/env/jdbc/lm");
    }


    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }


    private final DataSource getDataSource(String jndiName)
    {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        final DataSource dataSource = dsLookup.getDataSource(jndiName);
        return dataSource;
    }
}
