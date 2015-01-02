package com.ventura24.nlp.webapp.controllers;

import com.ventura24.nlp2.webapp.controllers.HomeController;
import com.ventura24.nlp2.webapp.controllers.LoginController;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
/**
 * Created by josetesan on 30/12/14.
 */

@ActiveProfiles("dev")
public class BasicControllersTest {



    @Test
    public void testHomeController() throws Exception
    {
        MessageSource ms = Mockito.mock(MessageSource.class);
        HomeController homeController  = new HomeController();
        homeController.setMessageSource(ms);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        mockMvc.perform(get("/"))
                        .andExpect(view().name("home"));


    }

    @Test
    @Ignore
    public void testLoginController() throws Exception
    {
        LoginController loginController = new LoginController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
        mockMvc.perform(get("/login"))
                         .andExpect(
                                 view().name("login"));
    }
}
