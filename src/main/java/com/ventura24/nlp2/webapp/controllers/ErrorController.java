package com.ventura24.nlp2.webapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by josete on 3/1/15.
 */
@Controller
@RequestMapping(value = "/error", method = RequestMethod.GET)
public class ErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger("ErrorController");

    @RequestMapping(value = "/403")
    public String handleError403(Model model)
    {
        LOGGER.info("Arriving to /error/403");

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addAttribute("username", userDetail.getUsername());
        }

        return "redirect:/error/403";
    }

    @RequestMapping(value = "/500")
    public String handleError500(Model model)
    {
        LOGGER.info("Arriving to /error/500");

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addAttribute("username", userDetail.getUsername());
        }

        return "redirect:/error/500";
    }
}
