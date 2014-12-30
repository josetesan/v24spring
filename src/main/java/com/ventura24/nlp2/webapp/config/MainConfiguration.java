package com.ventura24.nlp2.webapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by josetesan on 29/12/14.
 */
@Configuration
@ComponentScan(basePackages = "com.ventura24.nlp2.webapp")
@Import({ SecurityConfig.class , DbConfiguration.class, WebConfiguration.class})
public class MainConfiguration {


}
