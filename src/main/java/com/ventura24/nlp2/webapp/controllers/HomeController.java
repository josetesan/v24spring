package com.ventura24.nlp2.webapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Locale;

/**
 * Created by josetesan on 16/12/14.
 */
@Controller
public class HomeController {

    private MessageSource messageSource;

    private Logger LOGGER = LoggerFactory.getLogger("HomeController");

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView showHome(Locale locale, ModelAndView model,Principal principal) {
        model.addObject("title", messageSource.getMessage("label.home.title",null, locale));
        model.addObject("message", messageSource.getMessage("label.home.msg",null, locale));
        model.setViewName("home");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            LOGGER.info(" success for user {}",userDetail.getUsername());
            LOGGER.info(" success for user {}",principal.getName());
        }

        LOGGER.info("Entering home");
        return model;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

}
