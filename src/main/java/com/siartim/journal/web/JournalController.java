package com.siartim.journal.web;

import com.siartim.journal.model.JournalEntry;
import com.siartim.journal.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by a9jr5626 on 8/8/16.
 */
@Controller
public class JournalController {

    @Autowired
    JournalService service;

    @RequestMapping(value = "/journal", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public
    @ResponseBody
    List<JournalEntry> getJournal() {
        return service.findAll();
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("journal", service.findAll());
        return "index";
    }
}
