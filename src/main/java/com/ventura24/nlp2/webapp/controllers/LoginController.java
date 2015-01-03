package com.ventura24.nlp2.webapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;


/**
 * Created by josetesan on 30/12/14.
 */
@Controller
public class LoginController {

    private Logger LOGGER = LoggerFactory.getLogger("LoginController");


    /**
     *
     * @param logout
     * @param error
     * @param locale
     * @param model
     * @return
     */
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String showLogin(@RequestParam(value = "logout", required = false) String logout,
                            @RequestParam(value="error",required = false) String error,
                                  Locale locale, Model model) {


        LOGGER.info("Arrived /login controller ");
        if (null != logout)
        {
            LOGGER.info("User successfuly logged out");
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        if (null != error)
        {
            LOGGER.warn("Invalid  login  , please retry");
            model.addAttribute("error","Invalid login, please retry");
        }


        return "login";
    }



/*
    @RequestMapping(value="/success", method = RequestMethod.GET)
    public String enter()
    {
        LOGGER.info("Entering /success");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            LOGGER.info(" success for user {}",userDetail.getUsername());
        }

        return "success";
    }
      */
    /*
    @ModelAttribute("webFrameworkList")
    public List<String> populateWebFrameworkList() {

        //Data referencing for web framework checkboxes
        List<String> webFrameworkList = new ArrayList<String>();
        webFrameworkList.add("Spring MVC");
        webFrameworkList.add("Struts 1");
        webFrameworkList.add("Struts 2");
        webFrameworkList.add("JSF");
        webFrameworkList.add("Apache Tapestry");

        return webFrameworkList;
    }
      */

}
