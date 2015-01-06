package com.ventura24.nlp2.webapp;

import com.ventura24.nlp2.webapp.config.MainConfiguration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by josetesan on 30/12/14.
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitializer() {
        super(MainConfiguration.class);
    }

}
