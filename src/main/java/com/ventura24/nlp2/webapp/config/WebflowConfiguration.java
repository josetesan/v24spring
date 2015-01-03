package com.ventura24.nlp2.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.executor.FlowExecutor;

/**
 * Created by josete on 3/1/15.
 */
@Configuration
public class WebflowConfiguration extends AbstractFlowConfiguration {

    @Bean(name="flowRegistry")
    public FlowDefinitionRegistry flowRegistry()
    {
           return getFlowDefinitionRegistryBuilder()
                   .setBasePath("/WEB-INF/flows")
                   .addFlowLocationPattern("/*-flow.xml")
                   .build();
    }

    @Bean(name="flowExecutor")
    public FlowExecutor flowExecutor()
    {
        return getFlowExecutorBuilder(flowRegistry()).build();
    }
}
