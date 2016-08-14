package com.siartim.journal.web;

import com.siartim.journal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by a9jr5626 on 8/8/16.
 */
@RestController
public class JournalController {

    @Autowired
    JournalRepository repo;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject("journal", repo.findAll());
        return modelAndView;
    }

    @RequestMapping(value="/report", method = RequestMethod.GET)
    public ModelAndView report(ModelAndView modelAndView){
        modelAndView.setViewName("report");
        modelAndView.addObject("journal", repo.findAll());
        return modelAndView;
    }
}