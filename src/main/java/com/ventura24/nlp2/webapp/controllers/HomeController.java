package com.ventura24.nlp2.webapp.controllers;

import com.ventura24.nlp2.webapp.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetailsService;
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

    private UserDetailsService userDetailsService;

    private UserDao userDao;

    private static final Logger LOGGER = LoggerFactory.getLogger("HomeController");

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView showHome(Locale locale, ModelAndView model,Principal principal) {
        model.addObject("title", messageSource.getMessage("label.home.title",null, locale));
        model.addObject("message", messageSource.getMessage("label.home.msg",null, locale));
        model.setViewName("home");

        if (null != principal) {
            Long id = userDao.findIdByUserName(principal.getName());
            model.addObject("userid",id);
            LOGGER.info("User {} connected with id {}",principal.getName(),id);
        }
        /*
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            LOGGER.info(" success for user {}",userDetail.getUsername());
            LOGGER.info(" success for user {}", principal.getName());
        }
        */

        LOGGER.info("Entering home ");
        return model;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) { this.userDetailsService = userDetailsService;}

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
