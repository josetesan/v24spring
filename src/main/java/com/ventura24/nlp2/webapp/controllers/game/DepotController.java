package com.ventura24.nlp2.webapp.controllers.game;

import com.ventura24.nlp2.webapp.dao.DepotRepository;
import com.ventura24.nlp2.webapp.dao.GProductsDao;
import com.ventura24.nlp2.webapp.model.Depot;
import com.ventura24.nlp2.webapp.model.GProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Locale;

/**
 * Created by josete on 3/1/15.
 */
@Controller
@RequestMapping(value = "/game/depot")
public class DepotController {

    private static final Logger LOGGER = LoggerFactory.getLogger("DepotController");

    @Autowired
    private DepotRepository depotRepository;

    @Autowired
    private GProductsDao gProductsDao;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value="/{userid}",method = RequestMethod.GET)
    @Secured("isAuthenticated()")
    public String getUserDepots(@PathVariable("userid") final Long userid, Model model,Locale locale) {

        model.addAttribute("title",messageSource.getMessage("depot.title",
                new Object[]{userid},
                locale));

        LOGGER.info("Arriving depot controller for user {}",userid);
//        final List<Depot> depots = depotRepository.findAllByUserid(userid);
        final List<GProduct> depots = gProductsDao.findGProductsByUser(userid);
        LOGGER.info("Retrieved {} depots for user {}",depots.size(),userid);
        model.addAttribute("depots",depots) ;
//        return "game/depot";
        return "game/production_depot";
    }
}
