package com.ventura24.nlp2.webapp;

import com.ventura24.nlp2.webapp.config.DbConfiguration;
import com.ventura24.nlp2.webapp.config.MainConfiguration;
import com.ventura24.nlp2.webapp.config.Security;
import com.ventura24.nlp2.webapp.config.WebConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by josetesan on 30/12/14.
 */
public class SpringMVCInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class[] {MainConfiguration.class, Security.class, DbConfiguration.class, WebConfiguration.class};
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return null;
        }

        @Override
        protected String[] getServletMappings() {
            return new String[] { "/" };
        }

}
