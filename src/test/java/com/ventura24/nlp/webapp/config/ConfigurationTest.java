package com.ventura24.nlp.webapp.config;

import com.ventura24.nlp2.webapp.config.DbConfiguration;
import com.ventura24.nlp2.webapp.config.WebConfiguration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by josetesan on 29/12/14.
 */

@ContextConfiguration(classes = DbConfiguration.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ConfigurationTest {

    @Autowired
    private DataSource dataSource;

    @BeforeClass
    public static void createMockJndiRealm() throws Exception
    {
        SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
        DataSource ds = new DriverManagerDataSource("jdbc:oracle:thin:@//localhost:49161/xe","system","oracle");
        builder.bind("java:comp/env/jdbc/MyLocalDB", ds);
        builder.activate();
    }

    @Test
    public void testCanUseDatabase()
    {
        try {
            Assert.assertNotNull(dataSource);

            Connection connection = dataSource.getConnection();
            Assert.assertNotNull(connection);

            connection.close();
        } catch (final Throwable t)
        {
            Assert.fail(t.getMessage());
        }

    }
}
