package com.ventura24.nlp2.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Locale;

/**
 * Created by josetesan on 16/12/14.
 */
@Controller
public class HomeController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String showHome(Locale locale, Model model) {
        model.addAttribute("title","Spring Security Login Form - Database Authentication");
        model.addAttribute("message","This is the default page!");
        return "hello";
    }

}
