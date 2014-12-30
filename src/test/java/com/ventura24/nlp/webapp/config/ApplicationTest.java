package com.ventura24.nlp.webapp.config;

import com.ventura24.nlp2.webapp.config.WebConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.testSecurityContext;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by josetesan on 29/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfiguration.class)
@WebAppConfiguration
@TestExecutionListeners(listeners={ServletTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        WithSecurityContextTestExecutionListener.class})
public class ApplicationTest {
    private MockMvc mvc;


    @Autowired
    private WebApplicationContext context;

    @Autowired
    private Filter springSecurityFilterChain;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilters(springSecurityFilterChain)
                .defaultRequest(get("/").with(testSecurityContext()))
                .build();
    }

    @Test
    public void requestProtectedResourceRequiresAuthentication() throws Exception {
        mvc.perform(get("/"))
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void loginSuccess() throws Exception {
        mvc.perform(formLogin())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void loginFailure() throws Exception {
        mvc.perform(formLogin().password("invalid"))
                .andExpect(redirectedUrl("/login?error"));
    }

    @Test
    @WithMockUser
    public void requestProtectedResourceWithUser() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void composeMessageRequiresCsrfToken() throws Exception {
        MockHttpServletRequestBuilder composeMessage =
                post("/")
                        .param("summary", "New Message")
                        .param("text", "This is a new message");

        mvc.perform(composeMessage)
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    public void composeMessage() throws Exception {
        MockHttpServletRequestBuilder composeMessage =
                post("/")
                        .param("summary", "New Message")
                        .param("text", "This is a new message")
                        .with(csrf());

        mvc.perform(composeMessage)
                .andExpect(redirectedUrlPattern("/*"));
    }

    @Test
    @WithMockUser
    public void logoutRequiresCsrfToken() throws Exception {
        mvc.perform(post("/logout"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    public void logoutSuccess() throws Exception {
        mvc.perform(logout())
                .andExpect(redirectedUrl("/login?logout"))
                .andExpect(unauthenticated());
    }

}
