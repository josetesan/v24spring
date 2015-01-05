package com.ventura24.nlp2.webapp.controllers;

import com.ventura24.nlp2.webapp.dao.AuthoritiesDao;
import com.ventura24.nlp2.webapp.dao.UserDao;
import com.ventura24.nlp2.webapp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by josete on 3/1/15.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    private static final Logger LOGGER = LoggerFactory.getLogger("RegisterController");

    private UserDao userDao;
    private AuthoritiesDao authoritiesDao;

    @RequestMapping(method = RequestMethod.GET)
    public String loadRegistrationScreen(Locale locale,Model model)   {

        LOGGER.info("Reaching /register screen");
        model.addAttribute("user",new User());
        return "/register";

    }


    @RequestMapping(method = RequestMethod.POST)
    @Transactional
    public String saveRegistration(@Valid User user, BindingResult result,Model model)
    {
        if (result.hasErrors()) {
            LOGGER.warn("Could not register, has {} errors",result.getErrorCount()) ;
            return "/register";
        }   else {
            Long id = userDao.saveUser(user);
            authoritiesDao.saveAuthority(user.getName(),"user");
            LOGGER.info("Successfully saved user with id {}",id);
            model.addAttribute("msg", "You have been properly registered.Please log-in");
            return "redirect:login";
        }
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setAuthoritiesDao(AuthoritiesDao authoritiesDao) {
        this.authoritiesDao = authoritiesDao;
    }
}
