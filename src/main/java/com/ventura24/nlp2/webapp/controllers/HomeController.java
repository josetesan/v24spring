package com.ventura24.nlp2.webapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Locale;

/**
 * Created by josetesan on 16/12/14.
 */
@Controller
public class HomeController {

    private MessageSource messageSource;

    private Logger LOGGER = LoggerFactory.getLogger("HomeController");

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView showHome(Locale locale, ModelAndView model) {
        model.addObject("title", messageSource.getMessage("label.home.title",null, locale));
        model.addObject("message", messageSource.getMessage("label.home.msg",null, locale));
        model.setViewName("home");
        LOGGER.info("Entering home");
        return model;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
