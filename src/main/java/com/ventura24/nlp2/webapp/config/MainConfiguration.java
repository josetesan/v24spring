package com.ventura24.nlp2.webapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by josetesan on 29/12/14.
 */
@Configuration
@ComponentScan(basePackages = "com.ventura24.nlp2.webapp")
@Import({ DbConfiguration.class, Security.class ,  WebConfiguration.class})
@ActiveProfiles("dev")
public class MainConfiguration {


}
