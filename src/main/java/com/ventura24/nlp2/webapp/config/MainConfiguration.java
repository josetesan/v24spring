package com.ventura24.nlp2.webapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by josetesan on 29/12/14.
 */
@Configuration
@ComponentScan(basePackages = "com.ventura24.nlp2.webapp")
@Import({ DbProdConfiguration.class,DbDevConfiguration.class, Security.class ,  WebConfiguration.class, WebflowConfiguration.class})
public class MainConfiguration {


}
