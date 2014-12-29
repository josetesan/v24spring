package com.ventura24.nlp2.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by josetesan on 16/12/14.
 */
@Controller
public class LoginController extends WebMvcConfigurerAdapter {

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/results").setViewName("results");
//    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String showForm() {
        return "login";
    }


}
