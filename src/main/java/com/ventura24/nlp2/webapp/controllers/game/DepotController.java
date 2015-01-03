package com.ventura24.nlp2.webapp.controllers.game;

import com.ventura24.nlp2.webapp.dao.DepotRepository;
import com.ventura24.nlp2.webapp.model.Depot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

/**
 * Created by josete on 3/1/15.
 */
@RestController
@RequestMapping(value = "/game/depot")
public class DepotController {

    private Logger LOGGER = LoggerFactory.getLogger("DepotController");

    @Autowired
    private DepotRepository depotRepository;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value="/{userid}",method = RequestMethod.GET)
    public @ResponseBody
    String getUserDepots(@PathVariable("userid") final Long userid, Model model,Locale locale) {

        model.addAttribute("title",messageSource.getMessage("depot.title",
                new Object[]{userid},
                locale));

        LOGGER.info("Arriving depot controller for user {}",userid);
        final List<Depot> depots = depotRepository.findByUserid(userid);
        LOGGER.info("Retrieved {} depots for user {}",depots.size(),userid);
        model.addAttribute("depots",depots) ;
        return "game/depot";
    }
}
