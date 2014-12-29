package com.ventura24.nlp.webapp;

import com.ventura24.nlp2.webapp.config.WebConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by josetesan on 29/12/14.
 */

@ContextConfiguration(classes = WebConfiguration.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ConfigurationTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testCanUseDatabase() throws Exception
    {
        Connection connection = dataSource.getConnection();
        Assert.assertNotNull(connection);

        Properties properties = connection.getClientInfo();
        Assert.assertFalse(properties.isEmpty());

    }
}
