package com.ventura24.nlp2.webapp.config;

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
public class DbConfiguration {

    // JNDI
    @Bean(name = "dataSource",destroyMethod = "")
    @Profile("production")
    public DataSource prodDataSource()
    {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        final DataSource dataSource = dsLookup.getDataSource("java:comp/env/jdbc/nlp");
        return dataSource;
    }


    @Bean(name = "loginDataSource",destroyMethod = "")
    @Profile("production")
    public DataSource loginDataSource()
    {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        final DataSource dataSource = dsLookup.getDataSource("java:comp/env/jdbc/lm");
        return dataSource;
    }

    // Local dev Instance
    @Bean(name="dataSource")
    @Profile("dev")
    public DataSource devDataSource()
    {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("classpath:schema.sql")
                .addScript("classpath:data.sql")
                .build();
    }

    @Bean
    @Profile("dev")
    public PlatformTransactionManager devtxManager() {
        return new DataSourceTransactionManager(devDataSource());
    }

    @Bean
    @Profile("production")
    public PlatformTransactionManager prodtxManager() {
        return new DataSourceTransactionManager(prodDataSource());
    }
}
