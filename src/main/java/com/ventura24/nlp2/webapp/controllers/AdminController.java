package com.ventura24.nlp2.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by josetesan on 30/12/14.
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Login Form - Database Authentication");
        model.addObject("message", "This page is for IT only!");
        model.setViewName("admin");
        return model;

    }
}
