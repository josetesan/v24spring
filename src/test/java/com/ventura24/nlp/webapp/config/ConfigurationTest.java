package com.ventura24.nlp.webapp.config;

import com.ventura24.nlp2.webapp.config.DbDevConfiguration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by josetesan on 29/12/14.
 */

@ContextConfiguration(classes = DbDevConfiguration.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("production")
public class ConfigurationTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private DataSource loginDataSource;

    @BeforeClass
    public static void createMockJndiRealm() throws Exception
    {
        SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
        final DataSource ds = new DriverManagerDataSource("jdbc:oracle:thin:@//db-es-06-mad.office.ventura24.es/DESA_RW","OC_JSANC","OC_JSANC");
        builder.bind("java:comp/env/jdbc/nlp", ds);
	final DataSource lmDs = new DriverManagerDataSource("jdbc:oracle:thin:@//db-es-06-mad.office.ventura24.es/DESA_RW","loginmodule","LOGINMODULE");
        builder.bind("java:comp/env/jdbc/lm",lmDs);
        builder.activate();
    }

    @Test
    public void testCanUseMainDatabase()
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

    @Test
    public void testCanUseLMDatabase()
    {
        try {
            Assert.assertNotNull(loginDataSource);

            Connection connection = loginDataSource.getConnection();
            Assert.assertNotNull(connection);

            connection.close();
        } catch (final Throwable t)
        {
            Assert.fail(t.getMessage());
        }

    }
}
