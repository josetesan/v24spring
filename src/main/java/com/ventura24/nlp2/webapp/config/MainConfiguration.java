package com.ventura24.nlp2.webapp.config;

import com.ventura24.nlp2.webapp.config.dev.DbDevConfiguration;
import com.ventura24.nlp2.webapp.config.dev.DevSecurity;
import com.ventura24.nlp2.webapp.config.dev.EmbeddedRedisConfiguration;
import com.ventura24.nlp2.webapp.config.production.DbProdConfiguration;
import com.ventura24.nlp2.webapp.config.production.ProdSecurity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by josetesan on 29/12/14.
 */
@Configuration
@ComponentScan(basePackages = "com.ventura24.nlp2.webapp")
@Import({ DbProdConfiguration.class,
        DbDevConfiguration.class,
        DevSecurity.class ,
        ProdSecurity.class,
        WebConfiguration.class,
        WebflowConfiguration.class,
        EmbeddedRedisConfiguration.class})
public class MainConfiguration {


}
