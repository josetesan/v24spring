package com.ventura24.nlp2.webapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;


/**
 * Created by josetesan on 30/12/14.
 */
@Controller
public class LoginController {

    private Logger LOGGER = LoggerFactory.getLogger("LoginController");

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public ModelAndView showLogin(Locale locale, ModelAndView modelAndView) {
        LOGGER.info("Arrived /login controller");
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value="/success", method = RequestMethod.GET)
    public String enter()
    {
        LOGGER.info("Entering /success");
        return "success";
    }

    //for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
        LOGGER.info("Arriving /403 controller");
        ModelAndView model = new ModelAndView();

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }

        model.setViewName("403");
        return model;

    }
}
